package com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings;

public class BinaryImagePreset implements Preset {

    @Override
    public double[][] getPreset2X2() {
        return new double[][]{
                {127, 127},
                {127, 127}
        };
    }

    @Override
    public double[][] getPreset4X4() {
        return new double[][]{
                { 0,  4,  2,10},
                {12,  4, 14, 6},
                { 3, 11,  1, 9},
                {15,  7, 13, 5}
        };
    }
}
