package controllers;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Student;

public class StudentOverviewController {
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> firstNameColumn;
    @FXML
    private TableColumn<Student, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label mobileLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public StudentOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the student table with the two columns.
    	firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getForenameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSurnameProperty());
        
        // Clear student details.
        showStudentDetails(null);

        // Listen for selection changes and show the student details when changed.
        studentTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStudentDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(final MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        studentTable.setItems(mainApp.getStudentData());
    }
    
    /**
     * Fills all text fields to show details about the student.
     * If the specified student is null, all text fields are cleared.
     * 
     * @param student the student or null
     */
    private void showStudentDetails(final Student student) {
        if (student != null) {
            // Fill the labels with info from the student object.
            firstNameLabel.setText(student.getForename());
            lastNameLabel.setText(student.getSurname());
            mobileLabel.setText(student.getMobile());
        } else {
            // Student is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            mobileLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteStudent() {
        final int selectedIndex = studentTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            studentTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            final Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Student Selected");
            alert.setContentText("Please select a student in the table.");
            
            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new student.
     */
    @FXML
    private void handleNewStudent() {
        final Student tempStudent = new Student();
        final boolean okClicked = mainApp.showStudentEditDialog(tempStudent);
        if (okClicked) {
            mainApp.getStudentData().add(tempStudent);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected student.
     */
    @FXML
    private void handleEditStudent() {
        final Student selectedStudentn = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudentn != null) {
            final boolean okClicked = mainApp.showStudentEditDialog(selectedStudentn);
            if (okClicked) {
                showStudentDetails(selectedStudentn);
            }

        } else {
            // Nothing selected.
            final Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Student Selected");
            alert.setContentText("Please select a student in the table.");
            
            alert.showAndWait();
        }
    }
}