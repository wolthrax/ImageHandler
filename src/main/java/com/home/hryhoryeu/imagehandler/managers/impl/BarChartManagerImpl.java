package com.home.hryhoryeu.imagehandler.managers.impl;

import com.home.hryhoryeu.imagehandler.config.Names;
import com.home.hryhoryeu.imagehandler.entities.ImageData;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.managers.IBarChartManager;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.ui.BarChart;
import javafx.scene.image.Image;

import java.util.Map;
import java.util.TreeMap;

public class BarChartManagerImpl implements IBarChartManager {

    private ImageData imageData;

    public BarChartManagerImpl() {
        IImageManager imageManager = new ImageManagerImpl();
        imageData = imageManager.getImageData();
    }

    @Override
    public void showBarChartSourceImage() {
        BarChart barChart = new BarChart();
        barChart.showBarChart(buildBarChartMap(imageData.getSourceImagePixelData()), Names.BarChart.SOURCE_TITLE);
    }

    @Override
    public void showBarChartChangedImage() {
        BarChart barChart = new BarChart();
        barChart.showBarChart(buildBarChartMap(imageData.getChangedImagePixelData()), Names.BarChart.CHANGED_TITLE);
    }


    private Map<Integer, Number> buildBarChartMap(PixelData[][] imagePixelData) {

        int width = imagePixelData.length;
        int height = imagePixelData[0].length;

        Map<Integer, Number> barChartMap = new TreeMap<>();

        for(int i = 0; i < 256; i++) {
            barChartMap.put(i, 0);
        }

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                barChartMap.put(imagePixelData[i][j].getBrightness(),
                        barChartMap.get(imagePixelData[i][j].getBrightness()).intValue() + 1);
            }
        }
        return barChartMap;
    }
}
