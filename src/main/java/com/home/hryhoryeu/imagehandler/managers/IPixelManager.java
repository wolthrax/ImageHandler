package com.home.hryhoryeu.imagehandler.managers;

import com.home.hryhoryeu.imagehandler.entities.PixelData;
import javafx.scene.paint.Color;

public interface IPixelManager {

    PixelData readPixel(Color color, int x, int y);

}
