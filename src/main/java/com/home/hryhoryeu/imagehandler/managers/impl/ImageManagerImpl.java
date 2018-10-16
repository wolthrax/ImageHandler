package com.home.hryhoryeu.imagehandler.managers.impl;

import com.home.hryhoryeu.imagehandler.entities.ImageData;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.managers.IPixelManager;
import com.home.hryhoryeu.imagehandler.ui.FullSizeImage;
import javafx.scene.image.Image;

public class ImageManagerImpl implements IImageManager {

    private ImageData imageData;
    private FullSizeImage fullSizeImage;

    public ImageManagerImpl() {
        this.imageData = ImageData.getInstance();
        this.fullSizeImage = new FullSizeImage();
    }

    @Override
    public void loadImage(String url) {
        imageData.setSourceImage(new Image(url));
        imageData.setSourceImagePixelData(pixelReader(getImageData().getSourceImage()));

        imageData.setChangedImage(new Image(url));
        imageData.setChangedImagePixelData(pixelReader(getImageData().getChangedImage()));
    }

    @Override
    public void setChangedImage(Image image) {
        imageData.setChangedImage(image);
        imageData.setChangedImagePixelData(pixelReader(image));
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
        fullSizeImage.buildFullSizeScene(imageData.getSourceImage());
    }

    @Override
    public void showChangedFullSizeImage() {
        fullSizeImage.buildFullSizeScene(imageData.getChangedImage());
    }

    @Override
    public int getMaxBrightness() {
        return 0;
    }

    private PixelData[][] pixelReader(Image image) {
        IPixelManager pixelManager = new PixelManagerImpl();
        final int width = (int)image.getWidth();
        final int height = (int)image.getHeight();
        PixelData[][] data = new PixelData[width][height];
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                data[i][j] = pixelManager.readPixel(image.getPixelReader().getColor(i, j), i, j);
            }
        }
        return data;
    }
}