package application;

import java.io.IOException;

import controllers.ExternalProviderEditDialogController;
import controllers.ExternalProviderOverviewController;
import controllers.StudentEditDialogController;
import controllers.StudentOverviewController;
import controllers.TeacherEditDialogController;
import controllers.TeacherOverviewController;
import controllers.TripEditDialogController;
import controllers.TripOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ExternalProvider;
import model.Student;
import model.Teacher;
import model.Trip;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of Persons.
     */
    private final ObservableList<Student> studentData = FXCollections.observableArrayList();
    private final ObservableList<Teacher> teacherData = FXCollections.observableArrayList();
    private final ObservableList<ExternalProvider> externalProviderData = FXCollections.observableArrayList();
    private final ObservableList<Trip> tripData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        studentData.add(new Student("Heinz", "Kurz", "07983244567"));
        studentData.add(new Student("Cornelia", "Meier", "12356777"));
        teacherData.add(new Teacher("Simon", "Rood"));
        teacherData.add(new Teacher("Ben", "Clist"));
        externalProviderData.add(new ExternalProvider("Bob", "Roos", "0120223545"));
    }

    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Student> getStudentData() {
        return this.studentData;
    }

    @Override
    public void start(final Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Parsifal College App");

        initRootLayout();

        showStudentOverview();
        showTeacherOverview();
        showExternalProviderOverview();
        showTripOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            final Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the teacher overview inside the root layout.
     */
    public void showStudentOverview() {
        try {
            // Load student overview.
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/StudentOverview.fxml"));
            final AnchorPane studentOverview = (AnchorPane) loader.load();

            // Set student overview into the first root tab
            final TabPane tabPane = (TabPane) rootLayout.getCenter();
            final ObservableList<Tab> tabs = tabPane.getTabs();
            tabs.get(0).setContent(studentOverview);

            // Give the controller access to the main app.
            final StudentOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the teacher overview inside the root layout.
     */
    public void showTeacherOverview() {
        try {
            // Load teacher overview.
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/TeacherOverview.fxml"));
            final AnchorPane teacherOverview = (AnchorPane) loader.load();

            // Set teacher overview into the first root tab
            final TabPane tabPane = (TabPane) rootLayout.getCenter();
            final ObservableList<Tab> tabs = tabPane.getTabs();
            tabs.get(1).setContent(teacherOverview);

            // Give the controller access to the main app.
            final TeacherOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the external provider overview inside the root layout.
     */
    public void showExternalProviderOverview() {
        try {
            // Load teacher overview.
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/ExternalProviderOverview.fxml"));
            final AnchorPane externalProviderOverview = (AnchorPane) loader.load();

            // Set externalProvider overview into the first root tab
            final TabPane tabPane = (TabPane) rootLayout.getCenter();
            final ObservableList<Tab> tabs = tabPane.getTabs();
            tabs.get(2).setContent(externalProviderOverview);

            // Give the controller access to the main app.
            final ExternalProviderOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the trip provider overview inside the root layout.
     */
    public void showTripOverview() {
        try {
            // Load teacher overview.
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/TripOverview.fxml"));
            final AnchorPane tripOverview = (AnchorPane) loader.load();

            // Set externalProvider overview into the first root tab
            final TabPane tabPane = (TabPane) rootLayout.getCenter();
            final ObservableList<Tab> tabs = tabPane.getTabs();
            tabs.get(3).setContent(tripOverview);

            // Give the controller access to the main app.
            final TripOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param student the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showStudentEditDialog(final Student student) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/StudentEditDialog.fxml"));
            final AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            final Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Student");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            final Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            final StudentEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setStudent(student);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (final IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param teacher the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showTeacherEditDialog(final Teacher teacher) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/TeacherEditDialog.fxml"));
            final AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            final Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Teacher");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            final Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            final TeacherEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setTeacher(teacher);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (final IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param externalProvider the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showExternalProviderEditDialog(final ExternalProvider externalProvider) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/ExternalProviderEditDialog.fxml"));
            final AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            final Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit External Provider");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            final Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            final ExternalProviderEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setExternalProvider(externalProvider);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (final IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified trip. If the user
     * clicks OK, the changes are saved into the provided trip object and true
     * is returned.
     * 
     * @param trip the trip object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showTripEditDialog(final Trip trip) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/TripEditDialog.fxml"));
            final AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            final Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Trip");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            final Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            final TripEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setTrip(trip);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (final IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(final String[] args) {
        launch(args);
    }

	public ObservableList<Teacher> getTeacherData()
	{
		return this.teacherData;
	}
	
	public ObservableList<ExternalProvider> getExternalProviderData()
	{
		return this.externalProviderData;
	}
	
	public ObservableList<Trip> getTripData()
	{
		return this.tripData;
	}
}