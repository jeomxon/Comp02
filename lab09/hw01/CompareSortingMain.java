/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW02
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.10.29
 * 목적  : 간단한 설문조사 결과를 출력하는 GUI 프로그램
 *
 ***************************/

package lab09.hw01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CompareSortingMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("CompareSorting.fxml"));
		primaryStage.setTitle("정렬 알고리즘 비교");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
