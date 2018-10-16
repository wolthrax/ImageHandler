package com.home.hryhoryeu.imagehandler.managers;

import com.home.hryhoryeu.imagehandler.handlers.element.IElementHandler;
import com.home.hryhoryeu.imagehandler.handlers.filters.IFilter;

public interface IHandleManager {

    void setElementHandler(IElementHandler elementHandler);
    void setFilter(IFilter filter);

}
