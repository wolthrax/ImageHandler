package com.home.hryhoryeu.imagehandler.entities;

import javafx.scene.image.Image;

public class ImageData {

    private static ImageData instance;
    private Image sourceImage;
    private Image changedImage;

    private PixelData[][] sourceImagePixelData;
    private PixelData[][] changedImagePixelData;

    private ImageData() {

    }

    public static ImageData getInstance() {
        if (instance == null)
            instance = new ImageData();
        return instance;
    }

    public Image getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(Image sourceImage) {
        this.sourceImage = sourceImage;
    }

    public Image getChangedImage() {
        return changedImage;
    }

    public void setChangedImage(Image changedImage) {
        this.changedImage = changedImage;
    }

    public PixelData[][] getSourceImagePixelData() {
        return sourceImagePixelData;
    }

    public void setSourceImagePixelData(PixelData[][] sourceImagePixelData) {
        this.sourceImagePixelData = sourceImagePixelData;
    }

    public PixelData[][] getChangedImagePixelData() {
        return changedImagePixelData;
    }

    public void setChangedImagePixelData(PixelData[][] changedImagePixelData) {
        this.changedImagePixelData = changedImagePixelData;
    }
}