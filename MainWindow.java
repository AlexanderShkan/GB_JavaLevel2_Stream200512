package ru.gb.java2_stream200512_lesson_1;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame { // 1. Основное окно для приложения с летающими шариками, основной контроллер игры
                                            // ЖдейФрейм класс, который символизирует окно с  _ Х

    private static final int POS_X = 400; // габариты главного окна
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10]; // 23 в нащей программе будет масов спрайтов из Х элементов

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // 2. класс SwingUtilities статический метод invokeLater вызов конструктора Runnable
            // передаем аргумент метода
            @Override // 3. внутри объекта Раннибле есть метод ран, который мы переопределяем
            public void run() { // ран это метод класса Раннибл
                // тело метода
                new MainWindow(); // вызов пустого конструктора, создание объекта МВ
            }
        });
    }

    private MainWindow() { // 4. игровое окно с размерами
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // что делаем при закрытии
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT); // принимает в аргументы габариты окна
        setResizable(false); // делаем окно с неизменеяемыми размерами
        MainCanvas canvas = new MainCanvas(this); //10. добавдяем канву (передаем себя)
        initApplication(); // 24 Инициализируем наше приложение при старте
        add(canvas); // 10. добавляем канву
        setTitle("Circles"); // заголовок окна
        setVisible(true); // делаем окно видимым
    }

    private void initApplication() { // заполяем массив спратов
        //при отрисовки канвы будем говорить нарисуй спрайт и подвинь его - аптейт+рендер

            sprites[0] = new Background(); //дз

            for (int i = 1; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) { // 11 выполяем метод когда конва перерисовалась, передаем дельту времени
        // канва может только рисваться, контролиет это конроллер
        update(canvas, deltaTime); // 15 обновление объектов которые находятся на канве, относительно прошедшего времени
        // чтоб знать на сколько шарики пролетели
        render(canvas, g); // 16 отрисовывать все компоенеты, которые находятся на канве при помощи объектов графики

    }

    private void update(MainCanvas canvas, float deltaTime) { // метод, который обновляет полодения/состояние мячиков
        // в зависимости от координат, сколько времени прошло, на столько и передвинуть мячик
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) { // отрисовываем мячи
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}