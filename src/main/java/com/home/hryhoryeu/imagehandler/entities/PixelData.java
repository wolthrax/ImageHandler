package com.home.hryhoryeu.imagehandler.entities;

public class PixelData {

    private int positionX;
    private int positionY;
    private int R;
    private int G;
    private int B;
    private int brightness;

    public PixelData(int positionX, int positionY, int r, int g, int b, int brightness) {
        this.positionX = positionX;
        this.positionY = positionY;
        R = r;
        G = g;
        B = b;
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

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public String toString() {
        return "PixelData{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                ", R=" + R +
                ", G=" + G +
                ", B=" + B +
                ", brightness=" + brightness +
                '}';
    }
}
