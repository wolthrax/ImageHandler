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

    private int maxR = ConfigParams.Value.MIN;
    private int minR = ConfigParams.Value.MAX;

    private int maxG = ConfigParams.Value.MIN;
    private int minG = ConfigParams.Value.MAX;

    private int maxB = ConfigParams.Value.MIN;
    private int minB = ConfigParams.Value.MAX;

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

    public int getMaxR() {
        return maxR;
    }

    public void setMaxR(int maxR) {
        this.maxR = maxR;
    }

    public int getMinR() {
        return minR;
    }

    public void setMinR(int minR) {
        this.minR = minR;
    }

    public int getMaxG() {
        return maxG;
    }

    public void setMaxG(int maxG) {
        this.maxG = maxG;
    }

    public int getMinG() {
        return minG;
    }

    public void setMinG(int minG) {
        this.minG = minG;
    }

    public int getMaxB() {
        return maxB;
    }

    public void setMaxB(int maxB) {
        this.maxB = maxB;
    }

    public int getMinB() {
        return minB;
    }

    public void setMinB(int minB) {
        this.minB = minB;
    }
}