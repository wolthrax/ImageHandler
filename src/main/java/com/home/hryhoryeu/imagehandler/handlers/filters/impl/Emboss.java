package com.home.hryhoryeu.imagehandler.handlers.filters.impl;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import com.home.hryhoryeu.imagehandler.entities.enums.Matrix;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.handlers.filters.IFilter;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.BinaryImagePreset;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.EmbossPreset;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask2X2;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask3X3;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask5X5;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask7X7;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Emboss extends AbstractFilter implements IFilter {

    public Emboss(Matrix matrix) {
        super(matrix);
        if (matrix == Matrix.MATRIX_3X3)
            this.mask = new Mask3X3(new EmbossPreset());
        if (matrix == Matrix.MATRIX_5X5)
            this.mask = new Mask5X5(new EmbossPreset());
        if (matrix == Matrix.MATRIX_7X7)
            this.mask = new Mask7X7(new EmbossPreset());
    }

    @Override
    public void handle() {
        int sizeMatrix = matrix.getSize();
        int width = imageManager.getImageData().getChangedImageWidth();
        int height = imageManager.getImageData().getChangedImageHeight();

        PixelData[][] imagePixelMap = imageManager.getImageData().getChangedImagePixelMap();

        WritableImage writableImage = new WritableImage(width, height);

        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int y = ConfigParams.Position.START + sizeMatrix; y < height - sizeMatrix; y++) {
            for (int x = ConfigParams.Position.START + sizeMatrix; x < width - sizeMatrix; x++) {

                double N_R = 0;
                double N_G = 0;
                double N_B = 0;

                for (int i = -sizeMatrix; i <= sizeMatrix; i++) {
                    for (int j = -sizeMatrix; j <= sizeMatrix; j++) {
                        N_R += mask.getMask()[i + sizeMatrix][j + sizeMatrix] * imagePixelMap[x + i][y + j].getR();
                        N_G += mask.getMask()[i + sizeMatrix][j + sizeMatrix] * imagePixelMap[x + i][y + j].getG();
                        N_B += mask.getMask()[i + sizeMatrix][j + sizeMatrix] * imagePixelMap[x + i][y + j].getB();
                    }
                }

                N_R += 128;
                N_G += 128;
                N_B += 128;

                if (N_R < ConfigParams.Value.MIN)
                    N_R = ConfigParams.Value.MIN;
                if (N_R > ConfigParams.Value.MAX)
                    N_R = ConfigParams.Value.MAX;

                if (N_G < ConfigParams.Value.MIN)
                    N_G = ConfigParams.Value.MIN;
                if (N_G > ConfigParams.Value.MAX)
                    N_G = ConfigParams.Value.MAX;

                if (N_B < ConfigParams.Value.MIN)
                    N_B = ConfigParams.Value.MIN;
                if (N_B > ConfigParams.Value.MAX)
                    N_B = ConfigParams.Value.MAX;


                Color color = new Color(N_R/255d, N_G/255d, N_B/255d, 1);

                pixelWriter.setColor(x, y, color);
            }
        }
        imageManager.setChangedImage(writableImage);
        imageManager.applyChangedImage(writableImage);
    }
}