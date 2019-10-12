package Lesson3;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        List<String> listOfWords = new ArrayList<>(15); //Я знаю, что будет 15, поэтому указал
        listOfWords.addAll(List.of("apple", "banana", "red", "blue", "green", "cat",
                "blue", "cat", "cat", "blue", "blue", "red", "green", "dog", "blue"));  //Вносим 15 значений
        System.out.println("Массив слов:\n" + listOfWords);

        //Создаем мар чтобы вывести уникальные слова и их кол-во
        Map<String, Integer> mapOfWordsAmount = counting(listOfWords);
        System.out.println("Уникальные слова и их количество повторений:\n" + mapOfWordsAmount);
    }

    private static Map<String, Integer> counting(List<String> listOfWords) {
        Map<String, Integer> mapOfWordsAmount = new HashMap<>();
        for (String a : listOfWords) {
            mapOfWordsAmount.merge(a, 1, Integer::sum);      //Добавляем новую запись, если такой нет, либо прибавляем единицу кол-ву
        }
        return mapOfWordsAmount;
    }
}
