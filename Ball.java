package ru.gb.java2_stream200512_lesson_1;

import java.awt.*;

public class Ball extends Sprite { // 25 создаем шарик, наследники спрайта, которые умеют апдейтиться и рендереиться

    /*Color color = new Color((int) (Math.random() * 255), // добавляем цвет РГБ, маф.рандом генерирует флоат, а нам нужны инты
            (int) (Math.random() * 255),
            (int) (Math.random() * 255));*/

    AntiVyrviGlaz antiVyrviGlaz = new AntiVyrviGlaz();

    private float vX = (float) (100f + (Math.random() * 200f));
    private float vY = (float) (100f + (Math.random() * 200f));

    Ball() { // конструктор мячика, который задает ему случайный размер
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime; // координата будет приростать как скрость*время
        y += vY * deltaTime; // т.к. координата будет изменяться как произведения скорости на время
        if (getLeft() < canvas.getLeft()) { // 34 если край мячика ушел за граница кантвы, то
            setLeft(canvas.getLeft()); // нужно поставить его на край конвы (getLeft) и
            vX = -vX; // поменять знак скорости на противоположный
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(antiVyrviGlaz.generateColor()); //color
        g.fillOval((int) getLeft(), (int) getTop(), // отрисовываем заполненный овал по
                // координатам левый верхний угол, ширина, выстова
                (int) getWidth(), (int) getHeight());
    }
}
