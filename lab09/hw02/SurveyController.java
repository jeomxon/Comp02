/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.10.29
 * ����  : ���� �˰����� ���ϴ� GUI���α׷�
 *
 ***************************/

package lab09.hw02;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class SurveyController implements Initializable{

	@FXML TextField nameField;
	@FXML ComboBox<String> areaBox;
	@FXML RadioButton maleButton;
	@FXML ToggleGroup sex;
	@FXML RadioButton femaleButton;
	@FXML CheckBox springCheck;
	@FXML CheckBox summerCheck;
	@FXML CheckBox fallCheck;
	@FXML CheckBox winterCheck;
	@FXML RadioButton choice2_1;
	@FXML ToggleGroup area;
	@FXML RadioButton choice2_2;
	@FXML RadioButton choice2_3;
	@FXML RadioButton choice2_4;
	@FXML RadioButton choice2_5;
	@FXML RadioButton choice2_6;
	@FXML TextArea contentsArea;
	@FXML public void printAction() {
		StringBuilder builder = new StringBuilder();
		
		String title = nameField.getText();
		builder.append("�̸� : " + title + "\n");
		
		if(sex.getSelectedToggle() != null && sex.getSelectedToggle().getUserData().toString().equals("1")) {
			builder.append("���� : " + maleButton.getText());
		}
		else if(sex.getSelectedToggle() != null && sex.getSelectedToggle().getUserData().toString().equals("2")) {
			builder.append("���� : " + femaleButton.getText());
		}
		
		builder.append("\n�����ϴ� ���� : ");
		if (springCheck.isSelected()) {
			builder.append("�� ");
		}
		if (summerCheck.isSelected()) {
			builder.append("���� ");
		}
		if (fallCheck.isSelected()) {
			builder.append("���� ");
		}
		if (winterCheck.isSelected()) {
			builder.append("�ܿ� ");
		}
		
		builder.append("\n�����ϰ� ���� ���� : ");
		if (area.getSelectedToggle() != null && area.getSelectedToggle().getUserData().toString().equals("1")) {
			builder.append(choice2_1.getText());
		}
		else if (area.getSelectedToggle() != null && area.getSelectedToggle().getUserData().toString().equals("2")) {
			builder.append(choice2_2.getText());
		}
		else if (area.getSelectedToggle() != null && area.getSelectedToggle().getUserData().toString().equals("3")) {
			builder.append(choice2_3.getText());
		}
		else if (area.getSelectedToggle() != null && area.getSelectedToggle().getUserData().toString().equals("4")) {
			builder.append(choice2_4.getText());
		}
		else if (area.getSelectedToggle() != null && area.getSelectedToggle().getUserData().toString().equals("5")) {
			builder.append(choice2_5.getText());
		}
		else if (area.getSelectedToggle() != null && area.getSelectedToggle().getUserData().toString().equals("6")) {
			builder.append(choice2_6.getText());
		}
		
		contentsArea.setText(builder.toString());
		
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> areaComboList = FXCollections.observableArrayList("������", "������", "��û��", "����", "���", "���ֵ�");
		areaBox.setItems(areaComboList);
	}

}
