package Lesson2;

public class MyArraySizeException extends MyExceptions {
    public MyArraySizeException(int lengthX, int lengthY) {
        super("Подан массив неправильного размера!\nПравильный размер массива: " + lengthY + " х " + lengthX);
    }
}