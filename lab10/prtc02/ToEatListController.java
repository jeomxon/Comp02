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
	
	// ���� ���
	private ObservableList<String> foodList;
	// �˻� ����� ��� ��ü
	private FilteredList<String> filteredList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// ListView�� �����ִ� ���Ҹ� �ϰ�
		// ������ �����ʹ� ObservableArrayList ��ü�� �������ش�.
		foodList = FXCollections.observableArrayList();
		foodListView.setItems(foodList);
		filteredList = new FilteredList<String>(foodList);
		// �Է� ���� ������ �߰� ��ư�� ��Ȱ��ȭ��Ű��
		// ���ڰ� �ԷµǸ� �߰� ��ư�� �ٽ� Ȱ��ȭ��Ų��.
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
		// ���� ListView�� �����͸� ����� �����͸� �ٽ� �����Ѵ�.
		foodListView.setItems(filteredList);
	}
	@FXML public void insertAction() {
		String foodStr = inputField.getText();
		foodList.add(foodStr);
		// �����͸� �߰��ϰ� ���� ���ڸ� �����ش�.
		inputField.setText("");
		// �Է��ϱ� ���ϰ� �Է�â ��Ŀ��
		inputField.requestFocus();
	}
	@FXML public void deleteAction() {
		// ���� �ϱ� �� ������ �׸��� �����ߴ��� Ȯ���Ѵ�.
		// ���õ� �׸��� �ε����� �����´�. ���õ��� ������ -1�� �����Ѵ�.
		int selectedIndex = foodListView.getSelectionModel().getSelectedIndex();
		if (selectedIndex < 0) {
			new Alert(Alert.AlertType.WARNING, "������ �׸��� �����ϼ���.", ButtonType.CLOSE).show();
			return;
		}
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "���� �����Ͻðڽ��ϱ�?", ButtonType.OK, ButtonType.CANCEL);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			// ObservableArrayList���� �����͸� �����ϸ� �ڵ����� ListView�� �ݿ��ȴ�.
			foodList.remove(selectedIndex);
		}
	}
	

}
