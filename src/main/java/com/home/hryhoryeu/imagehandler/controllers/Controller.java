package com.home.hryhoryeu.imagehandler.controllers;

import com.home.hryhoryeu.imagehandler.entities.enums.Matrix;
import com.home.hryhoryeu.imagehandler.handlers.element.impl.Solarisation;
import com.home.hryhoryeu.imagehandler.handlers.filters.impl.Emboss;
import com.home.hryhoryeu.imagehandler.managers.IBarChartManager;
import com.home.hryhoryeu.imagehandler.managers.IHandleManager;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.managers.impl.BarChartManagerImpl;
import com.home.hryhoryeu.imagehandler.managers.impl.HandleManagerImpl;
import com.home.hryhoryeu.imagehandler.managers.impl.ImageManagerImpl;
import com.home.hryhoryeu.imagehandler.ui.SliderBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private BorderPane mainContainer;
    @FXML
    private ImageView imageView;

    private final FileChooser fileChooser;
    private IImageManager imageManager;
    private IBarChartManager barChartBuilder;
    private IHandleManager handleManager;

    public Controller() {
        fileChooser = new FileChooser();
        imageManager = new ImageManagerImpl();
        barChartBuilder = new BarChartManagerImpl();
        handleManager = new HandleManagerImpl();
    }

    public void openImage(ActionEvent actionEvent) {
        imageManager.loadImage(fileChooser.showOpenDialog(new Stage()).toURI().toString(), imageView);
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void buildSourceBarChart(ActionEvent actionEvent) {
        barChartBuilder.showBarChartSourceImage();
    }

    public void buildChangedBarChart(ActionEvent actionEvent) {
        barChartBuilder.showBarChartChangedImage();
    }

    public void showSourceFullSizeImage(ActionEvent actionEvent) {
        imageManager.showSourceFullSizeImage();
    }

    public void showChangedFullSizeImage(ActionEvent actionEvent) {
        imageManager.showChangedFullSizeImage();
    }

    public void solarization(ActionEvent actionEvent) {
        handleManager.setElementHandler(new Solarisation());
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void linearImageContrastPrepare(ActionEvent actionEvent) {
        SliderBar sliderBar = new SliderBar();
        sliderBar.showSliderBar();
    }

    // Filters actions
    public void emboss3X3(ActionEvent actionEvent) {
        handleManager.setFilter(new Emboss(Matrix.MATRIX_3X3));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void emboss5X5(ActionEvent actionEvent) {
        handleManager.setFilter(new Emboss(Matrix.MATRIX_5X5));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void emboss7X7(ActionEvent actionEvent) {
        handleManager.setFilter(new Emboss(Matrix.MATRIX_7X7));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

}
