package Lesson3;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        List<String> listOfWords = new ArrayList<>(15); //Я знаю, что будет 15, поэтому указал
        listOfWords.addAll(List.of("apple", "banana", "red", "blue", "green", "cat",
                "blue", "cat", "cat", "blue", "blue", "red", "green", "dog", "blue"));  //Вносим 15 значений
        System.out.println("Массив слов:\n" + listOfWords);

        //Создаем Сет и добаляем в него все значения из listInteger
        //Добавятся только уникальные значения
        Set<String> list1 = new HashSet<>();
        list1.addAll(listOfWords);
        System.out.println("Массив уникальных значений:\n" + list1);

        //Создаем мар чтобы показать, сколько раз встречается каждое слово
        Map<String, Integer> mapOfWordsAmount = new HashMap<>();
        mapOfWordsAmount = counting(listOfWords, list1);
        System.out.println("Количество повторений каждого слова:\n" + mapOfWordsAmount);
    }

    private static Map<String, Integer> counting(List<String> listOfWords, Set<String> list1) {
        Map<String, Integer> mapOfWordsAmount = new HashMap<>();
        for (String a : listOfWords) {
            for (String b : list1) {
                if (a.equals(b)) {
                    try {       //Если в мапе уже есть такая запись, то прибавляем к вэлью 1
                        mapOfWordsAmount.put(b,mapOfWordsAmount.get(b)+1);
                    } catch (Exception e) {
                        mapOfWordsAmount.put(b,1);      //Если нет то добавляем новую запись
                    }
                    break;
                }
            }
        }
        return mapOfWordsAmount;
    }
}
