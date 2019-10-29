package lab09.prtc02;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;

public class ButtonExampleController {

	@FXML CheckBox choice1_1;
	@FXML CheckBox choice1_2;
	@FXML CheckBox choice1_3;
	@FXML CheckBox choice1_4;
	@FXML CheckBox choice1_5;
	@FXML ToggleGroup choice2;
	@FXML Label resultLabel;
	@FXML public void checkResult() {
		int score = 0;
		//���� 1�� ���� ���� Ȯ��
		if (choice1_1.isSelected() && choice1_4.isSelected() && !choice1_2.isSelected() && !choice1_3.isSelected() && !choice1_5.isSelected()) {
			score += 50;
		}
		//���� 2�� ���� ���� Ȯ��
		if (choice2.getSelectedToggle() != null && choice2.getSelectedToggle().getUserData().toString().equals("2")) {
			score += 50;
		}
		
		//���� ����� resultLabel�� ���
		resultLabel.setText("�� ����: " + score + "��");
	}

}
