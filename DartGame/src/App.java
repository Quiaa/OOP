public class App{
    public static void main(String[] args){
        int gameOScore = 301;
        Player pl1 = new Player("Ahmet", gameOScore);
        Player pl2 = new Player("Eren", gameOScore);
        DartGame dartGame = new DartGame();

        while(dartGame.controlGame(pl1, pl2, gameOScore)){
            System.out.println(pl1.name + "'s Turn || Score = " + pl1.score);
            System.out.println("----------------------------");
            pl1.throwDart();
            if(pl1.score != gameOScore){
                pl1.throwDart();
            }
            if(pl1.score != gameOScore){
                pl1.throwDart();
            }
            System.out.println("");

            System.out.println(pl2.name + "'s Turn || Score = "+ pl2.score);
            System.out.println("----------------------------");
            pl2.throwDart();
            if(pl2.score != gameOScore){
                pl2.throwDart();
            }
            if(pl2.score != gameOScore){
                pl2.throwDart();
            }
            System.out.println("");
        }
    }
}