public class CrabGame{
    // Win conditions 6+6 5+5 3+3 or sum = 7 || lose conditions 4+4 2+2 1+1 for first turn.
    // In second and consecutive turns you try to get the total of the previous turn. if you get you win. If total is 7 you lose.
    
    public int turnNumber = 0;
    public boolean isGameOver = false;

    public boolean winConditions(Player char1, Player char2){
        if(turnNumber == 1){
            if(char1.dices[6][6] == 1 || char1.dices[5][5] == 1 || char1.dices[3][3] == 1 || char1.dice1 + char1.dice2 == 7){
                System.out.println(char1.name + " Wins!!");
                isGameOver = true;
            }
            else if(char1.dices[4][4] == 1 || char1.dices[2][2] == 1 || char1.dices[1][1] == 1){
                System.out.println(char1.name + " Lose!");
                isGameOver = true;
            }
            else if(char2.dices[6][6] == 1 || char2.dices[5][5] == 1 || char2.dices[3][3] == 1 || char2.dice1 + char2.dice2 == 7){
                System.out.println(char2.name + " Wins!!");
                isGameOver = true;
            }
            else if(char2.dices[4][4] == 1 || char2.dices[2][2] == 1 || char2.dices[1][1] == 1){
                System.out.println(char2.name + " Lose!");
                isGameOver = true;
            }
            if(isGameOver == true) return false;
            return true;
        }
        else{
            if(char1.lastThrownTotal == char1.dice1 + char1.dice2){
                System.out.println(char1.name + " Wins!!");
                isGameOver = true;
            }
            else if(char1.dice1 + char1.dice2 == 7){
                System.out.println(char1.name + " Lose!");
                isGameOver = true;
            }
            else if(char2.lastThrownTotal == char2.dice1 + char2.dice2){
                System.out.println(char2.name + " Wins!!");
                isGameOver = true;
            }
            else if(char2.dice1 + char2.dice2 == 7){
                System.out.println(char2.name + " Lose!");
                isGameOver = true;
            }
            if(isGameOver == true) return false;
            return true;
        }
    }

    public static void main(String[] args){
        Player player1 = new Player("Ahmet");
        Player player2 = new Player("Eren");
        CrabGame crabGame = new CrabGame();

        while(crabGame.winConditions(player1, player2)){
            crabGame.turnNumber++;
            player1.lastThrownTotal = player1.dice1 + player1.dice2;
            player2.lastThrownTotal = player2.dice1 + player2.dice2;

            player1.Roll();
            System.out.println(player1.name + " rolled: " + player1.dice1 + " + " + player1.dice2);

            player2.Roll();
            System.out.println(player2.name + " rolled: " + player2.dice1 + " + " + player2.dice2);
            System.out.println(crabGame.turnNumber);
        }
    }
}
