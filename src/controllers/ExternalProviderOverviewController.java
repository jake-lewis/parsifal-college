package controllers;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.ExternalProvider;

public class ExternalProviderOverviewController {
    @FXML
    private TableView<ExternalProvider> externalProviderTable;
    @FXML
    private TableColumn<ExternalProvider, String> firstNameColumn;
    @FXML
    private TableColumn<ExternalProvider, String> lastNameColumn;

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
    public ExternalProviderOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the externalProvider table with the two columns.
    	firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getForenameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSurnameProperty());
        
        // Clear externalProvider details.
        showExternalProviderDetails(null);

        // Listen for selection changes and show the externalProvider details when changed.
        externalProviderTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showExternalProviderDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(final MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        externalProviderTable.setItems(mainApp.getExternalProviderData());
    }
    
    /**
     * Fills all text fields to show details about the externalProvider.
     * If the specified externalProvider is null, all text fields are cleared.
     * 
     * @param externalProvider the externalProvider or null
     */
    private void showExternalProviderDetails(final ExternalProvider externalProvider) {
        if (externalProvider != null) {
            // Fill the labels with info from the externalProvider object.
            firstNameLabel.setText(externalProvider.getForename());
            lastNameLabel.setText(externalProvider.getSurname());
            mobileLabel.setText(externalProvider.getMobile());
        } else {
            // ExternalProvider is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            mobileLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteExternalProvider() {
        final int selectedIndex = externalProviderTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            externalProviderTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            final Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No ExternalProvider Selected");
            alert.setContentText("Please select a externalProvider in the table.");
            
            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new externalProvider.
     */
    @FXML
    private void handleNewExternalProvider() {
        final ExternalProvider tempExternalProvider = new ExternalProvider();
        final boolean okClicked = mainApp.showExternalProviderEditDialog(tempExternalProvider);
        if (okClicked) {
            mainApp.getExternalProviderData().add(tempExternalProvider);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected externalProvider.
     */
    @FXML
    private void handleEditExternalProvider() {
        final ExternalProvider selectedExternalProvidern = externalProviderTable.getSelectionModel().getSelectedItem();
        if (selectedExternalProvidern != null) {
            final boolean okClicked = mainApp.showExternalProviderEditDialog(selectedExternalProvidern);
            if (okClicked) {
                showExternalProviderDetails(selectedExternalProvidern);
            }

        } else {
            // Nothing selected.
            final Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No ExternalProvider Selected");
            alert.setContentText("Please select a externalProvider in the table.");
            
            alert.showAndWait();
        }
    }
}