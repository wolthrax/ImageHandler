package com.home.hryhoryeu.imagehandler.controllers;

import com.home.hryhoryeu.imagehandler.entities.enums.Matrix;
import com.home.hryhoryeu.imagehandler.handlers.element.impl.Solarisation;
import com.home.hryhoryeu.imagehandler.handlers.filters.impl.BinaryImage;
import com.home.hryhoryeu.imagehandler.handlers.filters.impl.Emboss;
import com.home.hryhoryeu.imagehandler.handlers.filters.impl.MaxFilter;
import com.home.hryhoryeu.imagehandler.handlers.filters.impl.MinFilter;
import com.home.hryhoryeu.imagehandler.handlers.filters.impl.MinMaxFilter;
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

    public void backImage(ActionEvent actionEvent) {
        imageView.setImage(imageManager.back());
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

    public void binaryImage2X2(ActionEvent actionEvent) {
        handleManager.setFilter(new BinaryImage(Matrix.MATRIX_2X2));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void binaryImage4X4(ActionEvent actionEvent) {
        handleManager.setFilter(new BinaryImage(Matrix.MATRIX_4X4));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void minFilter3X3(ActionEvent actionEvent) {
        handleManager.setFilter(new MinFilter(Matrix.MATRIX_3X3));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void minFilter5X5(ActionEvent actionEvent) {
        handleManager.setFilter(new MinFilter(Matrix.MATRIX_5X5));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void minFilter7X7(ActionEvent actionEvent) {
        handleManager.setFilter(new MinFilter(Matrix.MATRIX_7X7));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void maxFilter3X3(ActionEvent actionEvent) {
        handleManager.setFilter(new MaxFilter(Matrix.MATRIX_3X3));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void maxFilter5X5(ActionEvent actionEvent) {
        handleManager.setFilter(new MaxFilter(Matrix.MATRIX_5X5));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void maxFilter7X7(ActionEvent actionEvent) {
        handleManager.setFilter(new MaxFilter(Matrix.MATRIX_7X7));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void minMaxFilter3X3(ActionEvent actionEvent) {
        handleManager.setFilter(new MinMaxFilter(Matrix.MATRIX_3X3));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void minMaxFilter5X5(ActionEvent actionEvent) {
        handleManager.setFilter(new MinMaxFilter(Matrix.MATRIX_5X5));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void minMaxFilter7X7(ActionEvent actionEvent) {
        handleManager.setFilter(new MinMaxFilter(Matrix.MATRIX_7X7));
        imageView.setImage(imageManager.getImageData().getChangedImage());
    }

    public void saveChangedImage(ActionEvent actionEvent) {
        imageManager.saveChangedImage();
    }
}
