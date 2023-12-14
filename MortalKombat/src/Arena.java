public class Arena{
    public int FINISH_SCORE = 2;
    public boolean winner(Character character1, Character character2, int maxHP){
        if(character1.healthPoint == 0 || character2.healthPoint == 0){
            if(character1.healthPoint == 0){
                System.out.println(character1.name + "is dead. \n");
                character2.winCount++;
            }
            else if(character2.healthPoint == 0){
                System.out.println(character2.name + "is dead. \n");
                character1.winCount++;
            } 
            System.out.println("----------------------------------------");
            System.out.println("|SCORES| " + character1.name + ": " + character1.winCount + " || " + character2.name + ": " + character2.winCount + "|");
            System.out.println("---------------------------------------- \n");

            if(character1.winCount == FINISH_SCORE){
                System.out.println(character1.name +" Wins!!");
                return false;
            }
            else if(character2.winCount == FINISH_SCORE){
                System.out.println(character2.name +" Wins!!");
                return false;
            }
            character1.healthPoint = maxHP;
            character2.healthPoint = maxHP;
        } 
        return true;
    }
    public static void main(String[] args){
        int hP = 2;
        Arena arena = new Arena();
        Character player1 = new Character("'Skorpion'", hP);
        Character player2 = new Character("'Sup Zero'", hP);

        while(arena.winner(player1, player2, hP)){
            double rand1 = Math.random();
            double rand2 = Math.random();

            System.out.println(player1.name + ": " + player1.healthPoint + "HP  " + player2.name + ": " + player2.healthPoint + "HP \n");
            if(rand1 > 0.3) player1.Attack(player2);
            else player1.Defend();

            if(player2.healthPoint != 0){
                if(rand2 > 0.3) player2.Attack(player1);
                else player2.Defend();
            }
        }
    }
}
