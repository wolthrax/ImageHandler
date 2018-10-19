package com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings;

public class EmbossPreset implements Preset {

    @Override
    public double[][] getPreset3X3() {
        return new double[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, -1}
        };
    }

    @Override
    public double[][] getPreset5X5() {
        return new double[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 0, -1, 0},
                {0, 0, 0, 0, -1}
        };
    }

    @Override
    public double[][] getPreset7X7() {
        return new double[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, -1, 0, 0},
                {0, 0, 0, 0, 0, -1, 0},
                {0, 0, 0, 0, 0, 0, -1},
        };
    }
}
