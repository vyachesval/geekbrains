package lesson1;

public class Box {

    public Box() {

    }

    public Box(int w) {
        this.w = w;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        if(w>0){
            this.w = w;
        }
    }

    private int w;


}
