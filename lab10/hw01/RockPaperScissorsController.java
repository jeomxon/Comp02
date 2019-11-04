package lab10.hw01;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;

public class RockPaperScissorsController {

	@FXML RadioButton scissors;
	@FXML ToggleGroup selectedRadio;
	@FXML RadioButton rock;
	@FXML RadioButton paper;
	@FXML ImageView playerImage;
	@FXML ImageView computerImage;
	@FXML TextArea resultArea;
	
	private Image[] playerView = {
			new Image(getClass().getResource("images/player_paper.png").toString()),
			new Image(getClass().getResource("images/player_rock.png").toString()),
			new Image(getClass().getResource("images/player_scissors.png").toString()),
	};
	private Image[] comView = {
			new Image(getClass().getResource("images/com_paper.png").toString()),
			new Image(getClass().getResource("images/com_rock.png").toString()),
			new Image(getClass().getResource("images/com_scissors.png").toString()),
	};
	private int playerIndex;
	
	@FXML public void showResult() {
		int com = (int)(Math.random()*3);
		
		if (selectedRadio.getSelectedToggle() != null && selectedRadio.getSelectedToggle().getUserData().toString().equals("paper")) {
			playerImage.setImage(playerView[0]);
			playerIndex = 0;
		}
		else if (selectedRadio.getSelectedToggle() != null && selectedRadio.getSelectedToggle().getUserData().toString().equals("rock")) {
			playerImage.setImage(playerView[1]);
			playerIndex = 1;
		}
		else if (selectedRadio.getSelectedToggle() != null && selectedRadio.getSelectedToggle().getUserData().toString().equals("scissors")) {
			playerImage.setImage(playerView[2]);
			playerIndex = 2;
		}
		
		if (playerIndex == com) {
			resultArea.setText("결과\n비겼습니다.");
		}
		else if (playerIndex == 0 && com == 1) {
			resultArea.setText("결과\nPlayer가 이겼습니다.");
		}
		else if (playerIndex == 0 && com == 2) {
			resultArea.setText("결과\nAI가 이겼습니다.");
		}
		else if (playerIndex == 1 && com == 2) {
			resultArea.setText("결과\nPlayer가 이겼습니다.");
		}
		else if (playerIndex == 1 && com == 0) {
			resultArea.setText("결과\nAI가 이겼습니다.");
		}
		else if (playerIndex == 2 && com == 0) {
			resultArea.setText("결과\nPlayer가 이겼습니다.");
		}
		else if (playerIndex == 2 && com == 1) {
			resultArea.setText("결과\nAI가 이겼습니다.");
		}
		
		
		if (com == 0) {
			computerImage.setImage(comView[0]);
		}
		else if (com == 1) {
			computerImage.setImage(comView[1]);
		}
		else if (com == 2) {
			computerImage.setImage(comView[2]);
		}
	
	}

}
