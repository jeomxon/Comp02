package lab10.prtc02;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class ToEatListController implements Initializable{

	@FXML TextField searchField;
	@FXML ListView<String> foodListView;
	@FXML TextField inputField;
	@FXML Button insertButton;
	
	// 음식 목록
	private ObservableList<String> foodList;
	// 검색 결과를 담는 객체
	private FilteredList<String> filteredList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// ListView는 보여주는 역할만 하고
		// 보여줄 데이터는 ObservableArrayList 객체가 관리해준다.
		foodList = FXCollections.observableArrayList();
		foodListView.setItems(foodList);
		filteredList = new FilteredList<String>(foodList);
		// 입력 값이 없으면 추가 버튼을 비활성화시키고
		// 글자가 입력되면 추가 버튼을 다시 활성화시킨다.
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
	@FXML public void searchAction() {
		filteredList.setPredicate(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				if (t.contains(searchField.getText())) {
					return true;
				}
				return false;
			}
		});
		// 기존 ListView의 데이터를 지우고 데이터를 다시 세팅한다.
		foodListView.setItems(filteredList);
	}
	@FXML public void insertAction() {
		String foodStr = inputField.getText();
		foodList.add(foodStr);
		// 데이터를 추가하고 기존 글자를 지워준다.
		inputField.setText("");
		// 입력하기 편하게 입력창 포커스
		inputField.requestFocus();
	}
	@FXML public void deleteAction() {
		// 삭제 하기 전 삭제할 항목을 선택했는지 확인한다.
		// 선택된 항목의 인덱스를 가져온다. 선택되지 않으면 -1을 리턴한다.
		int selectedIndex = foodListView.getSelectionModel().getSelectedIndex();
		if (selectedIndex < 0) {
			new Alert(Alert.AlertType.WARNING, "삭제할 항목을 선택하세요.", ButtonType.CLOSE).show();
			return;
		}
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "정말 삭제하시겠습니까?", ButtonType.OK, ButtonType.CANCEL);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			// ObservableArrayList에서 데이터를 삭제하면 자동으로 ListView에 반영된다.
			foodList.remove(selectedIndex);
		}
	}
	

}
