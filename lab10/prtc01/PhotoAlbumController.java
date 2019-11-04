package lab10.prtc01;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PhotoAlbumController {
	@FXML ImageView photoView;
	@FXML Label fileNameLabel;
	private Image[] imageRes = {
			new Image(getClass().getResource("images/pome1.jpg").toString()),
			new Image(getClass().getResource("images/pome2.jpg").toString()),
			new Image(getClass().getResource("images/pome3.jpg").toString()),
			new Image(getClass().getResource("images/pome4.jpg").toString()),
			new Image(getClass().getResource("images/pome5.jpg").toString()),
			new Image(getClass().getResource("images/pome6.jpg").toString()),
			new Image(getClass().getResource("images/pome7.jpg").toString()),
	};
	private int index;

	@FXML public void previousAction() {
		if (index == 0) {
			index = imageRes.length;
		}
		photoView.setImage(imageRes[--index]);
	}

	@FXML public void nextAction() {
		if (index == imageRes.length - 1) {
			index = -1;
		}
		photoView.setImage(imageRes[++index]);
	}
}
