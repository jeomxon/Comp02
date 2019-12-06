/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.12.03
 * 목적  : client와 server를 통해 채팅 시스템 구현
 *
 ***************************/

package lab14.hw01.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class SocketClientController implements Initializable {
    public VBox chatPane;
    public ListView<Text> chatView;
    public TextField messageField;
    public Button sendButton;

    private ObservableList<Text> chatList;
    private String address;
    private int portNumber;
    private String nickname;
    private Socket socket; // 필드 선언

    public SocketClientController(String address, int portNumber, String nickname) {
        this.address = address;
        this.portNumber = portNumber;
        this.nickname = nickname;
    } // 생성자, address와 portNumber, nickname을 받아서 필드에 초기화 시켜줌

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chatList = FXCollections.observableArrayList(); // 텍스트를 List로 나타내기 위함
        chatView.setItems(chatList); // 리스트뷰에 setItems라는 메소드를 통해 chatList를 설정해줌
        messageField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 0) {
                sendButton.setDisable(false);
            } else {
                sendButton.setDisable(true);
            }
        }); // 람다 표현식을 통해서 식을 간단하게 나타냄, 3개의 인자가 전달될 때 조건을 걸어서 newValue가 0보다 크면 sendButton이 가능하도록하였음
        messageField.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                sendAction();
            }
        }); // 람다 표현식을 통해서 식을 간단하게 나타냄, event라는 인자가 전달될 때 ENTER키를 입력하면 sendAction()메소드가 실행되도록 설정
        startClient();
    } // initialize메소드 재정의

    public void closeAction() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } // closeAction()이라는 메소드이기 때문에 socket이 null이 아니거나 isClosed된 상태가 아니라면 socket을 닫아준다.
        Platform.runLater(() -> {
            addMessage("[종료됨]");
            sendButton.setDisable(true);
        }); // 종료되었다는 메시지를 출력해주고 setDisable이라는 메소드를 통해서 sendButton을 비활성화 시켜준다. 
        StackPane root = (StackPane) chatPane.getScene().getRoot();
        // 화면 이동시 애니메이션
        chatPane.setTranslateY(0);  // 시작값을 화면 높이만큼 설정

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(chatPane.translateYProperty(), root.getHeight());
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), event -> {
            // stackPane에 채팅화면을 올린다.
            root.getChildren().remove(chatPane);
        }, keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
    
    public void sendAction() {
        send(messageField.getText());
    } // 텍스트 필드에 있는 문자를 가져와서 send하는 메소드

    void startClient() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                	socket = new Socket();
                    socket.connect(new InetSocketAddress(address, portNumber)); // 소켓을 연결
                    Platform.runLater(() -> {
                        addMessage("[연결됨]");
                    }); // 연결 이후 메시지 출력
                } catch (IOException e) {
                    disconnectServer();
                }
                receive();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start(); // 스레드 생성 후 스레드에게 start하도록 함
    }

    void receive() {
        while (true) {
            try {
                byte[] bytes = new byte[512];
                InputStream inputStream = socket.getInputStream();
                // 서버가 비정상적으로 종료했을 경우 IOException 발생
                int readByteCount = inputStream.read(bytes);
                // 서버가 정상적으로 Socket의 close()를 호출했을 경우
                if (readByteCount == -1) {
                    throw new IOException();
                } // -1이면 없다는 의미이므로 예외 발생
                String data = new String(bytes, 0, readByteCount, StandardCharsets.UTF_8);
                Platform.runLater(() -> {
                    addMessage(data);
                }); // 스레드에 맞춰서 data를 add해줌
            } catch (IOException e) {
                disconnectServer();
                break;
            }
        }
    }

    void send(String msg) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] bytes = (nickname + ": " + msg).getBytes(StandardCharsets.UTF_8);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(bytes); 
                    outputStream.flush(); // stream을 비워줌
                    Platform.runLater(() -> {
                        messageField.setText("");
                        messageField.requestFocus();
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                    disconnectServer(); // 예외발생 시에 서버랑 disconnect함
                }
            } // run() 메소드 재정의
        };
        Thread thread = new Thread(runnable);
        thread.start(); // 스레드 생성 후 start메소드 호출
    }

    void disconnectServer() {
        Platform.runLater(() -> addMessage("[서버 통신 안됨]")); // 서버 통신 안됨이라는 메시지를 출력
        if (!socket.isClosed()) {
        	closeAction();
        } // socket이 isClosed상태가 아니라면 closeAction()메소드를 통해 close함
    } // server와 연결을 끊는 메소드

    /**
     * 메시지를 채팅 목록에 추가하는 메소드
     * @param msg
     */
    private void addMessage(String msg) {
        Text text = new Text(msg);
        // 채팅뷰의 너비에 맞게 자동으로 내용을 줄바꿈해주는 바인딩을 설정한다.
        text.wrappingWidthProperty().bind(new DoubleBinding() {
			@Override
			protected double computeValue() {
				return chatView.getPrefWidth();
			}
		});
        chatList.add(text); // List에 text를 추가
        chatView.scrollTo(chatList.size()); // 스크롤을 만들어줌
    }
}
