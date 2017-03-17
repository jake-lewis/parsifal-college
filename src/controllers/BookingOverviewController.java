package controllers;

import application.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Booking;
import model.Trip;

public class BookingOverviewController
{
	@FXML
	private TableView<Booking> bookingTable;
	@FXML
	private TableColumn<Booking, String> firstNameColumn;
	@FXML
	private TableColumn<Booking, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label paidLabel;
	@FXML
	private Label authorizedLabel;
	@FXML
	private ComboBox<Trip> comboTrip;

	// Reference to the main application.
	private MainApp mainApp;
	private Trip selectedTrip;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public BookingOverviewController()
	{
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize()
	{
		// Initialize the booking table with the two columns.
		firstNameColumn.setCellValueFactory(cellData -> (cellData.getValue().getStudent().getForenameProperty()));
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getStudent().getSurnameProperty());

		// Clear booking details.
		showBookingDetails(null);

		// Listen for selection changes and show the booking details when
		// changed.
		bookingTable.getSelectionModel().selectedItemProperty()
		        .addListener((observable, oldValue, newValue) -> showBookingDetails(newValue));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(final MainApp mainApp)
	{
		this.mainApp = mainApp;

		mainApp.getTripData().addListener(new ListChangeListener<Trip>()
		{
			@Override
			public void onChanged(final javafx.collections.ListChangeListener.Change<? extends Trip> c)
			{
				comboTrip.setItems(FXCollections.observableArrayList(mainApp.getTripData()));
			}
		});

		comboTrip.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			selectedTrip = newValue;
			bookingTable.setItems(selectedTrip.getBookingData());
		});
	}

	/**
	 * Fills all text fields to show details about the booking. If the specified
	 * booking is null, all text fields are cleared.
	 * 
	 * @param booking
	 *            the booking or null
	 */
	private void showBookingDetails(final Booking booking)
	{
		if (booking != null)
		{
			// Fill the labels with info from the booking object.
			firstNameLabel.setText(booking.getStudent().getForename());
			lastNameLabel.setText(booking.getStudent().getSurname());
			paidLabel.setText(String.valueOf(booking.hasPaid()));
			authorizedLabel.setText(String.valueOf(booking.isAuthorized()));
		}
		else
		{
			// Booking is null, remove all the text.
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			paidLabel.setText("");
			authorizedLabel.setText("");
		}
	}

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeleteBooking()
	{
		final int selectedIndex = bookingTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0)
		{
			bookingTable.getItems().remove(selectedIndex);
		}
		else
		{
			// Nothing selected.
			final Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Booking Selected");
			alert.setContentText("Please select a booking in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new booking.
	 */
	@FXML
	private void handleNewBooking()
	{
		final Booking tempBooking = new Booking();
		final boolean okClicked = mainApp.showBookingEditDialog(tempBooking);
		if (okClicked)
		{
			selectedTrip.getBookingData().add(tempBooking);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected booking.
	 */
	@FXML
	private void handleEditBooking()
	{
		final Booking selectedBookingn = bookingTable.getSelectionModel().getSelectedItem();
		if (selectedBookingn != null)
		{
			final boolean okClicked = mainApp.showBookingEditDialog(selectedBookingn);
			if (okClicked)
			{
				showBookingDetails(selectedBookingn);
			}

		}
		else
		{
			// Nothing selected.
			final Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Booking Selected");
			alert.setContentText("Please select a booking in the table.");

			alert.showAndWait();
		}
	}
}