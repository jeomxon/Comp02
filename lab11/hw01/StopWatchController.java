package lab11.hw01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.util.Duration;
import javafx.scene.control.TableColumn;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class StopWatchController implements Initializable {

	@FXML Label timeLabel;
	@FXML Button startButton;
	@FXML Button resetButton;
	@FXML Label currentLapLabel;
	
	@FXML TableView<LapTimeModel> lapTimeTableView;
	@FXML TableColumn<LapTimeModel, Integer> sequenceColumn;
	@FXML TableColumn<LapTimeModel, String> lapTimeColumn;
	@FXML TableColumn<LapTimeModel, String> totalColumn;
	
	private long milliseconds, currentMilliseconds;
	private boolean isRunning;
	
	private Timeline timeline;
	private ObservableList<LapTimeModel> lapTimeList;
	private int checkSequence = 1;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		resetButton.setDisable(true);
		// 테이블뷰에 보여질 데이터(lapTimeList)를 만든다.
		lapTimeList = FXCollections.observableArrayList();
		// 테이블뷰에 데이터를 연결한다.
		lapTimeTableView.setItems(lapTimeList);
		// 테이블에 내용이 비어있을 경우에 표시됨
		lapTimeTableView.setPlaceholder(new Label("랩 데이터가 없음"));
		
		// 각 컬럼을 데이터와 연결
		sequenceColumn.setCellValueFactory(param -> param.getValue().getSequenceProperty().asObject());
		lapTimeColumn.setCellValueFactory(param -> param.getValue().getLapTimeProperty());
		totalColumn.setCellValueFactory(param -> param.getValue().getTotalTimeProperty());
		
		// 애니메이션 셋팅하는 부분
		KeyFrame keyFrame = new KeyFrame(Duration.ONE, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				milliseconds++;
				currentMilliseconds++;
				timeLabel.setText(millisecondsToTime(milliseconds));
				currentLapLabel.setText(millisecondsToTime(currentMilliseconds));
			}
		});
		timeline = new Timeline(keyFrame);
		// 반복 횟수 설정
		// 여기서는 애니메이션을 1밀리초마다 무한을 반복하게 한다.
		timeline.setCycleCount(Timeline.INDEFINITE);
		// 오토리버스 설정
		timeline.setAutoReverse(false);
	}
	
	@FXML public void startAction() {
		// 실행중이면 일시정지
		if (isRunning) {
			timeline.pause(); // initialize 메소드에서 설정했던 TimeLine을 일시정지 시킨다.
			isRunning = false;
			startButton.setText("시작");
			resetButton.setText("초기화");
		}
		else {
			// 정지 상태이면 실행
			timeline.play(); // initialize 메소드에서 설정했던 TimeLine을 실행시킨다.
			isRunning = true;
			startButton.setText("일시정지");
			resetButton.setText("랩타임");
			resetButton.setDisable(false);
		}
	}
	@FXML public void resetAction() {
		if (isRunning) {
			lapTimeList.add(new LapTimeModel(checkSequence, millisecondsToTime(currentMilliseconds), millisecondsToTime(milliseconds)));
			lapTimeTableView.scrollTo(lapTimeList.size());
			checkSequence++;
		}
		else {
			startButton.setText("시작");
			resetButton.setText("랩타임");
			resetButton.setDisable(true);
			timeline.pause();
			millisecondsToTime(0);
			milliseconds = 0;
			lapTimeList.clear();
			
		}
		currentLapLabel.setText(millisecondsToTime(0));
		currentMilliseconds = 0;
	}
	
	private String millisecondsToTime(long milliseconds) {
		int h = 0, m = 0, s = 0, ms = 0;
		
		ms = (int) (milliseconds % 1000);
		s = (int) ((milliseconds / 1000) % 60);
		m = (int) ((milliseconds / 1000) / 60);
		h = (int) (milliseconds / 3600000);
		
		return String.format("%02d:%02d:%02d.%03d", h, m, s, ms);
	}
	

}
