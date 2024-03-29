/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW02
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.11.05
 * 목적  : 항목 이동을 위한 GUI프로그램 구현
 *
 ***************************/

package lab10.hw02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovingListMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MovingList.fxml"));
			primaryStage.setTitle("항목 이동");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
