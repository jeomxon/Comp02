package lab10.prtc03;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class MediaPlayerController implements Initializable {

	@FXML MediaView mediaView;
	@FXML ProgressBar progressBar;
	@FXML Label timeLabel;
	@FXML Slider volumeSlider;
	private MediaPlayer player;
	
	@FXML public void playAction() {
		player.play();
	}
	@FXML public void pauseAction() {
		player.pause();
	}
	@FXML public void stopAction() {
		player.stop();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Path path = Paths.get("src/lab10/prtc03/movie.mp4");
		Media media = new Media(path.toUri().toString());
		player = new MediaPlayer(media);
		mediaView.setMediaPlayer(player);
		// 미디어 상태에 따른 제어
		player.setOnReady(new Runnable() {

			@Override
			public void run() {
				// 미디어의 현재 시간 속성 감시
				player.currentTimeProperty().addListener(new ChangeListener<Duration>() {

					@Override
					public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
						// 진행 상태
						double currentTime = player.getCurrentTime().toSeconds();
						double totalTime = player.getTotalDuration().toSeconds();
						double progress = currentTime / totalTime;
						progressBar.setProgress(progress);  // 프로그레스바의 값은 0 ~ 1 사이의 값을 갖는다.
						timeLabel.setText((int) currentTime + "/" + (int) totalTime + " 초");
					}
				});
			}
		});
		// 초기 음량 값
		volumeSlider.setValue(100.0);
		player.setVolume(volumeSlider.getValue());
		// 볼륨설정 : Slider의 value 속성 감시
		volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				player.setVolume(newValue.doubleValue() / 100.0);
			}
			
		});
	}
	

}
