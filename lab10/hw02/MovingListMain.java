/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW02
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.11.05
 * ����  : �׸� �̵��� ���� GUI���α׷� ����
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
			primaryStage.setTitle("�׸� �̵�");
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
