package com.home.hryhoryeu.imagehandler.controllers;

import com.home.hryhoryeu.imagehandler.dto.ParamsDto;
import com.home.hryhoryeu.imagehandler.handlers.element.impl.LinearImageContrast;
import com.home.hryhoryeu.imagehandler.managers.IHandleManager;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.managers.impl.HandleManagerImpl;
import com.home.hryhoryeu.imagehandler.managers.impl.ImageManagerImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class SliderBarController {

    @FXML
    private Label gMaxValue;
    @FXML
    private Label gMinValue;
    @FXML
    private Label fMaxValue;
    @FXML
    private Label fMinValue;

    @FXML
    private Slider gMax;
    @FXML
    private Slider gMin;
    @FXML
    private Slider fMax;
    @FXML
    private Slider fMin;

    private IImageManager imageManager = new ImageManagerImpl();
    private IHandleManager handleManager = new HandleManagerImpl();

    public void linearImageContrast(MouseEvent actionEvent) {

        gMaxValue.setText(String.valueOf((int)gMax.getValue()));
        gMinValue.setText(String.valueOf((int)gMin.getValue()));
        fMaxValue.setText(String.valueOf((int)fMax.getValue()));
        fMinValue.setText(String.valueOf((int)fMin.getValue()));

        handleManager.setElementHandler(new LinearImageContrast(new ParamsDto(
                (int)gMin.getValue(),
                (int)gMax.getValue(),
                (int)fMin.getValue(),
                (int)fMax.getValue())));
        imageManager.getImageData().getImageView().setImage(imageManager.getImageData().getChangedImage());
    }
}
