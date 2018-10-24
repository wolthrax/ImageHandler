package com.home.hryhoryeu.imagehandler.managers;

import com.home.hryhoryeu.imagehandler.entities.ImageData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface IImageManager {

    void loadImage(String url, ImageView imageView);
    void setChangedImage(Image image);
    void applyChangedImage(Image image);
    void saveChangedImage();
    ImageData getImageData();
    Image back();

    void showSourceFullSizeImage();
    void showChangedFullSizeImage();

}
