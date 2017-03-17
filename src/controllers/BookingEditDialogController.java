package controllers;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Booking;
import model.Student;


public class BookingEditDialogController {

    @FXML
    private ComboBox<Student> comboStudent;
    @FXML
    private CheckBox checkPaid;
    @FXML
    private CheckBox checkAuthorized;


    private Stage dialogStage;
    private Booking booking;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(final MainApp mainApp)
	{
		comboStudent.setItems(mainApp.getStudentData());
	}
    
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(final Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the booking to be edited in the dialog.
     * 
     * @param booking
     */
    public void setBooking(final Booking booking) {
        this.booking = booking;
        
        if (booking.getStudent() != null)
        {
        	comboStudent.getSelectionModel().select(booking.getStudent());
        	checkPaid.setSelected(booking.hasPaid());
        	checkAuthorized.setSelected(booking.isAuthorized());
        }
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            booking.setStudent(comboStudent.getSelectionModel().getSelectedItem());
            booking.setPaid(checkPaid.isSelected());
            booking.setAuthorized(checkAuthorized.isSelected());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (comboStudent.getSelectionModel().isEmpty()) {
            errorMessage += "No student selected!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            final Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}