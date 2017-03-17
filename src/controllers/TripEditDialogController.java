package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Trip;
import view.CurrencyFormatter;

public class TripEditDialogController {

    @FXML
    private TextField tripNameField;

    @FXML
    private TextField organizerNameField;

    @FXML
    private TextField residentialField;

    @FXML
    private TextField entranceFeeField;

    @FXML
    private TextField transportFeeField;

    @FXML
    private TextField venueFeeField;

    @FXML
    private TextField miscCostsField;
    
    private Stage dialogStage;
    private Trip trip;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
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
     * Sets the trip to be edited in the dialog.
     * 
     * @param trip
     */
    public void setTrip(final Trip trip) {
        this.trip = trip;

        tripNameField.setText(trip.getTripName());
        entranceFeeField.setText(trip.getEntranceFee());
        entranceFeeField.setTextFormatter(new CurrencyFormatter());
        transportFeeField.setText(trip.getTransportFee());
        transportFeeField.setTextFormatter(new CurrencyFormatter());
        venueFeeField.setText(trip.getVenueFee());
        venueFeeField.setTextFormatter(new CurrencyFormatter());
        miscCostsField.setText(trip.getMiscCosts());
        miscCostsField.setTextFormatter(new CurrencyFormatter());
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
            trip.setTripName(tripNameField.getText());
            trip.setEntranceFee(Double.valueOf(entranceFeeField.getText()));
            trip.setTransportFee(Double.valueOf(transportFeeField.getText()));
            trip.setVenueFee(Double.valueOf(venueFeeField.getText()));
            trip.setMiscCosts(Double.valueOf(miscCostsField.getText()));

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

        if (tripNameField.getText() == null || tripNameField.getText().length() == 0) {
            errorMessage += "No valid Trip Name!\n"; 
        }
        if (entranceFeeField.getText() == null || entranceFeeField.getText().length() == 0) {
            errorMessage += "No valid entrance fee!\n";
        }
        if (transportFeeField.getText() == null || transportFeeField.getText().length() == 0) {
            errorMessage += "No valid transport fee!\n";
        }
        if (venueFeeField.getText() == null || venueFeeField.getText().length() == 0) {
            errorMessage += "No valid venue fee!\n";
        }
        if (miscCostsField.getText() == null || miscCostsField.getText().length() == 0) {
            errorMessage += "No valid miscellaneous fees!\n";
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
