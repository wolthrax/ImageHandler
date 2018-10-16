package com.home.hryhoryeu.imagehandler.managers;

import com.home.hryhoryeu.imagehandler.entities.ImageData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface IImageManager {

    void loadImage(String url);
    void setChangedImage(Image image);
    void saveChangedImage();
    ImageData getImageData();

    void showSourceFullSizeImage();
    void showChangedFullSizeImage();

    // Utils
    int getMaxBrightness();
}
