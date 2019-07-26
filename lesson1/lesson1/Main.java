package lesson1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*
        Box box = new Box();
        SuperBox superBox = new SuperBox(6);
        System.out.println(superBox instanceof Box);
*/

        Cat cat = new Cat();
        cat.fly();
        System.out.println(MyInterface.q);

        Jumpable jumpable = new Cat();
        ((Cat) jumpable).run();
        jumpable.jump(5);
    }
}
