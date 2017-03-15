package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class MainController extends BorderPane implements Initializable
{

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		System.out.println(this.getClass().getSimpleName() + ".initialize");
	}
}
