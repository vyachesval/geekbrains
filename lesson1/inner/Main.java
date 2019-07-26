package lesson1.inner;

public class Main {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.printOut();

        Outer outer = new Outer();
        outer.printIn();
    }
}
