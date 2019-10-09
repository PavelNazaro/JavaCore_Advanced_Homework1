package Lesson2;

public class MyArrayDataException extends ClassCastException {
    public MyArrayDataException(int i, int j) {
        super("В ячейке [" + j + "," + i + "] неверные данные!");
    }
}
