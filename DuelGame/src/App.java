public class App{
    public static void main(String[] args){
        Player pl1 = new Player("Ahmet");
        Player pl2 = new Player("Eren");
        DuelGame duel = new DuelGame();

        while(duel.isOver(pl1, pl2)){
            double rand1 = Math.random();
            double rand2 = Math.random();

            if(rand1 > 0.5) pl1.reload();
            else if(rand1 > 0.25) pl1.shoot(pl2);
            else pl1.shield();

            if(rand2 > 0.5) pl2.reload();
            else if(rand2 > 0.25) pl2.shoot(pl1);
            else pl2.shield();
            
            duel.control(pl1, pl2);
            System.out.println("");
        }

    }
}
