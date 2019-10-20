package Lesson5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);    //Заполняем массив единицами

        method1(arr);
        method2(arr);
    }

    private static void method1(float[] arr) {
        long a = System.currentTimeMillis();

        modifyArr(arr);

        System.out.println(System.currentTimeMillis() - a);
    }

    private static void method2(float[] arr) throws InterruptedException {
        float[] a1 = new float[H];
        float[] a2 = new float[H];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);

        Thread thread1 = new Thread(() -> modifyArr(a1));
        Thread thread2 = new Thread(() -> modifyArr(a2));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);

        System.out.println(System.currentTimeMillis() - a);
    }

    private static void modifyArr(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}