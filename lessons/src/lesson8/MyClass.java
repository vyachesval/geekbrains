package lesson8;

public class MyClass {
    Jumpable jumpable;

    public MyClass(Jumpable jumpable) {
        this.jumpable = jumpable;
    }

    public void someThink(int a, int b){
        jumpable.jump(a,b);
    }
}
