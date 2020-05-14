package ru.gb.java2_stream200512_lesson_1;

import java.awt.*;

public abstract class Sprite { // единица двухмерной графики. Спрайты всегда прямоугольные, в них вписаны фигуры
    protected float x; // концепуия двумерного объекта (где-то находится и что-то имеет)
    protected float y; // Спрайт асбракция, а нам надо двигаит реальные вещи, поэтому наследники - шарики уже все знают
    protected float halfWidth; // полувысота
    protected float halfHeight; // полуширина

    protected float getLeft() { // достать левую границу:
        return x - halfWidth; // взять коорлинату Х и вычисть полувысоту
    }
    protected void setLeft(float left) {
        x = left + halfWidth;
    }
    protected float getRight() {
        return x + halfWidth;
    }
    protected void setRight(float right) {
        x = right - halfWidth;
    }
    protected float getTop() {
        return y - halfHeight;
    }
    protected void setTop(float top) {
        y = top + halfHeight;
    }
    protected float getBottom() {
        return y + halfHeight;
    }
    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }
    protected float getWidth() {
        return 2f * halfWidth;
    }
    protected float getHeight() {
        return 2f * halfHeight;
    }

    public void update(MainCanvas canvas, float deltaTime) {}

    public void render(MainCanvas canvas, Graphics g) {}
}

