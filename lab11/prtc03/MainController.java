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
		// 같은 경로의 파일은 상대경로 지정 방식으로 사용하지만
		// 다른 경로으 파일은 src 디렉토리를 루트로 하여 절대경로로 표현한다.
		Parent login = FXMLLoader.load(getClass().getResource("/lab11/prtc01/LoginForm.fxml"));
		stackPane.getChildren().add(login);
		
		// 처음 로그인 화면의 시작 위치 값을 지정해준다.
		login.setTranslateX(login.getLayoutX()+300); // 로그인 화면의 폭만큼 우측으로부터 시작
		
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}

}
