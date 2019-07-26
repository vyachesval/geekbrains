package lesson1.maraphon.competitors;

public class Human implements Competitor {

    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean active;

    public Human( String name) {
        this.name = name;
        this.maxRunDistance = 3000;
        this.maxJumpHeight = 2;
        this.maxSwimDistance = 100;
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " справился с кроссом");
        } else {
            System.out.println(name + " провалил кроссом");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " справился с прыжком");
        } else {
            System.out.println(name + " провалил прыжок");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " плавать не умеет");
            active = false;
            return;
        }
        if (dist <= maxSwimDistance) {
            System.out.println(name + " проплыл удачно");
        } else {
            System.out.println(name + " не смог проплыть");
            active = false;
        }
    }

    @Override
    public boolean isDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(name +" На дистанции: " + active);
    }
}
