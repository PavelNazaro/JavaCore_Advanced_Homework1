package Lesson2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Подан массив неправильного размера!");
    }
}