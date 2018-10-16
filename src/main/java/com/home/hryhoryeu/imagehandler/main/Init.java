package com.home.hryhoryeu.imagehandler.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Init extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		String nameApp = "Image Handler";
		String layout = "/RootLayout.fxml";

		Parent parent = FXMLLoader.load(getClass().getResource(layout));
		
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle(nameApp);
		primaryStage.show();
	}

	@Override
	public void stop() {
	}

	
	static void startApp(String[] args){
		launch(args);
	}
}
