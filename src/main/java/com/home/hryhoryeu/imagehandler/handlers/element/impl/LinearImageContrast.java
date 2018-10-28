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

                double G_R = (double) ((R - paramsDto.getfMin()) /
                        (paramsDto.getfMax() - paramsDto.getfMin()) *
                        (paramsDto.getgMax() - paramsDto.getgMin()) + paramsDto.getgMin());
                double G_G = (double) ((G - paramsDto.getfMin())
                        / (paramsDto.getfMax() - paramsDto.getfMin()) *
                        (paramsDto.getgMax() - paramsDto.getgMin()) + paramsDto.getgMin());
                double G_B = (double) ((B - paramsDto.getfMin()) /
                        (paramsDto.getfMax() - paramsDto.getfMin()) *
                        (paramsDto.getgMax() - paramsDto.getgMin()) + paramsDto.getgMin());

                if (G_R < ConfigParams.Value.MIN)
                    G_R = ConfigParams.Value.MIN;
                if (G_R > ConfigParams.Value.MAX)
                    G_R = ConfigParams.Value.MAX;

                if (G_G < ConfigParams.Value.MIN)
                    G_G = ConfigParams.Value.MIN;
                if (G_G > ConfigParams.Value.MAX)
                    G_G = ConfigParams.Value.MAX;

                if (G_B < ConfigParams.Value.MIN)
                    G_B = ConfigParams.Value.MIN;
                if (G_B > ConfigParams.Value.MAX)
                    G_B = ConfigParams.Value.MAX;

                Color color = new Color(G_R/255, G_G/255, G_B/255, 1);
                pixelWriter.setColor(x, y, color);
            }
        }
        imageManager.setChangedImage(writableImage);
    }
}
