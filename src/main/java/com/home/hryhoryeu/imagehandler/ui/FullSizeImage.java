package com.home.hryhoryeu.imagehandler.ui;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FullSizeImage {

    public void buildFullSizeScene(Image image) {

        ImageView imageView = new ImageView();
        imageView.setFitWidth(image.getWidth());
        imageView.setFitHeight(image.getHeight());
        imageView.setImage(image);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.getStylesheets().add(ConfigParams.Style.DEFAULT_STYLE_URL);
        scrollPane.setContent(imageView);

        Scene scene = new Scene(scrollPane, ConfigParams.Size.FULL_SIZE_WIDTH, ConfigParams.Size.FULL_SIZE_HEIGHT);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }


}
