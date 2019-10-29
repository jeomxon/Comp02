package lab09.prtc03;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class NoticeController implements Initializable {

	@FXML TextField titleField;
	@FXML PasswordField passwordField;
	@FXML ComboBox<String> publicBox;
	@FXML DatePicker endDatePicker;
	@FXML TextArea contentsArea;
	@FXML public void registerAction() {
		// 입력된 내용을 저장하는 StrinBuilder객체를 만든다.
		StringBuilder builder = new StringBuilder();
		String title = titleField.getText();
		builder.append("제목: " + title + "\n");
		// 패스워드 값을 가져온다.
		String password = passwordField.getText();
		builder.append("비밀번호: " + password + "\n");
		LocalDate endDate = endDatePicker.getValue();
		if (endDate != null) {
			builder.append("종료일자: " + endDate.toString() + "\n");
		}
		String contents = contentsArea.getText();
		builder.append("내용: " + contents + "\n");
		System.out.println("사용자가 입력한 내용");
		System.out.println(builder.toString());
	}
	@FXML public void cancelAction() {
		// 현재 윈도우 창을 닫는다.
		Platform.exit();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> publicComboList = FXCollections.observableArrayList("공개", "비공개");
		publicBox.setItems(publicComboList);
	}
	
}
