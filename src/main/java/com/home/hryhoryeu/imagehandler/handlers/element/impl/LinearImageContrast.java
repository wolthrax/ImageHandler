package com.home.hryhoryeu.imagehandler.handlers.element.impl;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import com.home.hryhoryeu.imagehandler.dto.ParamsDto;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.handlers.element.IElementHandler;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.managers.impl.ImageManagerImpl;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LinearImageContrast implements IElementHandler {

    private IImageManager imageManager;
    private ParamsDto paramsDto;

    public LinearImageContrast(ParamsDto paramsDto) {
        this.imageManager = new ImageManagerImpl();
        this.paramsDto = paramsDto;
    }

    @Override
    public void handle() {

        int width = imageManager.getImageData().getChangedImageWidth();
        int height = imageManager.getImageData().getChangedImageHeight();

        PixelData[][] imagePixelMap = imageManager.getImageData().getChangedImagePixelMap();

        WritableImage writableImage = new WritableImage(width, height);

        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int y = ConfigParams.Position.START; y < height; y++) {
            for (int x = ConfigParams.Position.START; x < width; x++) {

                int R = imagePixelMap[x][y].getR();
                int G = imagePixelMap[x][y].getG();
                int B = imagePixelMap[x][y].getB();
                int br = imagePixelMap[x][y].getBrightness();

//                double G_R = (double) ((paramsDto.getgMax() - paramsDto.getgMin()) *
//                        ((R - paramsDto.getfMin()) / (paramsDto.getfMax() - paramsDto.getfMin())) + paramsDto.getgMin());
//                double G_G = (double) ((paramsDto.getgMax() - paramsDto.getgMin()) *
//                        ((G - paramsDto.getfMin()) / (paramsDto.getfMax() - paramsDto.getfMin())) + paramsDto.getgMin());
//                double G_B = (double) ((paramsDto.getgMax() - paramsDto.getgMin()) *
//                        ((B - paramsDto.getfMin()) / (paramsDto.getfMax() - paramsDto.getfMin())) + paramsDto.getgMin());
//
//
//                //Color colorRGB = Color.rgb(G_R, G_G, G_B);
//                Color color = new Color(G_R/255d, G_G/255d, G_B/255d, 1);
//                pixelWriter.setColor(x, y, color);

                double G_BR = (double) ((paramsDto.getgMax() - paramsDto.getgMin()) *
                        (br - paramsDto.getfMin()) / (paramsDto.getfMax() - paramsDto.getfMin()) + paramsDto.getgMin());

                Color colorRGB = Color.rgb(R, G, B);
                Color colorHSB = Color.hsb(colorRGB.getHue(), colorRGB.getSaturation(), (double) G_BR/255d);
                pixelWriter.setColor(x, y, colorHSB);

            }
        }
        imageManager.setChangedImage(writableImage);
    }
}
