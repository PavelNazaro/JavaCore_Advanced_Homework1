package Lesson3;

import java.util.*;

public class Task2 {
    private static Map<String, List<Integer>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        addNamesAndPhones(phoneBook);

        //Вывод телефонной книги:
        System.out.println(phoneBook);

        //Поиск номера телефона по фамилии:
        System.out.println("Номер телефона по фамилии Смирнов: " + phoneBook.get("Смирнов"));
        System.out.println("Номер телефона по фамилии Сидоров: " + phoneBook.get("Сидоров"));
    }

    private static void addNamesAndPhones(Map<String, List<Integer>> phoneBook) {
        putPhoneBook("Иванов", 5444644);
        putPhoneBook("Смирнов", 3469831);
        putPhoneBook("Сидоров", 4433685);
        putPhoneBook("Сидоров", 3456787);
        putPhoneBook("Петров", 2345677);
    }

    private static void putPhoneBook(String name, int number) {
        List<Integer> getPhoneBookValue = phoneBook.get(name);
        List<Integer> phones = phoneBook.putIfAbsent(name, new ArrayList<>());
        if (getPhoneBookValue == null) {
            phoneBook.put(name, List.of(number));
        }
        else {
            phones.add(number);
            phoneBook.put(name, phones);
        }
        System.out.println(phones);


        
        //Было
//        List<Integer> phones = map.putIfAbsent(name, new ArrayList<>());
//        phones.add(number);

//        List<Integer> getPhoneBookValue = phoneBook.get(name);
//        List<Integer> list = new ArrayList<>();
//        list.add(number);
//        if (getPhoneBookValue != null) {
//            list.addAll(getPhoneBookValue);
//        }
//        System.out.println(phones);
//        phoneBook.put(name, list);
    }
}