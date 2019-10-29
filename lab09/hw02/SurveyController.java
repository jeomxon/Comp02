/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.10.29
 * 목적  : 정렬 알고리즘을 비교하는 GUI프로그램
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
		builder.append("이름 : " + title + "\n");
		
		if(sex.getSelectedToggle() != null && sex.getSelectedToggle().getUserData().toString().equals("1")) {
			builder.append("성별 : " + maleButton.getText());
		}
		else if(sex.getSelectedToggle() != null && sex.getSelectedToggle().getUserData().toString().equals("2")) {
			builder.append("성별 : " + femaleButton.getText());
		}
		
		builder.append("\n좋아하는 계절 : ");
		if (springCheck.isSelected()) {
			builder.append("봄 ");
		}
		if (summerCheck.isSelected()) {
			builder.append("여름 ");
		}
		if (fallCheck.isSelected()) {
			builder.append("가을 ");
		}
		if (winterCheck.isSelected()) {
			builder.append("겨울 ");
		}
		
		builder.append("\n여행하고 싶은 지역 : ");
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
		ObservableList<String> areaComboList = FXCollections.observableArrayList("수도권", "강원도", "충청도", "전라도", "경상도", "제주도");
		areaBox.setItems(areaComboList);
	}

}
