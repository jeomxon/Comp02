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
			// toExternalForm() 메소드는 전체 URL의 문자열 객체를 리턴하는 메소드이다.
			// toString()과 유사
			scene.getStylesheets().add(getClass().getResource("LoginForm.css").toExternalForm());
			primaryStage.setTitle("CSS 연습");
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
