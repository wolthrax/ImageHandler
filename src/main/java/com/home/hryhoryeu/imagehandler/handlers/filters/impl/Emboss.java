package com.home.hryhoryeu.imagehandler.handlers.filters.impl;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import com.home.hryhoryeu.imagehandler.dto.ParamsDto;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.handlers.filters.IFilter;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.Mask;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.EmbossPreset;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask3X3;
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

                int R = imagePixelMap[x][y].getR();
                int G = imagePixelMap[x][y].getG();
                int B = imagePixelMap[x][y].getB();

                double N_R = 0;
                double N_G = 0;
                double N_B = 0;




                Color color = new Color(N_R/255, N_G/255, N_B/255, 1);
                pixelWriter.setColor(x, y, color);
            }
        }

    }
}
