package com.home.hryhoryeu.imagehandler.entities.enums;

public enum Matrix {
    MATRIX_3X3(1),
    MATRIX_5X5(2),
    MATRIX_7X7(3),

    MATRIX_2X2(2),
    MATRIX_4X4(4);

    private final int size;

    Matrix(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
