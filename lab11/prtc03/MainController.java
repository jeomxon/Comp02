package lab11.prtc03;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class MainController {

	@FXML StackPane stackPane;

	@FXML public void moveToLogin() throws Exception {
		// ���� ����� ������ ����� ���� ������� ���������
		// �ٸ� ����� ������ src ���丮�� ��Ʈ�� �Ͽ� �����η� ǥ���Ѵ�.
		Parent login = FXMLLoader.load(getClass().getResource("/lab11/prtc01/LoginForm.fxml"));
		stackPane.getChildren().add(login);
		
		// ó�� �α��� ȭ���� ���� ��ġ ���� �������ش�.
		login.setTranslateX(login.getLayoutX()+300); // �α��� ȭ���� ����ŭ �������κ��� ����
		
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}

}
