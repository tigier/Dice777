package controll;

import model.Dice;

public class Controller {

    private int points;
    private Dice dice;
    private int[] player1;
    private int[] player2;
    private boolean player;
    private boolean started;
    private boolean ai;

    public void start(){
        this.points = 0;
        this.dice = new Dice();
        if((int)((Math.random())*2) == 0){
               this.player = true;
        }
        this.player1 = new int[0];
        this.player2 = new int[0];
        this.setDiceUp((int)((Math.random())*6+1));
        this.started = true;
    }

    public int getDiceUp(){
        return this.dice.getUp();
    }

    public void setDiceUp(int i){
        this.dice.setUp(i);
        this.points += i;
        if(this.isPlayer()){
            addPoints2(i);
            this.player = false;
        }
        else{
            addPoints1(i);
            this.player = true;
        }
    }

    public int getPoints() {
        return this.points;
    }

    public boolean isPlayer() {
        return player;
    }

    public boolean isStarted() {
        return started;
    }

    private void addPoints1(int points){
        int[] help = new int[player1.length + 1];
        for(int i = 0; i < player1.length; i++){
            help[i] = player1[i];
        }
        help[player1.length] = points;
        player1 = help;
    }

    public void end(){
        this.started = false;
    }

    private void addPoints2(int points){
        int[] help = new int[player2.length + 1];
        for(int i = 0; i < player2.length; i++){
            help[i] = player2[i];
        }
        help[player2.length] = points;
        player2 = help;
    }

    public int[] getPlayer1() {
        return player1;
    }

    public int[] getPlayer2() {
        return player2;
    }

    public boolean isAi() {
        return ai;
    }

    public void activateai(){
        ai = true;
    }

    public void deactivateai(){
        ai = false;
    }
}
