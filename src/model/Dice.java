package model;

public class Dice {

    private int up;

    public Dice() {
        this.up = (int)((Math.random())*6+1);
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getUp() {
        return this.up;
    }
}
