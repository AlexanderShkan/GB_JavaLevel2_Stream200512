package ru.gb.java2_stream200512_lesson_5;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    private static void StuffArray(float [] arr){
        for (int i = 0; i < size; i++) {
            arr[i]=1f;
        }
    }

    public static void NewValue(float [] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void main(String[] args) {

        System.out.println("Время работы метода 1 составило: " + Method_one()+" м.сек.");
        //System.out.println("Время работы метода 2 составило, мс.: " + Method_2());
    }
    private static long Method_one(){
        StuffArray(arr);
        long a = System.currentTimeMillis();
        NewValue(arr);
        return (System.currentTimeMillis()-a);

    }
}


