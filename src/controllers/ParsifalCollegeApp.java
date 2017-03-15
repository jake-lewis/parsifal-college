package controllers;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ParsifalCollegeApp extends Application
{

	// annoying Eclipse launch workaround:
    public static void main(final String[] args) {launch(args);}

	@Override
	public void start(final Stage primaryStage) throws Exception
	{
		//initialise main frame
		final BorderPane root = new BorderPane();
		
        final FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
        final BorderPane main = mainLoader.load();
        root.setCenter(main);
        
        final TabPane tabbedPane = (TabPane) main.getCenter();
        
        populateTabs(tabbedPane);

		primaryStage.setTitle("Parsifal College Application");
		primaryStage.setScene(new Scene(root));
        primaryStage.show();
	}

	private void populateTabs(final TabPane tabbedPane) throws IOException
	{
		final ObservableList<Tab> tabs = tabbedPane.getTabs();
		
		final FXMLLoader studentViewLoader = new FXMLLoader(getClass().getResource("/view/StudentView.fxml"));
        final FXMLLoader teacherViewLoader = new FXMLLoader(getClass().getResource("/view/TeacherView.fxml"));
        
        tabs.get(0).setContent(studentViewLoader.load());
        tabs.get(1).setContent(teacherViewLoader.load());
	}
}