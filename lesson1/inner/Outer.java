package lesson1.inner;

import java.util.LinkedList;

public class Outer {
    private int x=6;

    class Inner{
        private int y=9;
        void printOut(){
            System.out.println(x);
        }
    }

    void printIn(){
        System.out.println(new Inner().y);
    }

    void someThink(){
        for (int i = 0; i < 10; i++) {
            class LocalInner{
                void printOut(){
                    System.out.println(x);
                }
            }
        }
    }


}
