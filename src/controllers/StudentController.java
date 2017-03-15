package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Student;
import model.StudentCache;

public class StudentController extends BorderPane implements Initializable
{

	@FXML
	BorderPane studentPane;
	@FXML
	TableView<Student> table;
	@FXML
	TableColumn<Student, String> Forename;
	@FXML
	TableColumn<Student, String> Surname;
	@FXML
	TableColumn<Student, String> Mobile;
	@FXML
	Button create;

	final StudentCache cache = new StudentCache();
	ObservableList<Student> data = FXCollections.observableArrayList(this.cache.getStudents());
	
	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		Forename.setCellValueFactory(new PropertyValueFactory<Student, String>("Forename"));
		Surname.setCellValueFactory(new PropertyValueFactory<Student, String>("Surname"));
		Mobile.setCellValueFactory(new PropertyValueFactory<Student, String>("Mobile"));
		System.out.println(this.getClass().getSimpleName() + ".initialize");
		
		create.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(final ActionEvent e) {
		        //TODO add action for creating student
		    }
		});
		
		update();
	}
	
	public void update()
	{
		data = FXCollections.observableArrayList(cache.getStudents());
		table.getItems().setAll(data);
	}

}
