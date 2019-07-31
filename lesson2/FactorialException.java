package lesson2;

public class FactorialException extends Exception{
    private int value;

    public int getValue() {
        return value;
    }

    public FactorialException(String s) {
    }

    public FactorialException(int value) {
        this.value = value;
    }
}
