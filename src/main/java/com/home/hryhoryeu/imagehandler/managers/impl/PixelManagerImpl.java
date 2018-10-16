package com.home.hryhoryeu.imagehandler.managers.impl;

import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.managers.IPixelManager;
import javafx.scene.paint.Color;

public class PixelManagerImpl implements IPixelManager {

    @Override
    public PixelData readPixel(Color color, int x, int y) {
        return new PixelData(
                x,
                y,
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255),
                (int)(color.getBrightness() * 255)
        );
    }
}
