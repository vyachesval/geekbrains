package lesson1;

public class Cat extends Animal implements MyInterface, SuperJumpable {
    @Override
    public void run() {
        System.out.println("run...");
    }

    @Override
    public boolean isSleep() {
        return false;
    }

    @Override
    public void jump(int h) {
        System.out.println("Jump...");
    }

    @Override
    public void superJump() {

    }
}
