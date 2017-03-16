package controllers;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Teacher;

public class TeacherOverviewController {
    @FXML
    private TableView<Teacher> teacherTable;
    @FXML
    private TableColumn<Teacher, String> firstNameColumn;
    @FXML
    private TableColumn<Teacher, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public TeacherOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the teacher table with the two columns.
    	firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getForenameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSurnameProperty());
        
        // Clear teacher details.
        showTeacherDetails(null);

        // Listen for selection changes and show the teacher details when changed.
        teacherTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showTeacherDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(final MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        teacherTable.setItems(mainApp.getTeacherData());
    }
    
    /**
     * Fills all text fields to show details about the teacher.
     * If the specified teacher is null, all text fields are cleared.
     * 
     * @param teacher the teacher or null
     */
    private void showTeacherDetails(final Teacher teacher) {
        if (teacher != null) {
            // Fill the labels with info from the teacher object.
            firstNameLabel.setText(teacher.getForename());
            lastNameLabel.setText(teacher.getSurname());
        } else {
            // Teacher is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteTeacher() {
        final int selectedIndex = teacherTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            teacherTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            final Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Teacher Selected");
            alert.setContentText("Please select a teacher in the table.");
            
            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new teacher.
     */
    @FXML
    private void handleNewTeacher() {
        final Teacher tempTeacher = new Teacher();
        final boolean okClicked = mainApp.showTeacherEditDialog(tempTeacher);
        if (okClicked) {
            mainApp.getTeacherData().add(tempTeacher);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected teacher.
     */
    @FXML
    private void handleEditTeacher() {
        final Teacher selectedTeachern = teacherTable.getSelectionModel().getSelectedItem();
        if (selectedTeachern != null) {
            final boolean okClicked = mainApp.showTeacherEditDialog(selectedTeachern);
            if (okClicked) {
                showTeacherDetails(selectedTeachern);
            }

        } else {
            // Nothing selected.
            final Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Teacher Selected");
            alert.setContentText("Please select a teacher in the table.");
            
            alert.showAndWait();
        }
    }
}