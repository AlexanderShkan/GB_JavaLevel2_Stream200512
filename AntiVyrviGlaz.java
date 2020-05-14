package ru.gb.java2_stream200512_lesson_1;

import java.awt.*;

public class AntiVyrviGlaz { // знаю что траслитом называть это плохо

    public static final int BYTE_MAX_VALUE = 255;
    int red = (int) (Math.random()*BYTE_MAX_VALUE);
    int green = (int) (Math.random()*BYTE_MAX_VALUE);
    int blue = (int) (Math.random()*BYTE_MAX_VALUE);

    public static final int LIMIT = 4;
    int divRed = (int) (Math.random()*LIMIT);
    int divGreen = (int) (Math.random()*LIMIT);
    int divBlue = (int) (Math.random()*LIMIT);

    public Color generateColor () {
         if (red+divRed > BYTE_MAX_VALUE || red+divRed < 0) {
             divRed = -divRed;
         }
         red = red + divRed;

         if (green+divGreen > BYTE_MAX_VALUE || green+divGreen < 0) {
            divGreen = -divGreen;
        }
         green = green + divGreen;

         if (blue+divBlue > BYTE_MAX_VALUE || blue+divBlue < 0) {
            divBlue = -divBlue;
        }
         blue = blue + divBlue;

         return new Color(red, green, blue);

    }


}
 