package ru.gb.java2_stream200512_lesson_1;

import java.awt.*;

public class Background extends Sprite {// дз1. Наследуем фон он спрайтов, поскольку будем их отрисовывать
                                        // непосредственно перед отрисовкой шаров

    private AntiVyrviGlaz antiVyrviGlaz = new AntiVyrviGlaz();

    @Override
    public void update(MainCanvas canvas, float deltaTime) { // дз2. определяем цвет тремя байтами РГБ

    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(antiVyrviGlaz.generateColor());
        g.fillRect(canvas.getLeft(), canvas.getTop(), canvas.getRight(), canvas.getBottom()); //передаем гарабарыт окна
        // фона из окна канвы
    }


}

