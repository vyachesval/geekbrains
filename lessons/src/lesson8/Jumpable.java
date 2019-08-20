package lesson8;

public interface Jumpable {
    void jump(int h, int y);
    default void jump1(){
        System.out.println("jump1()");
    }
}
