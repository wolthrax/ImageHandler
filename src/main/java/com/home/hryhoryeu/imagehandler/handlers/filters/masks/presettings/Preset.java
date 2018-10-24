package com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings;

public interface Preset {

    default double[][] getPreset2X2() {
        return new double[][]{{}};
    }
    default double[][] getPreset3X3() {
        return new double[][]{{}};
    }
    default double[][] getPreset4X4() {
        return new double[][]{{}};
    }
    default double[][] getPreset5X5() {
        return new double[][]{{}};
    }
    default double[][] getPreset7X7() {
        return new double[][]{{}};
    }

}
