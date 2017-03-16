package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Teacher;

public class TeacherController extends BorderPane implements Initializable
{
	@FXML
	BorderPane teacherPane;
	@FXML
	TableView<Teacher> table;
	@FXML
	TableColumn<Teacher, String> Forename;
	@FXML
	TableColumn<Teacher, String> Surname;

	final ObservableList<Teacher> data = FXCollections.observableArrayList(new Teacher("Simon", "Rood"));
	
	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		Forename.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Forename"));
		Surname.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Surname"));
		
		table.getItems().setAll(parseTeacherList());
	}
	
	private List<Teacher> parseTeacherList()
	{
		return data;
	}

}
