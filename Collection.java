package ru.gb.java2_stream200512_lesson_3;

import java.util.HashMap;

public class Collection {

    public static void main(String[] args) {
        String text = "Скажи-ка, дядя, ведь не даром" +
                      "Москва, спаленная пожаром," +
                      "Французу отдана?"+
                      "Ведь были ж схватки боевые,"+
                      "Да, говорят, еще какие!"+
                      "Недаром помнит вся Россия"+
                      "Про день Бородина!"+

                       "Да, были люди в наше время,"+
                       "Не то, что нынешнее племя:"+
                       "Богатыри — не вы!"+
                       "Плохая им досталась доля:"+
                       "Немногие вернулись с поля..."+
                       "Не будь на то господня воля,"+
                       "Не отдали б Москвы!";
        int i;
        String[] textArray;
        HashMap<String, Integer> textMap = new HashMap<>();
        textArray = text.split(" ");
        System.out.println("Общее количество слов в массиве: " + textArray.length);
        for (String s : textArray) {
            if (textMap.containsKey(s)) {
                i = textMap.get(s);
                i++;
                textMap.put(s, i);
            } else textMap.put(s, 1);
        }
        System.out.println("Слова, не повторяющиеся в массиве: " + textMap.size());
    }
}
