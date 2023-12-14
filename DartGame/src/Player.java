public class Player{
    public String name;
    public int score = 0;
    private int ENDSCORE = 301; // default endscore || if this variable not edited in constructor, it uses default value
    private int temp;

    public void throwDart(){
        double randFThrow = Math.random();
        if(randFThrow > 0.8) System.out.println(name + " missed");          // MISS CHANCE
        else if(randFThrow > 0.75){                                         // BULLSEYE CHANCE
            if(randFThrow > 0.77){ // Outer bullseye
                temp = 25; 
                System.out.println("Hit the outer bullseye (25)");
            }
            else{ // inner bullseye
                temp = 50;
                System.out.println("Hit the inner bullseye (50)");
            }  
        }
        else{                                                               // HIT BOARD CHANCE
            int rand = (int)(Math.random()*20 + 1);
            double randFPoint = Math.random();
            if(randFPoint > 0.3) temp = rand; 
            else if(randFPoint > 0.1) temp = rand*2; // outer ring
            else temp = rand *3; // inner ring
            System.out.println("Hit the " + rand +"x"+temp/rand+". ("+ temp+")");
        }
        score = score + temp;
        if(score > ENDSCORE){                                               // SCORE CONTROLLER
            score = score - temp;
            System.out.println("Out of score last shot does not count.");
        }
        temp = 0;
        System.out.println(name + " total point: " + score);
    }

    public Player(String name, int gameOverScore){
        this.ENDSCORE = gameOverScore;
        this.name = name;
    }
    public Player(String name){
        this.name = name;
    }
}
