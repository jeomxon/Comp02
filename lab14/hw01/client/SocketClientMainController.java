package lab14.hw01.client;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SocketClientMainController implements Initializable {
    public StackPane stackPane;
    public TextField addressField;
    public TextField portField;
    public TextField nicknameField;
    public Button connectionButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nicknameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 0) {
                    connectionButton.setDisable(false);
                } else {
                    connectionButton.setDisable(true);
                }
            }
        });
        // ������ �Է� �� ����Ű�� �Է����� �� ����
        nicknameField.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    connectAction();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void connectAction() throws IOException {
        if (addressField.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "������ ���� IP �Ǵ� ������ �ּҸ� �Է��ϼ���.", ButtonType.CLOSE).show();
            addressField.requestFocus();
            return;
        }
        if (portField.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "������ ��Ʈ ��ȣ�� �Է��ϼ���.", ButtonType.CLOSE).show();
            portField.requestFocus();
            return;
        }

        // ȭ�� �̵��� �Ķ���͸� �ѱ�� ���
        // FXMLLoader�� fxml ������ �����Ѵ�.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SocketClient.fxml"));
        // �Ķ���ͷ� �ѱ� �� ����
        String address = addressField.getText();
        int portNumber = Integer.parseInt(portField.getText());
        String nickname = nicknameField.getText();
        // fxml ������ �ε��� �� ��Ʈ�ѷ��� �����ؼ� �ε��Ѵ�.
        // �� �� �����ϰ��� �ϴ� ���� SocketClientController �����ڿ� �־��ش�.
        loader.setControllerFactory(param -> new SocketClientController(address, portNumber, nickname));
        // ȭ�� ��ȯ
        VBox chatPane = loader.load();

        // ���������� �������� ���� ��� Ŭ���̾�Ʈ ����
        Stage stage = (Stage) stackPane.getScene().getWindow();
        SocketClientController controller = loader.getController();
        stage.setOnCloseRequest(event -> controller.disconnectServer());

        // stackPane�� ä��ȭ���� �ø���.
        stackPane.getChildren().add(chatPane);
        // ȭ�� �̵��� �ִϸ��̼�
        chatPane.setTranslateY(stackPane.getHeight());  // ���۰��� ȭ�� ���̸�ŭ ����

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(chatPane.translateYProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}
