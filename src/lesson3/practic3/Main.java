package lesson3.practic3;

import lesson3.Phonebook;

import java.util.*;

public class Main {

    public static void main(String[] args) {


/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
 * из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
  */
        String[] words = ("Java is a programming language and computing platform first released by Sun Microsystems in 1995. " +
                "There are lots of applications and websites that will not work unless you have Java installed, and more are " +
                "created every day. Java is fast, secure, and reliable. From laptops to datacenters, game consoles to scientific " +
                "supercomputers, cell phones to the Internet, Java is everywhere!").split(" ");

        Map<String, Integer> countMap = new LinkedHashMap<>(words.length);
        for (String word: words)
        {
            Integer num = countMap.get(word);
            countMap.put(word, (num == null ? 1 : ++num));
        }

        for (Map.Entry<String, Integer> pair: countMap.entrySet())
        {
            if(pair.getValue() == 1)
                System.out.println(pair.getKey());
        }

        System.out.println("");
        for (Map.Entry<String, Integer> pair: countMap.entrySet())
        {
            if(pair.getValue() > 1)
                System.out.println(pair);
        }

        System.out.println("");

/**
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный
 * справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть,
 * что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться
 * все телефоны.
 */

        Phonebook phonebook = new Phonebook();

        phonebook.add("Petya", 5883868);
        phonebook.add("Masha", 6785434);
        phonebook.add("Vasya", 5831209);
        phonebook.add("Petya", 3369870);


        phonebook.get("Masha");
        phonebook.get("Petya");

    }
}
