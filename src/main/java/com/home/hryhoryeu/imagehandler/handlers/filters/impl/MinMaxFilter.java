package com.home.hryhoryeu.imagehandler.handlers.filters.impl;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.entities.enums.Matrix;
import com.home.hryhoryeu.imagehandler.handlers.filters.IFilter;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MinMaxFilter extends AbstractFilter implements IFilter {

    private int matrixType;

    public MinMaxFilter(Matrix matrix) {
        super(matrix);
        if (matrix == Matrix.MATRIX_3X3)
            this.matrixType = 3;
        if (matrix == Matrix.MATRIX_5X5)
            this.matrixType = 5;
        if (matrix == Matrix.MATRIX_7X7)
            this.matrixType = 7;
    }

    @Override
    public void handle() {

        int indent = matrix.getSize();

        int width = imageManager.getImageData().getChangedImageWidth();
        int height = imageManager.getImageData().getChangedImageHeight();

        PixelData[][] imagePixelMap = imageManager.getImageData().getChangedImagePixelMap();

        WritableImage writableImage = new WritableImage(width, height);

        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int y = ConfigParams.Position.START + indent; y < height - indent; y++) {
            for (int x = ConfigParams.Position.START + indent; x < width - indent; x++) {

                List<PixelData> neighboringPixels = new ArrayList<>();

                for (int i = -indent; i <= indent; i++) {
                    for (int j = -indent; j <= indent; j++) {
                        neighboringPixels.add(imagePixelMap[x + i][y + j]);
                    }
                }

                PixelData minPixelData = getMinPixelData(neighboringPixels);
                PixelData maxPixelData = getMaxPixelData(neighboringPixels);

                int minMaxR = maxPixelData.getR()-minPixelData.getR();
                int minMaxG = maxPixelData.getG()-minPixelData.getG();
                int minMaxB = maxPixelData.getB()-minPixelData.getB();

                if (minMaxR < 0)
                    minMaxR = 0;
                if (minMaxG < 0)
                    minMaxG = 0;
                if (minMaxB < 0)
                    minMaxB = 0;

                Color color = new Color(minMaxR/255d,
                        minMaxG/255d,
                        minMaxB/255d,
                        1);
                pixelWriter.setColor(x, y, color);

            }
        }
        imageManager.setChangedImage(writableImage);
        imageManager.applyChangedImage(writableImage);
    }
}
