package lab11.prtc01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
			Scene scene = new Scene(root);
			// toExternalForm() �޼ҵ�� ��ü URL�� ���ڿ� ��ü�� �����ϴ� �޼ҵ��̴�.
			// toString()�� ����
			scene.getStylesheets().add(getClass().getResource("LoginForm.css").toExternalForm());
			primaryStage.setTitle("CSS ����");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
