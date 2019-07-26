package lesson1;

public interface MyInterface {
    int q=5;

    void run();
    boolean isSleep();
    default void fly(){
        System.out.println(" не умею летать");
    }
}
