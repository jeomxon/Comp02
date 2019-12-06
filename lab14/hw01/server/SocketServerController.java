/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.12.03
 * 목적  : client와 server를 통해 채팅 시스템 구현
 *
 ***************************/

package lab14.hw01.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

public class SocketServerController implements Initializable {
    // 스레드로 병렬 처리를 할 경우 수천 개의 클라이언트가 동시에 연결되면
    // 서버에서 수천 개의 스레드가 생성되기 때문에 서버 성능이 급격히 저하되고,
    // 다운되는 현상이 발생할 수 있다.
    // 클라이언트의 폭증으로 인해 서버의 과도한 스레드 생성을 방지하려면
    // 스레드풀을 사용하는 것이 바람직하다.
    ExecutorService service;            // 스레드풀
    public Label statusLabel;           // 현재 접속자 수
    // 리스트뷰의 한 아이템이 내용이 길때 줄바꿈된 형태로 보여주기 위해
    // String이 아닌 Text를 사용하였다.
    public ListView<Text> chatView;     // 채팅 목록 리스트뷰
    public ToggleButton serverButton;   // 서버 시작, 종료 토글 버튼

    // 클라이언트 목록: ArrayList를 사용하지 않고
    // 스레드에 안전하게 하기 위해 Vector를 사용하였다.
    private List<Client> clientList = new Vector<>();
    // 채팅 데이터
    private ObservableList<Text> logList;
    private ServerSocket serverSocket;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logList = FXCollections.observableArrayList();
        chatView.setItems(logList);
        statusLabel.setText(String.valueOf(clientList.size()));
    } // initialize메소드 재정의

    public void serverAction(ActionEvent actionEvent) {
        if (serverButton.isSelected()) {
            startServer();
        } else {
            stopServer();
        }
    } // 서버 버튼을 누르면 서버가 시작됨

    void startServer() {
        // CPU 코어의 수만큼 스레드를 만들도록 한다.
        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), Executors.defaultThreadFactory());
        try {
        	serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8888)); // 서버소켓을 생성하고 포트에 바인딩시킨다.
        } catch (IOException e) {
            e.printStackTrace();
            if (!serverSocket.isClosed()) {
                stopServer();
            }
            return;
        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    logList.add(new Text("[" + currentTime() + "]\n서버 시작"));
                    serverButton.setText("종료");
                }); // 서버가 시작되었다는 텍스트를 add하고 button을 누르면 종료가 되는 것을 나타내기 위해서 종료로 텍스트 설정을 바꿔줌
                while (true) {
                    try {
                        Socket socket = serverSocket.accept();  // 연결 수락
                        Platform.runLater(() -> addMessage( "[" + currentTime() + " - " + socket.getRemoteSocketAddress() + "]\n연결수락")); // 연결을 수락하여 메시지 출력
                        clientList.add(new Client(socket));
                        // 현재 접속자수 업데이트
                        Platform.runLater(() -> statusLabel.setText(String.valueOf(clientList.size())));
                    } catch (Exception e) {
                        if (!serverSocket.isClosed()) {
                            stopServer();
                        }
                        break;
                    }

                }
            } // run메소드 재정의 
        };
        // 스레드 풀에서 처리
        service.submit(runnable);
    }

    void stopServer() {
        try {
            Iterator<Client> iterator = clientList.iterator();
            while (iterator.hasNext()) {
                iterator.next().socket.close();
                iterator.remove();
            } // 클라이언트List를 반복자로 읽으면서 socket을 닫고 반복자를 없앰, 즉 클라이언트의 접속을 끊음
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            if (service != null && !service.isShutdown()) {
                service.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Platform.runLater(() -> {
                addMessage("[" + currentTime() + "]\n서버 종료");
                serverButton.setText("시작");
            }); // 서버종료 메시지를 출력하고 시작으로 버튼의 텍스트를 바꿔줌
        }
    }

    /**
     * 현재 시각을 반환하는 메소드
     * @return 현재시각
     */
    private String currentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    } // 년월일시간을 return해주는 메소드

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
        logList.add(text); // 텍스트를 리스트에 추가
        chatView.scrollTo(logList.size()); // 스크롤 추가
    }

    class Client {
        Socket socket;

        public Client(Socket socket) {
            this.socket = socket;
            receive();
        } // 클라이언트 생성자

        /**
         * 클라이언트로부터 데이터 받기
         */
        private void receive() {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            byte[] bytes = new byte[256];
                            InputStream inputStream = socket.getInputStream();
                            // 클라이언트가 비정상 종료를 했을 경우 IOException 발생
                            int readByteCount = inputStream.read(bytes);
                            // 클라이언트가 정상적으로 Socket의 close()를 호출했을 경우
                            if (readByteCount == -1) {
                                throw new IOException("클라이언트 종료");
                            } // inputStream을 읽었을 때 값이 없으면 -1이기 때문에 client를 종료시킴
                            String data = new String(bytes, 0, readByteCount, StandardCharsets.UTF_8);
                            Platform.runLater(() -> {
                                addMessage("[" + currentTime() + "]\n" + data);
                            });
                            for (Client client : clientList) {
                                client.send(data);
                            }
                        }
                    } catch (IOException e) {
                        disconnectClient(e.getMessage());
                    }
                }
            };
            service.submit(runnable);
        }

        /**
         * 클라이언트로 데이터 보내기
         * @param msg
         */
        private void send(String msg) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
                        OutputStream outputStream = socket.getOutputStream(); // 소켓에 OutputStream을 가져옴
                        outputStream.write(bytes);
                        outputStream.flush(); // outputStream을 비워줌
                    } catch (IOException e) {
                        e.printStackTrace();
                        disconnectClient(null);
                    }
                }
            };
            service.submit(runnable);
        } // 전송을 위한 메소드

        /**
         * 클라이언트와 통신이 안될 때 현재 클라이언트 제거
         */
        private void disconnectClient(String errorMsg) {
            try {
                clientList.remove(Client.this);
                Platform.runLater(() -> {
                    String msg = "[" + currentTime() + " - " + socket.getRemoteSocketAddress() + "]\n" + (errorMsg != null ? errorMsg : "클라이언트 통신 안됨");
                    addMessage(msg); // 위에서 설정해준 시간 등을 표시해주는 것을 add해주어 client의 접속이 끊어짐을 출력
                    statusLabel.setText(String.valueOf(clientList.size())); // 접속자 수 표시
                });
                socket.close(); // 소켓을 닫아준다.
            } catch (IOException e) {
                e.printStackTrace();
            }

        } // 클라이언트의 연결을 끊는 메소드
    }
}
