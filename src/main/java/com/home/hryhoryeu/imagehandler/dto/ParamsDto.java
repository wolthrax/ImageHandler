package com.home.hryhoryeu.imagehandler.dto;

public class ParamsDto {

    private Integer gMin;
    private Integer gMax;

    private Integer fMin;
    private Integer fMax;

    public ParamsDto(Integer gMin, Integer gMax, Integer fMin, Integer fMax) {
        this.gMin = gMin;
        this.gMax = gMax;
        this.fMin = fMin;
        this.fMax = fMax;
    }

    public ParamsDto(Integer gMin, Integer gMax) {
        this.gMin = gMin;
        this.gMax = gMax;
    }

    public Integer getgMin() {
        return gMin;
    }

    public void setgMin(Integer gMin) {
        this.gMin = gMin;
    }

    public Integer getgMax() {
        return gMax;
    }

    public void setgMax(Integer gMax) {
        this.gMax = gMax;
    }

    public Integer getfMin() {
        return fMin;
    }

    public void setfMin(Integer fMin) {
        this.fMin = fMin;
    }

    public Integer getfMax() {
        return fMax;
    }

    public void setfMax(Integer fMax) {
        this.fMax = fMax;
    }
}
