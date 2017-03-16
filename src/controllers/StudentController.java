package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
	
	private FXMLLoader editLoader;
	private StudentEditDialogController editController;

	final StudentCache cache = new StudentCache();
	//ObservableList<Student> data = FXCollections.observableArrayList(this.cache.getStudents());
	ObservableList<Student> data = FXCollections.observableArrayList(new Student("07898234", "name", "asd"));
	
	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		Forename.setCellValueFactory(new PropertyValueFactory<Student, String>("Forename"));
		Surname.setCellValueFactory(new PropertyValueFactory<Student, String>("Surname"));
		Mobile.setCellValueFactory(new PropertyValueFactory<Student, String>("Mobile"));
		
//		this.editLoader = 
//		this.editController = this.editLoader.getController();
		
		update();
	}
	
	public void update()
	{
		//data = FXCollections.observableArrayList(cache.getStudents());
		table.getItems().setAll(data);
	}
	
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
		final int selectedIndex = table.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        table.getItems().remove(selectedIndex);
	    } else {
	        // Nothing selected.
	        final Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(ParsifalCollegeApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Student Selected");
	        alert.setContentText("Please select a student in the table.");

	        alert.showAndWait();
	    }
	}
	
	public boolean showEditStudentDialog()
	{
		try
		{
			final Parent editDialog = FXMLLoader.load(getClass().getClassLoader().getResource("view/StudentEditDialogController.fxml"));
			final Stage stage = new Stage();
            stage.setTitle("Edit Student");
            stage.setScene(new Scene(editDialog));
            //stage.show();
			
            
            //
//			final AnchorPane page = (AnchorPane) this.editLoader.load();
//
//            // Create the dialog Stage.
//            final Stage dialogStage = new Stage();
//            dialogStage.setTitle("Edit Person");
//            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.initOwner(ParsifalCollegeApp.getPrimaryStage());
//            final Scene scene = new Scene(page);
//            dialogStage.setScene(scene);

            // Set the person into the controller.
            //this.editController.setDialogStage(stage);

            // Show the dialog and wait until the user closes it
            stage.showAndWait();

            return this.editController.isOkClicked();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
            return false;
		}
	}
	
	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewStudent() {
	    
	    final boolean okClicked = this.showEditStudentDialog();
	    if (okClicked) {
	       this.cache.addStudent(this.editController.getStudent());
	    }
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditStudent() {
	    final Student selectedPerson = this.table.getSelectionModel().getSelectedItem();
	    if (selectedPerson != null) {
	        final boolean okClicked = this.showEditStudentDialog();
	        if (okClicked) {
	            this.editController.setStudent(selectedPerson);;
	        }

	    } else {
	        // Nothing selected.
	        final Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(ParsifalCollegeApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Student Selected");
	        alert.setContentText("Please select a student in the table.");

	        alert.showAndWait();
	    }
	}
}
