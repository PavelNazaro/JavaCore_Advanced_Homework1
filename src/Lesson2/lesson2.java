package Lesson2;

public class lesson2 {
    public static void main(String[] args) {
        //String[][] mas = new String[4][4];
        String[][] mas = {{"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                //{"13","14","15","16"}
        };

        try {
            System.out.println("Сумма = " + newMethodTest(mas));     //Вызываем метод по заданию
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int newMethodTest(String[][] mas) {
        int sum = 0;

        //Задание 1
        System.out.println("Задание 1:");
        if (mas.length != 4 || mas[0].length != 4)
            throw new MyArraySizeException();           //Бросаем исключение неверного размера массива
        else
            System.out.println("Все ок!");

        //Задание 2
        System.out.println("\nЗадание 2:");
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                try {
                    sum += Integer.parseInt(mas[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);   //Бросаем исключение ошибки в преобразовании
                }
            }
        }
        return sum;
    }
}
