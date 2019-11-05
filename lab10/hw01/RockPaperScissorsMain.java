/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.11.05
 * 목적  : 가위바위보 게임을 GUI로 구현
 *
 ***************************/

package lab10.hw01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RockPaperScissorsMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
		Parent root = FXMLLoader.load(getClass().getResource("RockPaperScissors.fxml"));
		primaryStage.setTitle("가위 바위 보");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
