/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.12.03
 * ����  : client�� server�� ���� ä�� �ý��� ����
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
    // ������� ���� ó���� �� ��� ��õ ���� Ŭ���̾�Ʈ�� ���ÿ� ����Ǹ�
    // �������� ��õ ���� �����尡 �����Ǳ� ������ ���� ������ �ް��� ���ϵǰ�,
    // �ٿ�Ǵ� ������ �߻��� �� �ִ�.
    // Ŭ���̾�Ʈ�� �������� ���� ������ ������ ������ ������ �����Ϸ���
    // ������Ǯ�� ����ϴ� ���� �ٶ����ϴ�.
    ExecutorService service;            // ������Ǯ
    public Label statusLabel;           // ���� ������ ��
    // ����Ʈ���� �� �������� ������ �涧 �ٹٲ޵� ���·� �����ֱ� ����
    // String�� �ƴ� Text�� ����Ͽ���.
    public ListView<Text> chatView;     // ä�� ��� ����Ʈ��
    public ToggleButton serverButton;   // ���� ����, ���� ��� ��ư

    // Ŭ���̾�Ʈ ���: ArrayList�� ������� �ʰ�
    // �����忡 �����ϰ� �ϱ� ���� Vector�� ����Ͽ���.
    private List<Client> clientList = new Vector<>();
    // ä�� ������
    private ObservableList<Text> logList;
    private ServerSocket serverSocket;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logList = FXCollections.observableArrayList();
        chatView.setItems(logList);
        statusLabel.setText(String.valueOf(clientList.size()));
    } // initialize�޼ҵ� ������

    public void serverAction(ActionEvent actionEvent) {
        if (serverButton.isSelected()) {
            startServer();
        } else {
            stopServer();
        }
    } // ���� ��ư�� ������ ������ ���۵�

    void startServer() {
        // CPU �ھ��� ����ŭ �����带 ���鵵�� �Ѵ�.
        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), Executors.defaultThreadFactory());
        try {
        	serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8888)); // ���������� �����ϰ� ��Ʈ�� ���ε���Ų��.
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
                    logList.add(new Text("[" + currentTime() + "]\n���� ����"));
                    serverButton.setText("����");
                }); // ������ ���۵Ǿ��ٴ� �ؽ�Ʈ�� add�ϰ� button�� ������ ���ᰡ �Ǵ� ���� ��Ÿ���� ���ؼ� ����� �ؽ�Ʈ ������ �ٲ���
                while (true) {
                    try {
                        Socket socket = serverSocket.accept();  // ���� ����
                        Platform.runLater(() -> addMessage( "[" + currentTime() + " - " + socket.getRemoteSocketAddress() + "]\n�������")); // ������ �����Ͽ� �޽��� ���
                        clientList.add(new Client(socket));
                        // ���� �����ڼ� ������Ʈ
                        Platform.runLater(() -> statusLabel.setText(String.valueOf(clientList.size())));
                    } catch (Exception e) {
                        if (!serverSocket.isClosed()) {
                            stopServer();
                        }
                        break;
                    }

                }
            } // run�޼ҵ� ������ 
        };
        // ������ Ǯ���� ó��
        service.submit(runnable);
    }

    void stopServer() {
        try {
            Iterator<Client> iterator = clientList.iterator();
            while (iterator.hasNext()) {
                iterator.next().socket.close();
                iterator.remove();
            } // Ŭ���̾�ƮList�� �ݺ��ڷ� �����鼭 socket�� �ݰ� �ݺ��ڸ� ����, �� Ŭ���̾�Ʈ�� ������ ����
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
                addMessage("[" + currentTime() + "]\n���� ����");
                serverButton.setText("����");
            }); // �������� �޽����� ����ϰ� �������� ��ư�� �ؽ�Ʈ�� �ٲ���
        }
    }

    /**
     * ���� �ð��� ��ȯ�ϴ� �޼ҵ�
     * @return ����ð�
     */
    private String currentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    } // ����Ͻð��� return���ִ� �޼ҵ�

    /**
     * �޽����� ä�� ��Ͽ� �߰��ϴ� �޼ҵ�
     * @param msg
     */
    private void addMessage(String msg) {
        Text text = new Text(msg);
        // ä�ú��� �ʺ� �°� �ڵ����� ������ �ٹٲ����ִ� ���ε��� �����Ѵ�.
        text.wrappingWidthProperty().bind(new DoubleBinding() {
            @Override
            protected double computeValue() {
                return chatView.getPrefWidth();
            }
        });
        logList.add(text); // �ؽ�Ʈ�� ����Ʈ�� �߰�
        chatView.scrollTo(logList.size()); // ��ũ�� �߰�
    }

    class Client {
        Socket socket;

        public Client(Socket socket) {
            this.socket = socket;
            receive();
        } // Ŭ���̾�Ʈ ������

        /**
         * Ŭ���̾�Ʈ�κ��� ������ �ޱ�
         */
        private void receive() {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            byte[] bytes = new byte[256];
                            InputStream inputStream = socket.getInputStream();
                            // Ŭ���̾�Ʈ�� ������ ���Ḧ ���� ��� IOException �߻�
                            int readByteCount = inputStream.read(bytes);
                            // Ŭ���̾�Ʈ�� ���������� Socket�� close()�� ȣ������ ���
                            if (readByteCount == -1) {
                                throw new IOException("Ŭ���̾�Ʈ ����");
                            } // inputStream�� �о��� �� ���� ������ -1�̱� ������ client�� �����Ŵ
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
         * Ŭ���̾�Ʈ�� ������ ������
         * @param msg
         */
        private void send(String msg) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
                        OutputStream outputStream = socket.getOutputStream(); // ���Ͽ� OutputStream�� ������
                        outputStream.write(bytes);
                        outputStream.flush(); // outputStream�� �����
                    } catch (IOException e) {
                        e.printStackTrace();
                        disconnectClient(null);
                    }
                }
            };
            service.submit(runnable);
        } // ������ ���� �޼ҵ�

        /**
         * Ŭ���̾�Ʈ�� ����� �ȵ� �� ���� Ŭ���̾�Ʈ ����
         */
        private void disconnectClient(String errorMsg) {
            try {
                clientList.remove(Client.this);
                Platform.runLater(() -> {
                    String msg = "[" + currentTime() + " - " + socket.getRemoteSocketAddress() + "]\n" + (errorMsg != null ? errorMsg : "Ŭ���̾�Ʈ ��� �ȵ�");
                    addMessage(msg); // ������ �������� �ð� ���� ǥ�����ִ� ���� add���־� client�� ������ �������� ���
                    statusLabel.setText(String.valueOf(clientList.size())); // ������ �� ǥ��
                });
                socket.close(); // ������ �ݾ��ش�.
            } catch (IOException e) {
                e.printStackTrace();
            }

        } // Ŭ���̾�Ʈ�� ������ ���� �޼ҵ�
    }
}
