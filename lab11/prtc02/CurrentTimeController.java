package lab11.prtc02;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CurrentTimeController {

	@FXML Label timeLable;
	private boolean isStopped;
	
	@FXML public void startAction() {
		isStopped = false;
		Thread thread = new Thread() {
			@Override
			public void run() {
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				while (!isStopped) {
					// 아래 Thread.sleep(100)을 통해 멈추었을 때 시각을 얻어온다.
					String strTime = format.format(new Date());
					// 쓰레드가 timeLabel의 값을 변경한다.
					// Label은 UI요소이므로 다른 작업쓰레드에서 setText() 메소드로
					// text 속성값을 변경할 수 없다.
					Platform.runLater(() -> timeLable.setText(strTime));
					try {
						// 0.1초 주기로 멈추어 준다.
						Thread.sleep(100);
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		thread.start();
	}
	@FXML public void stopAction() {
		this.isStopped = true;
	}

}
