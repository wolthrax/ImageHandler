package com.home.hryhoryeu.imagehandler.handlers.filters.impl;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.entities.enums.Matrix;
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

public abstract class AbstractFilter implements IFilter {

    protected Mask mask;
    protected IImageManager imageManager;
    protected Matrix matrix;

    public AbstractFilter(Matrix matrix) {
        this.imageManager = new ImageManagerImpl();
        this.matrix = matrix;
        if (matrix == Matrix.MATRIX_3X3)
            this.mask = new Mask3X3(new EmbossPreset());
        if (matrix == Matrix.MATRIX_5X5)
            this.mask = new Mask5X5(new EmbossPreset());
        if (matrix == Matrix.MATRIX_7X7)
            this.mask = new Mask7X7(new EmbossPreset());
    }

    @Override
    public void handle() {

    }

}
