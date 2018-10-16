package com.home.hryhoryeu.imagehandler.entities;

public class PixelData {

    private int positionX;
    private int positionY;
    private int R;
    private int G;
    private int B;
    private int brightness;
    private int hue;
    private int saturation;

    public PixelData(int positionX, int positionY, int r, int g, int b, int hue, int saturation, int brightness) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.R = r;
        this.G = g;
        this.B = b;
        this.hue = hue;
        this.saturation = saturation;
        this.brightness = brightness;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        G = g;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
