package Lesson2;

public class lesson2 {
    public static void main(String[] args) {
        String[][] mas = new String[4][4];

        newMethodTest(mas);     //Вызываем метод по заданию
    }

    private static void newMethodTest(String[][] mas) {
        //Задание 1
        System.out.println("Задание 1:");
        if (mas.length != 4 || mas[0].length != 4)
            throw new MyArraySizeException();           //Бросаем исключение неверного размера массива
        else
            System.out.println("Все ок!");
    }
}
