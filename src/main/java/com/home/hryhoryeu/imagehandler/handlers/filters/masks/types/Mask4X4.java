package com.home.hryhoryeu.imagehandler.handlers.filters.masks.types;

import com.home.hryhoryeu.imagehandler.handlers.filters.masks.Mask;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.Preset;

public class Mask4X4 implements Mask {

    private Preset preset;

    public Mask4X4(Preset preset) {
        this.preset = preset;
    }

    @Override
    public double[][] getMask() {
        return preset.getPreset4X4();
    }
}
