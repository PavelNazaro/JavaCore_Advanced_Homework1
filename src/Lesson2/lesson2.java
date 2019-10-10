package Lesson2;

public class lesson2 {
    private static final int LENGTH_X = 4;
    private static final int LENGTH_Y = 4;

    public static void main(String[] args) {
        String[][] arr = {{"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
        };

        try {
            System.out.println("Сумма = " + arrayProcessing(arr));     //Вызываем метод по заданию
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int arrayProcessing(String[][] arr) {
        //Задание 1
        System.out.println("Задание 1:");
        checkArraySize(arr);
        System.out.println("Массив верного размера!");

        //Задание 2
        System.out.println("\nЗадание 2:");

        return arraySumCheck(arr);
    }

    private static int arraySumCheck(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);   //Бросаем исключение ошибки в преобразовании
                }
            }
        }
        return sum;
    }

    private static void checkArraySize(String[][] arr) {
        if (arr.length == LENGTH_Y){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != LENGTH_X) {
                    throw new MyArraySizeException(LENGTH_X, LENGTH_Y);           //Бросаем исключение неверного размера массива
                }
            }
        }
        else {
            throw new MyArraySizeException(LENGTH_X, LENGTH_Y);           //Бросаем исключение неверного размера массива
        }
    }
}
