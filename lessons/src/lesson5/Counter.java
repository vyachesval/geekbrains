package lesson5;

public class Counter {
    private int c;

    public Counter() {
        this.c = 0;
    }

    public int getC() {
        return c;
    }
    //        синхронизация по методу
//    synchronized
    public  void inc(){
        c++;
    }

//    synchronized
    public  void dec(){
        c--;
    }
}
