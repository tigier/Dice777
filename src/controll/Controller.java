package controll;

import model.Dice;

import java.awt.*;

public class Controller {

    private int points;
    private Dice dice;
    private int[] player1;
    private int[] player2;
    private boolean player;

    public void start(){
        this.dice = new Dice();
        this.points = this.dice.getUp();
        this.player1 = new int[1];
        this.player2 = new int[0];
        this.player1[0] = points;
    }

    public void addPoints(int dice){
        this.dice.setUp(dice);
    }

    public int getDiceUp(){
        return this.dice.getUp();
    }

    public int getPoints() {
        return this.points;
    }
}
