package com.home.hryhoryeu.imagehandler.handlers.filters.impl;

import com.home.hryhoryeu.imagehandler.entities.enums.Matrix;
import com.home.hryhoryeu.imagehandler.handlers.filters.IFilter;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.Mask;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.BinaryImagePreset;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.EmbossPreset;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask2X2;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask3X3;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask5X5;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask7X7;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.managers.impl.ImageManagerImpl;

public abstract class AbstractFilter implements IFilter {

    protected Mask mask;
    protected IImageManager imageManager;
    protected Matrix matrix;

    public AbstractFilter(Matrix matrix) {
        this.imageManager = new ImageManagerImpl();
        this.matrix = matrix;
    }

    @Override
    public abstract void handle();

}
