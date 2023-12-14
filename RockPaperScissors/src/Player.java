enum Choice{
    ROCK,
    PAPER,
    SCISSORS
}
public class Player{
    public Choice choice;
    public String name;
    public int score;

    public void Rock(){
        choice = Choice.ROCK;
    }
    public void Paper(){
        choice = Choice.PAPER;
    }
    public void Scissors(){
        choice = Choice.SCISSORS;
    }
    
    public Player(String name){
        this.name = name;
    }
}