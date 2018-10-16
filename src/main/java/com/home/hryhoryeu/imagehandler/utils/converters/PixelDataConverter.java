package com.home.hryhoryeu.imagehandler.utils.converters;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import javafx.scene.paint.Color;

public class PixelDataConverter {

    public static PixelData toPixelData(Color color, int x, int y) {
        return new PixelData(
                x,
                y,
                (int)(color.getRed() * ConfigParams.Value.MAX),
                (int)(color.getGreen() * ConfigParams.Value.MAX),
                (int)(color.getBlue() * ConfigParams.Value.MAX),
                (int)(color.getHue() * ConfigParams.Value.MAX),
                (int)(color.getSaturation() * ConfigParams.Value.MAX),
                (int)(color.getBrightness() * ConfigParams.Value.MAX)
        );
    }
}
