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
					// �Ʒ� Thread.sleep(100)�� ���� ���߾��� �� �ð��� ���´�.
					String strTime = format.format(new Date());
					// �����尡 timeLabel�� ���� �����Ѵ�.
					// Label�� UI����̹Ƿ� �ٸ� �۾������忡�� setText() �޼ҵ��
					// text �Ӽ����� ������ �� ����.
					Platform.runLater(() -> timeLable.setText(strTime));
					try {
						// 0.1�� �ֱ�� ���߾� �ش�.
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
