public class Player{
    public String name;
    public int[][] dices = new int[7][7];
    public int dice1;
    public int dice2;
    public int lastThrownTotal = 1;

    public void Roll(){
        dice1 = (int)(Math.random()*6 + 1);
        dice2 = (int)(Math.random()*6 + 1);
        dices[dice1][dice2]++;
    }

    public Player(String name){
        this.name = name;
    }
}
