public class DuelGame{
    public boolean isOver(Player player1, Player player2){
        if(player1.isAlive == false && player2.isAlive == false){
            System.out.println("------------------------------");
            System.out.println("\nTie.");
            return false;
        }
        else if(player1.isAlive == true && player2.isAlive == false){
            System.out.println("------------------------------");
            System.out.println("\n"+player2.name + " is dead.");
            System.out.println(player1.name + " won the duel.");
            return false;
        }
        else if(player1.isAlive == false && player2.isAlive == true){
            System.out.println("------------------------------");
            System.out.println("\n"+ player1.name + " is dead.");
            System.out.println(player2.name + " won the duel.");
            return false;
        }
        return true;
    }
    public void control(Player player1, Player player2){ 
        if(player1.flag == true){
            player1.shoot(player2);
            player1.flag = false;
        }
        if(player2.flag == true){
            player2.shoot(player1);
            player2.flag = false;
        }
        player1.isDefending = false;
        player2.isDefending = false;
    }
}
