package com.home.hryhoryeu.imagehandler.handlers.element.impl;

import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.handlers.element.IElementHandler;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.managers.impl.ImageManagerImpl;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Solarisation implements IElementHandler {

    private IImageManager imageManager = new ImageManagerImpl();

    @Override
    public void handle() {

        int width = (int)imageManager.getImageData().getChangedImage().getWidth();
        int height = (int)imageManager.getImageData().getChangedImage().getHeight();

        WritableImage writableImage = new WritableImage(width, height);

        PixelWriter pixelWriter = writableImage.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                PixelData[][] pixelData = imageManager.getImageData().getChangedImagePixelData();
                Color color = Color.rgb(pixelData[x][y].getR(), pixelData[x][y].getG(), pixelData[x][y].getB());
                int brightness = pixelData[x][y].getBrightness();
                int newBrightness = (int)((4/255d) * brightness * (255 - brightness));
                Color color1 = Color.hsb(color.getHue(), color.getSaturation(), (double) newBrightness/255);
                pixelWriter.setColor(x, y, color1);
            }
        }
        imageManager.setChangedImage(writableImage);
    }
}