package com.home.hryhoryeu.imagehandler.handlers.filters.masks.types;

import com.home.hryhoryeu.imagehandler.handlers.filters.masks.Mask;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.Preset;

public class Mask5X5 implements Mask {

    private Preset preset;

    public Mask5X5(Preset preset) {
        this.preset = preset;
    }

    @Override
    public double[][] getMask() {
        return preset.getPreset5X5();
    }
}
