package controllers;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Trip;

public class TripOverviewController {
    @FXML
    private TableView<Trip> tripTable;
    @FXML
    private TableColumn<Trip, String> tripNameColumn;
    @FXML
    private TableColumn<Trip, String> residentialColumn;

    @FXML
    private Label tripLabel;
    @FXML
    private Label organizerNameLabel;
    @FXML
    private Label residentialLabel;
    @FXML
    private Label entranceFeeLabel;
    @FXML
    private Label transportFeeLabel;
    @FXML
    private Label venueFeeLabel;
    @FXML
    private Label miscCostsLabel;
    @FXML
    private Label totalCostLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public TripOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the trip table with the two columns.
    	tripNameColumn.setCellValueFactory(cellData -> cellData.getValue().getForenameProperty());
        residentialColumn.setCellValueFactory(cellData -> cellData.getValue().getSurnameProperty());
        
        // Clear trip details.
        showTripDetails(null);

        // Listen for selection changes and show the trip details when changed.
        tripTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showTripDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(final MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        tripTable.setItems(mainApp.getTripData());
    }
    
    /**
     * Fills all text fields to show details about the trip.
     * If the specified trip is null, all text fields are cleared.
     * 
     * @param trip the trip or null
     */
    private void showTripDetails(final Trip trip) {
        if (trip != null) {
            // Fill the labels with info from the trip object.
            tripLabel.setText(trip.getForename());
            organizerNameLabel.setText(trip.getSurname());
            residentialLabel.setText(trip.getMobile());
        } else {
            // Trip is null, remove all the text.
            tripLabel.setText("");
            organizerNameLabel.setText("");
            residentialLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteTrip() {
        final int selectedIndex = tripTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tripTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            final Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Trip Selected");
            alert.setContentText("Please select a trip in the table.");
            
            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new trip.
     */
    @FXML
    private void handleNewTrip() {
        final Trip tempTrip = new Trip();
        final boolean okClicked = mainApp.showTripEditDialog(tempTrip);
        if (okClicked) {
            mainApp.getTripData().add(tempTrip);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected trip.
     */
    @FXML
    private void handleEditTrip() {
        final Trip selectedTripn = tripTable.getSelectionModel().getSelectedItem();
        if (selectedTripn != null) {
            final boolean okClicked = mainApp.showTripEditDialog(selectedTripn);
            if (okClicked) {
                showTripDetails(selectedTripn);
            }

        } else {
            // Nothing selected.
            final Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Trip Selected");
            alert.setContentText("Please select a trip in the table.");
            
            alert.showAndWait();
        }
    }
}