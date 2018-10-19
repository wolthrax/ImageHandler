package com.home.hryhoryeu.imagehandler.handlers.filters.impl;

import com.home.hryhoryeu.imagehandler.handlers.filters.IFilter;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.Mask;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.presettings.EmbossPreset;
import com.home.hryhoryeu.imagehandler.handlers.filters.masks.types.Mask3X3;

public class Emboss implements IFilter {

    @Override
    public void handle() {

        Mask mask = new Mask3X3(new EmbossPreset());

        System.out.println(mask.getMask()[2][2]);

    }
}
