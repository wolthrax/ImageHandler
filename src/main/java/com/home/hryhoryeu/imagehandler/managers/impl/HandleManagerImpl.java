package com.home.hryhoryeu.imagehandler.managers.impl;

import com.home.hryhoryeu.imagehandler.handlers.element.IElementHandler;
import com.home.hryhoryeu.imagehandler.handlers.filters.IFilter;
import com.home.hryhoryeu.imagehandler.managers.IHandleManager;

public class HandleManagerImpl implements IHandleManager {

    public void setElementHandler(IElementHandler elementHandler) {
        elementHandler.handle();
    }

    public void setFilter(IFilter filter) {
        filter.handle();
    }
}
