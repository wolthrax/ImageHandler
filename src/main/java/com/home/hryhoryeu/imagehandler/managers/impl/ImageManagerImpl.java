package com.home.hryhoryeu.imagehandler.managers.impl;

import com.home.hryhoryeu.imagehandler.entities.ImageData;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.managers.IPixelManager;
import com.home.hryhoryeu.imagehandler.ui.FullSizeImageScene;
import com.home.hryhoryeu.imagehandler.utils.converters.PixelDataConverter;
import javafx.scene.image.Image;

public class ImageManagerImpl implements IImageManager {

    private ImageData imageData;
    private FullSizeImageScene fullSizeImageScene;

    public ImageManagerImpl() {
        this.imageData = ImageData.getInstance();
        this.fullSizeImageScene = new FullSizeImageScene();
    }

    @Override
    public void loadImage(String url) {
        Image image = new Image(url);

        imageData.setSourceImageWidth((int)image.getWidth());
        imageData.setSourceImageHeight((int)image.getHeight());

        imageData.setSourceImage(image);
        imageData.setSourceImagePixelMap(pixelMapBuilder(getImageData().getSourceImage()));

        setChangedImage(image);
    }

    @Override
    public void setChangedImage(Image image) {
        imageData.setChangedImageWidth((int)image.getWidth());
        imageData.setChangedImageHeight((int)image.getHeight());

        imageData.setChangedImage(image);
        imageData.setChangedImagePixelMap(pixelMapBuilder(image));

        calcBrightValues();
    }


    @Override
    public void saveChangedImage() {
        //TODO Save image on disk
    }

    @Override
    public ImageData getImageData() {
        return imageData;
    }

    @Override
    public void showSourceFullSizeImage() {
        fullSizeImageScene.buildFullSizeScene(imageData.getSourceImage());
    }

    @Override
    public void showChangedFullSizeImage() {
        fullSizeImageScene.buildFullSizeScene(imageData.getChangedImage());
    }

    private PixelData[][] pixelMapBuilder(Image image) {
        PixelData[][] pixelMap = new PixelData[(int)image.getWidth()][(int)image.getHeight()];
        for(int y = 0; y < (int)image.getHeight(); y++) {
            for(int x = 0; x < (int)image.getWidth(); x++) {
                pixelMap[x][y] = PixelDataConverter.toPixelData(image.getPixelReader().getColor(x, y), x, y);
            }
        }
        return pixelMap;
    }

    private void calcBrightValues() {
        PixelData pixelMap[][] = imageData.getChangedImagePixelMap();
        for(int y = 0; y < imageData.getSourceImageHeight(); y++) {
            for(int x = 0; x < imageData.getSourceImageWidth(); x++) {
                if (imageData.getMaxBrightness() < pixelMap[x][y].getBrightness()) {
                    imageData.setMaxBrightness(pixelMap[x][y].getBrightness());
                }
                if (imageData.getMinBrightness() > pixelMap[x][y].getBrightness()) {
                    imageData.setMinBrightness(pixelMap[x][y].getBrightness());
                }
            }
        }
    }
}