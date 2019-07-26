package lesson1.enums;

public class Main {
    public static void main(String[] args) {
        System.out.println(Fruit.Chery);
        System.out.println(Fruit.Chery == Fruit.Chery);

        for (Fruit f:Fruit.values()) {
            System.out.println(f+" "+ f.getWeigth());
        }
    }
}
