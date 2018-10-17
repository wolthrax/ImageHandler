package com.home.hryhoryeu.imagehandler.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SliderBar {

    public void showSliderBar() {

        Stage stage = new Stage();

        String nameApp = "Slider Bar";
        String layout = "/SliderBarLayout.fxml";

        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource(layout));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(anchorPane);

        stage.setScene(scene);
        stage.setTitle(nameApp);
        stage.show();
    }
}
