package com.home.hryhoryeu.imagehandler.handlers.filters.masks.types;

import com.home.hryhoryeu.imagehandler.handlers.filters.masks.Mask;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.Preset;

public class Mask2X2 implements Mask {

    private Preset preset;

    public Mask2X2(Preset preset) {
        this.preset = preset;
    }

    @Override
    public double[][] getMask() {
        return preset.getPreset2X2();
    }
}
