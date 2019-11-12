package lab11.hw01;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LapTimeModel {
	private IntegerProperty sequence;
	private StringProperty lapTime;
	private StringProperty total;
	
	public LapTimeModel() {	
	}
	
	public LapTimeModel(int sequence, String lapTime, String total) {
		this.sequence = new SimpleIntegerProperty(sequence);
		this.lapTime = new SimpleStringProperty(lapTime);
		this.total = new SimpleStringProperty(total);
	}
	
	public int getSequence() {
		return sequence.get();
	}
	public void setSequence(int sequence) {
		this.sequence.set(sequence);
	}
	public IntegerProperty getSequenceProperty() {
		return sequence;
	}
	
	public String getLapTime() {
		return lapTime.get();
	}
	public void setLapTime(String lapTime) {
		this.lapTime.set(lapTime);
	}
	public StringProperty getLapTimeProperty() {
		return lapTime;
	}
	
	public String getTotalTime() {
		return total.get();
	}
	public void setTotalTime(String totalTime) {
		this.total.set(totalTime);
	}
	public StringProperty getTotalTimeProperty() {
		return total;
	}
}
