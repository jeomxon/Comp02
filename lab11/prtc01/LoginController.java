package lab11.prtc01;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoginController {

	@FXML AnchorPane loginPane;

	@FXML public void moveToMain() {
		StackPane root = (StackPane) loginPane.getScene().getRoot();
		// 처음 로그인 화면의 시작값을 0으로 설정한다.
		loginPane.setTranslateX(0);
		
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(loginPane.translateXProperty(), loginPane.getLayoutX());
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.getChildren().remove(loginPane);
			}
		}, keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();

	}
}