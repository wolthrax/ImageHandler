package com.home.hryhoryeu.imagehandler.handlers.element.impl;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.handlers.element.IElementHandler;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.managers.impl.ImageManagerImpl;
import com.home.hryhoryeu.imagehandler.utils.converters.PixelDataConverter;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Solarisation implements IElementHandler {

    private IImageManager imageManager = new ImageManagerImpl();

    @Override
    public void handle() {

        int width = imageManager.getImageData().getChangedImageWidth();
        int height = imageManager.getImageData().getChangedImageHeight();

        PixelData[][] imagePixelMap = imageManager.getImageData().getChangedImagePixelMap();

        WritableImage writableImage = new WritableImage(width, height);

        PixelWriter pixelWriter = writableImage.getPixelWriter();

        double coefficientR = (4 / (double)imageManager.getImageData().getMaxR());
        double coefficientG = (4 / (double)imageManager.getImageData().getMaxG());
        double coefficientB = (4 / (double)imageManager.getImageData().getMaxB());
        for (int y = ConfigParams.Position.START; y < height; y++) {
            for (int x = ConfigParams.Position.START; x < width; x++) {
                int R = imagePixelMap[x][y].getR();
                int G = imagePixelMap[x][y].getG();
                int B = imagePixelMap[x][y].getB();
                int solarizationR = (int)(coefficientR * R * (imageManager.getImageData().getMaxR() - R));
                int solarizationG = (int)(coefficientG * G * (imageManager.getImageData().getMaxG() - G));
                int solarizationB = (int)(coefficientB * B * (imageManager.getImageData().getMaxB() - B));
                Color colorRGB = Color.rgb(solarizationR, solarizationG, solarizationB);
                pixelWriter.setColor(x, y, colorRGB);
            }
        }
        imageManager.setChangedImage(writableImage);
    }
}