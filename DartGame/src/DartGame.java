public class DartGame{
    public boolean controlGame(Player pl1, Player pl2, int GAMEOVERSCORE){
        if(pl1.score == GAMEOVERSCORE && pl1.score == pl2.score){
            System.out.println("Tie");
            return false;
        }
        else if(pl1.score == GAMEOVERSCORE){
            System.out.println(pl1.name + " wins.");
            return false;
        }
        else if(pl2.score == GAMEOVERSCORE){
            System.out.println(pl2.name + " wins.");
            return false;
        }
        return true;
    }  
}
