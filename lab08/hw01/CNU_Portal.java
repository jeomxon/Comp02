/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.10.22
 * 목적  : JavaFX를 이용한 FXML 충남대학교 포털 레이아웃
 *
 ***************************/

package lab08.hw01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CNU_Portal extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("PortalSample.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("충남대학교 포털");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
