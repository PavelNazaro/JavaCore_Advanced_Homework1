package Lesson2;

public class MyArrayDataException extends MyException {
    public MyArrayDataException(int i, int j) {
        super("В ячейке [" + j + "," + i + "] неверные данные!");
    }
}
