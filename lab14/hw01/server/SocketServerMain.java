package lab14.hw01.server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SocketServerMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SocketServer.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("ä�� ����");
        primaryStage.setScene(new Scene(root));
        SocketServerController controller = loader.getController();
        primaryStage.setOnCloseRequest(event -> controller.stopServer());
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
