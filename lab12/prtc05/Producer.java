package lab12.prtc05;

public class Producer implements Runnable {
	private DataBox dataBox;
	
	public Producer(DataBox dataBox) {
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 3; i++) {
			String data = "Data-" + i;
			dataBox.setData(data);
		}
	}
}
