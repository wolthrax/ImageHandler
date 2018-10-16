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

        double coefficient = (4 / (double)imageManager.getImageData().getMaxBrightness());
        for (int y = ConfigParams.Position.START; y < height; y++) {
            for (int x = ConfigParams.Position.START; x < width; x++) {
                int brightness = imagePixelMap[x][y].getBrightness();
                int solarizationBrightness = (int)(coefficient * brightness * (imageManager.getImageData().getMaxBrightness() - brightness));
                Color colorRGB = Color.rgb(imagePixelMap[x][y].getR(), imagePixelMap[x][y].getG(), imagePixelMap[x][y].getB());
                Color colorHSB = Color.hsb(colorRGB.getHue(), colorRGB.getSaturation(), (double) solarizationBrightness/255);
                pixelWriter.setColor(x, y, colorHSB);
            }
        }
        imageManager.setChangedImage(writableImage);
    }
}