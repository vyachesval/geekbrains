package lesson8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);

//        Collections.sort(list);
//        list.sort(Comparator.naturalOrder());
//        list.sort(Comparator.reverseOrder());
//        Comparator<Integer> comparator = (x,y)->x%10-y%10;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        list.sort(comparator);
        System.out.println(list);

        List<String> listSt = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            listSt.add(""+random.nextInt(100));
        }
        System.out.println(listSt);

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };

        Jumpable jumpable = (a,b)->{
            System.out.println("jump"+a+"   "+b);
        };

        MyClass myClass = new MyClass((q,w)->{
            System.out.println(q+w);
        });

        myClass.someThink(3,6);

    }
}
