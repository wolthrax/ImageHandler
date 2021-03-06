package com.home.hryhoryeu.imagehandler.config;

public interface ConfigParams {

    interface Size {
        Integer BAR_CHART_WIDTH = 1000;
        Integer BAR_CHART_HEIGHT = 600;

        Integer FULL_SIZE_WIDTH = 1000;
        Integer FULL_SIZE_HEIGHT = 600;
    }

    interface Value {
        Integer MAX = 255;
        Integer MIN = 0;
    }

    interface Position {
        Integer START = 0;
    }

    interface Style {
        String DEFAULT_STYLE_URL = "/css/style.css";
    }

}
