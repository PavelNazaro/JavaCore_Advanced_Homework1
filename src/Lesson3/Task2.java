package Lesson3;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Map<Integer, String> phoneBook = new HashMap<>();
        addNamesAndPhones(phoneBook);

        //Вывод телефонной книги:
        System.out.println(phoneBook);

        //Поиск номера телефона по фамилии:
        findPhoneByName(phoneBook, "Смирнов");
        findPhoneByName(phoneBook, "Сидоров");
    }

    private static void addNamesAndPhones(Map<Integer, String> phoneBook) {
        phoneBook.put(5444644, "Иванов");
        phoneBook.put(3469831, "Смирнов");
        phoneBook.put(4433685, "Сидоров");
        phoneBook.put(3456787, "Сидоров");
        phoneBook.put(2345677, "Петров");
    }

    private static void findPhoneByName(Map<Integer, String> phoneBook, String name) {
        for (int key : phoneBook.keySet()){
            String value = phoneBook.get(key);
            if (value.equals(name)){
                System.out.println("Номер телефона по фамилии '" + name + "': " + key);
            }
        }
    }
}
