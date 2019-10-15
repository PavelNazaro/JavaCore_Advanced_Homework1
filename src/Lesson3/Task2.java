package Lesson3;

import java.util.*;

public class Task2 {
    private static Map<String, Set<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        addNamesAndPhones(phoneBook);

        //Вывод телефонной книги:
        System.out.println(phoneBook);

        //Поиск номера телефона по фамилии:
        System.out.println("Номер телефона по фамилии Смирнов: " + phoneBook.get("Смирнов"));
        System.out.println("Номер телефона по фамилии Сидоров: " + phoneBook.get("Сидоров"));
    }

    private static void addNamesAndPhones(Map<String, Set<String>> phoneBook) {
        putPhoneBook("Иванов", "544-46-44");
        putPhoneBook("Смирнов", "346-98-31");
        putPhoneBook("Сидоров", "443-36-85");
        putPhoneBook("Сидоров", "345-67-87");
        putPhoneBook("Петров", "234-56-77");
    }

    private static void putPhoneBook(String name, String number) {
        Set<String> phones = phoneBook.computeIfAbsent(name, key -> new HashSet<>());
        phones.add(number);
    }
}