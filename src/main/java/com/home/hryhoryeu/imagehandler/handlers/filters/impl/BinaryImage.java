package com.home.hryhoryeu.imagehandler.handlers.filters.impl;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.entities.enums.Matrix;
import com.home.hryhoryeu.imagehandler.handlers.filters.IFilter;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.BinaryImagePreset;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask2X2;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class BinaryImage extends AbstractFilter implements IFilter {

    public BinaryImage(Matrix matrix) {
        super(matrix);
        if (matrix == Matrix.MATRIX_2X2)
            this.mask = new Mask2X2(new BinaryImagePreset());
    }

    @Override
    public void handle() {
        int sizeMatrix = matrix.getSize();
        int width = imageManager.getImageData().getChangedImageWidth();
        int height = imageManager.getImageData().getChangedImageHeight();

        PixelData[][] imagePixelMap = imageManager.getImageData().getChangedImagePixelMap();

        WritableImage writableImage = new WritableImage(width, height);

        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int y = ConfigParams.Position.START; y < height; y++) {
            for (int x = ConfigParams.Position.START; x < width; x++) {
//                for (int j = ConfigParams.Position.START; j < sizeMatrix; j++) {
//                    for (int i = ConfigParams.Position.START; i < sizeMatrix; i++) {

                        int R = 0;
                        int G = 0;
                        int B = 0;

                        if ((imagePixelMap[x][y].getBrightness() +
                                imagePixelMap[x][y].getBrightness() +
                                imagePixelMap[x][y].getBrightness()) / 3 > 127) {
                            R = 255;
                            G = 255;
                            B = 255;
                        }

//                        Color color = Color.hsb((double) imagePixelMap[x+i][y+j].getHue() / 255,
//                                (double) imagePixelMap[x+i][y+j].getSaturation() / 255,
//                                (double) brightness / 255);

                        Color color = Color.rgb(R, G, B);
                        pixelWriter.setColor(x, y, color);
//                    }
//                }
            }
        }

        imageManager.setChangedImage(writableImage);
        imageManager.applyChangedImage(writableImage);

    }
}
