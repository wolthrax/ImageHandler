package com.home.hryhoryeu.imagehandler.handlers.filters.impl;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import com.home.hryhoryeu.imagehandler.dto.ParamsDto;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.handlers.filters.IFilter;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.Mask;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.EmbossPreset;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask3X3;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask5X5;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask7X7;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.managers.impl.ImageManagerImpl;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Emboss implements IFilter {

    private IImageManager imageManager;

    public Emboss() {
        this.imageManager = new ImageManagerImpl();
    }

    @Override
    public void handle() {



        int width = imageManager.getImageData().getChangedImageWidth();
        int height = imageManager.getImageData().getChangedImageHeight();

        PixelData[][] imagePixelMap = imageManager.getImageData().getChangedImagePixelMap();

        WritableImage writableImage = new WritableImage(width, height);

        PixelWriter pixelWriter = writableImage.getPixelWriter();

        Mask mask = new Mask3X3(new EmbossPreset());

        for (int y = ConfigParams.Position.START+1; y < height-1; y++) {
            for (int x = ConfigParams.Position.START+1; x < width-1; x++) {

                double N_R = 0;
                double N_G = 0;
                double N_B = 0;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i != 0 && j != 0) {
                            N_R += mask.getMask()[i + 1][j + 1] * imagePixelMap[x + i][y + j].getR();
                            N_G += mask.getMask()[i + 1][j + 1] * imagePixelMap[x + i][y + j].getG();
                            N_B += mask.getMask()[i + 1][j + 1] * imagePixelMap[x + i][y + j].getB();
                        }
                    }
                }

                N_R = N_R / 255d;
                N_G = N_G / 255d;
                N_B = N_B / 255d;

//                if (N_R < ConfigParams.Value.MIN)
//                    N_R = ConfigParams.Value.MIN;
//                if (N_R > ConfigParams.Value.MAX)
//                    N_R = ConfigParams.Value.MAX;
//
//                if (N_G < ConfigParams.Value.MIN)
//                    N_G = ConfigParams.Value.MIN;
//                if (N_G > ConfigParams.Value.MAX)
//                    N_G = ConfigParams.Value.MAX;
//
//                if (N_B < ConfigParams.Value.MIN)
//                    N_B = ConfigParams.Value.MIN;
//                if (N_B > ConfigParams.Value.MAX)
//                    N_B = ConfigParams.Value.MAX;


                Color color = new Color(N_R, N_G, N_B, 1);

                pixelWriter.setColor(x, y, color);
            }
        }
        imageManager.setChangedImage(writableImage);
        imageManager.applyChangedImage(writableImage);
    }
}
