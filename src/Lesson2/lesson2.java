package Lesson2;

public class lesson2 {
    private static int lengthX = 4;
    private static int lengthY = 4;

    public static void main(String[] args) {
        String[][] arr = {{"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
        };

        try {
            System.out.println("Сумма = " + arrayProcessing(arr));     //Вызываем метод по заданию
        } catch (Exception e) {
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
        if (arr.length == lengthY){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != lengthX) {
                    throw new MyArraySizeException(lengthX, lengthY);           //Бросаем исключение неверного размера массива
                }
            }
        }
        else {
            throw new MyArraySizeException(lengthX, lengthY);           //Бросаем исключение неверного размера массива
        }
    }
}
