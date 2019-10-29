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
		// �Էµ� ������ �����ϴ� StrinBuilder��ü�� �����.
		StringBuilder builder = new StringBuilder();
		String title = titleField.getText();
		builder.append("����: " + title + "\n");
		// �н����� ���� �����´�.
		String password = passwordField.getText();
		builder.append("��й�ȣ: " + password + "\n");
		LocalDate endDate = endDatePicker.getValue();
		if (endDate != null) {
			builder.append("��������: " + endDate.toString() + "\n");
		}
		String contents = contentsArea.getText();
		builder.append("����: " + contents + "\n");
		System.out.println("����ڰ� �Է��� ����");
		System.out.println(builder.toString());
	}
	@FXML public void cancelAction() {
		// ���� ������ â�� �ݴ´�.
		Platform.exit();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> publicComboList = FXCollections.observableArrayList("����", "�����");
		publicBox.setItems(publicComboList);
	}
	
}
