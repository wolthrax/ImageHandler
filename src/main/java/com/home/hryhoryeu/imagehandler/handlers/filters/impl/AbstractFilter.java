package com.home.hryhoryeu.imagehandler.handlers.filters.impl;

import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.entities.enums.Matrix;
import com.home.hryhoryeu.imagehandler.handlers.filters.IFilter;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.Mask;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.managers.impl.ImageManagerImpl;

import java.util.Comparator;
import java.util.List;

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

    protected PixelData getMinPixelData(List<PixelData> neighboringPixels) {
        return sortPixelValues(neighboringPixels).get(0);
    }

    protected PixelData getMaxPixelData(List<PixelData> neighboringPixels) {
        return sortPixelValues(neighboringPixels).get(neighboringPixels.size()-1);
    }

    private List<PixelData> sortPixelValues(List<PixelData> neighboringPixels) {
        neighboringPixels.sort(Comparator.comparingDouble(pixelData -> (double) (pixelData.getR() + pixelData.getG() + pixelData.getB()) / 3));
        return neighboringPixels;
    }

}
