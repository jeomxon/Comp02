package lab10.hw02;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class MovingListController implements Initializable {
	@FXML ListView<String> leftListView;
	@FXML ListView<String> rightListView;
	@FXML Button insertButton;
	@FXML TextField inputField;
	@FXML Button moveRight;
	@FXML Button moveLeft;
	@FXML Button moveRightAll;
	@FXML Button moveLeftAll;
	
	private ObservableList<String> leftList;
	private ObservableList<String> rightList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		leftList = FXCollections.observableArrayList();
		leftListView.setItems(leftList);
		rightList = FXCollections.observableArrayList();
		rightListView.setItems(rightList);
		inputField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!oldValue.equals(newValue) && newValue.length() > 0) {
					insertButton.setDisable(false);
				}
				if (newValue.length() == 0) {
					insertButton.setDisable(true);
				}
			}
			
		});
	}
	
	@FXML public void insertAction() {
		String str = inputField.getText();
		leftList.add(str);
		inputField.setText("");
		inputField.requestFocus();
	}
	
	@FXML public void moveRightAction() {
		int selectedIndex = leftListView.getSelectionModel().getSelectedIndex();
		if (selectedIndex < 0) {
			new Alert(Alert.AlertType.WARNING, "이동할 항목을 선택하세요.", ButtonType.CLOSE).show();
			return;
		}
		else {
			rightList.add(leftList.get(selectedIndex));
			leftList.remove(selectedIndex);
		}
	}
	@FXML public void moveLeftAction() {
		int selectedIndex = rightListView.getSelectionModel().getSelectedIndex();
		if (selectedIndex < 0) {
			new Alert(Alert.AlertType.WARNING, "이동할 항목을 선택하세요.", ButtonType.CLOSE).show();
			return;
		}
		else {
			leftList.add(rightList.get(selectedIndex));
			rightList.remove(selectedIndex);
		}
	}
	@FXML public void moveRightAllAction() {
		for(int i = 0; i < leftList.size(); i++) {
			rightList.add(i, leftList.get(i));
		}
		leftList.removeAll(leftList);
	}
	@FXML public void moveLeftAllAction() {
		for(int i = 0; i < rightList.size(); i++) {
			leftList.add(i, rightList.get(i));
		}
		rightList.removeAll(rightList);
	}
}
