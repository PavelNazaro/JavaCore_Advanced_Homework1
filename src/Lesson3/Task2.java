package Lesson3;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Map<String, List<Integer>> phoneBook = new HashMap<>();
        addNamesAndPhones(phoneBook);

        //Вывод телефонной книги:
        System.out.println(phoneBook);

        //Поиск номера телефона по фамилии:
        System.out.println("Номер телефона по фамилии Смирнов: " + phoneBook.get("Смирнов"));
        System.out.println("Номер телефона по фамилии Сидоров: " + phoneBook.get("Сидоров"));
    }

    private static void addNamesAndPhones(Map<String, List<Integer>> phoneBook) {
        putPhoneBook(phoneBook, "Иванов", 5444644);
        putPhoneBook(phoneBook, "Смирнов", 3469831);
        putPhoneBook(phoneBook, "Сидоров", 4433685);
        putPhoneBook(phoneBook, "Сидоров", 3456787);
        putPhoneBook(phoneBook, "Петров", 2345677);
    }

    private static void putPhoneBook(Map<String, List<Integer>> phoneBook, String name, int number) {
        List<Integer> getPhoneBookValue = phoneBook.get(name);
        List<Integer> list = new ArrayList<>();
        list.add(number);
        if (getPhoneBookValue != null) {
            list.addAll(getPhoneBookValue);
        }
        phoneBook.put(name, list);
    }
}