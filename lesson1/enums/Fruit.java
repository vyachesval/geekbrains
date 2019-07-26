package lesson1.enums;

public enum Fruit {
    Orange(200) , Chery(30), Banana(80), Apple(150);

    private int weight;

    Fruit() {
    }

    Fruit(int weigth) {
        this.weight = weigth;
    }

    public int getWeigth() {
        return weight;
    }
}
