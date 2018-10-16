package com.home.hryhoryeu.imagehandler.entities;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import javafx.scene.image.Image;

public class ImageData {

    private static ImageData instance;
    private Image sourceImage;
    private Image changedImage;

    private PixelData[][] sourceImagePixelMap;
    private PixelData[][] changedImagePixelMap;

    private int maxBrightness = ConfigParams.Value.MIN;
    private int minBrightness = ConfigParams.Value.MAX;

    private int sourceImageWidth;
    private int sourceImageHeight;

    private int changedImageWidth;
    private int changedImageHeight;

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

    public PixelData[][] getSourceImagePixelMap() {
        return sourceImagePixelMap;
    }

    public void setSourceImagePixelMap(PixelData[][] sourceImagePixelMap) {
        this.sourceImagePixelMap = sourceImagePixelMap;
    }

    public PixelData[][] getChangedImagePixelMap() {
        return changedImagePixelMap;
    }

    public void setChangedImagePixelMap(PixelData[][] changedImagePixelMap) {
        this.changedImagePixelMap = changedImagePixelMap;
    }

    public int getMaxBrightness() {
        return maxBrightness;
    }

    public void setMaxBrightness(int maxBrightness) {
        this.maxBrightness = maxBrightness;
    }

    public int getMinBrightness() {
        return minBrightness;
    }

    public void setMinBrightness(int minBrightness) {
        this.minBrightness = minBrightness;
    }

    public int getSourceImageWidth() {
        return sourceImageWidth;
    }

    public void setSourceImageWidth(int sourceImageWidth) {
        this.sourceImageWidth = sourceImageWidth;
    }

    public int getSourceImageHeight() {
        return sourceImageHeight;
    }

    public void setSourceImageHeight(int sourceImageHeight) {
        this.sourceImageHeight = sourceImageHeight;
    }

    public int getChangedImageWidth() {
        return changedImageWidth;
    }

    public void setChangedImageWidth(int changedImageWidth) {
        this.changedImageWidth = changedImageWidth;
    }

    public int getChangedImageHeight() {
        return changedImageHeight;
    }

    public void setChangedImageHeight(int changedImageHeight) {
        this.changedImageHeight = changedImageHeight;
    }
}