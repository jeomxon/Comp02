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
		// ���̺�信 ������ ������(lapTimeList)�� �����.
		lapTimeList = FXCollections.observableArrayList();
		// ���̺�信 �����͸� �����Ѵ�.
		lapTimeTableView.setItems(lapTimeList);
		// ���̺� ������ ������� ��쿡 ǥ�õ�
		lapTimeTableView.setPlaceholder(new Label("�� �����Ͱ� ����"));
		
		// �� �÷��� �����Ϳ� ����
		sequenceColumn.setCellValueFactory(param -> param.getValue().getSequenceProperty().asObject());
		lapTimeColumn.setCellValueFactory(param -> param.getValue().getLapTimeProperty());
		totalColumn.setCellValueFactory(param -> param.getValue().getTotalTimeProperty());
		
		// �ִϸ��̼� �����ϴ� �κ�
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
		// �ݺ� Ƚ�� ����
		// ���⼭�� �ִϸ��̼��� 1�и��ʸ��� ������ �ݺ��ϰ� �Ѵ�.
		timeline.setCycleCount(Timeline.INDEFINITE);
		// ���丮���� ����
		timeline.setAutoReverse(false);
	}
	
	@FXML public void startAction() {
		// �������̸� �Ͻ�����
		if (isRunning) {
			timeline.pause(); // initialize �޼ҵ忡�� �����ߴ� TimeLine�� �Ͻ����� ��Ų��.
			isRunning = false;
			startButton.setText("����");
			resetButton.setText("�ʱ�ȭ");
		}
		else {
			// ���� �����̸� ����
			timeline.play(); // initialize �޼ҵ忡�� �����ߴ� TimeLine�� �����Ų��.
			isRunning = true;
			startButton.setText("�Ͻ�����");
			resetButton.setText("��Ÿ��");
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
			startButton.setText("����");
			resetButton.setText("��Ÿ��");
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
