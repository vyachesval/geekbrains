package lesson3;

import java.lang.reflect.Array;
import java.util.*;

public class Phonebook {

    LinkedHashMap<String, ArrayList<Integer>> phonebook = new LinkedHashMap<>();

    public void add(String name, Integer number){
        ArrayList<Integer> numbers = phonebook.get(name);
        if(numbers == null)
            phonebook.put(name, new ArrayList<Integer>(List.of(number)));
        else
            numbers.add(number);
    }

    public void get(String name){
        System.out.println(name + ":" + phonebook.get(name));

    }

}
