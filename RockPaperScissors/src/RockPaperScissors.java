public class RockPaperScissors{
    private int GAMEOVERSCORE = 3;

    public boolean gameOver(Player pl1, Player pl2){
        if(pl1.score == GAMEOVERSCORE){
            System.out.println(pl1.name + " WINS THE GAME. \n");
            return false;
        }
        if(pl2.score == GAMEOVERSCORE){
            System.out.println(pl2.name + " WINS THE GAME. \n");
            return false;
        }
        return true;
    }
    public void winner(Player pl1, Player pl2){
        System.out.println(pl1.name + " select " + pl1.choice + ", " + pl2.name + " select " + pl2.choice);

        if(pl1.choice.equals(pl2.choice)) System.out.println("It's tie.");
        else if(pl1.choice == Choice.ROCK){
            if(pl2.choice == Choice.SCISSORS){
                System.out.println(pl1.name + " wins this round.");
                pl1.score++;
            }
            else if(pl2.choice == Choice.PAPER){
                System.out.println(pl2.name + " wins this round.");
                pl2.score++;
            }
        }
        else if(pl1.choice == Choice.PAPER){
            if(pl2.choice == Choice.ROCK){
                System.out.println(pl1.name + " wins this round.");
                pl1.score++;
            }
            else if(pl2.choice == Choice.SCISSORS){
                System.out.println(pl2.name + " wins this round.");
                pl2.score++;
            }
        }
        else if(pl1.choice == Choice.SCISSORS){
            if(pl2.choice == Choice.PAPER){
                System.out.println(pl1.name + " wins this round.");
                pl1.score++;
            }
            else if(pl2.choice == Choice.ROCK){
                System.out.println(pl2.name + " wins this round.");
                pl2.score++;
            }
        }

        System.out.println(pl1.name + " : " + pl1.score + " || " + pl2.name + " : " + pl2.score + "\n");
    }
    public static void main(String[] args){
        Player player1 = new Player("Ahmet");
        Player player2 = new Player("Eren");
        RockPaperScissors rPS = new RockPaperScissors();
        
        while(rPS.gameOver(player1, player2)){
            double p1Move = Math.random();
            double p2Move = Math.random();

            if(p1Move > 0.66) player1.Rock();
            else if(p1Move > 0.33) player1.Paper();
            else player1.Scissors();;
            
            if(p2Move > 0.66) player2.Rock();
            else if(p2Move > 0.33) player2.Paper();
            else player2.Scissors();;

            rPS.winner(player1, player2);
        }
    }
}
