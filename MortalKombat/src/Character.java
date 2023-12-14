public class Character{
    public int healthPoint;
    public int winCount = 0;
    public String name;
    public double pAttack = 0.7;
    public double pDefend = 0.5;
    public boolean isDefending;

    public void Attack(Character player){
        if(isDefending == true) isDefending = false; // it sets default the defend stance
        System.out.println(name + " trying to attack!");
        double rand = Math.random();
        if(rand < pAttack){
            if(player.isDefending == true){
                System.out.println(player.name + " blocked the attack.\n");
                player.isDefending = false;
                return;
            }
            System.out.println(name + " hit the " + player.name + "\n");
            player.healthPoint--;
        }
        else System.out.println(name + " attack missed the " + player.name + "\n");
    }

    public void Defend(){
        if(isDefending == true) isDefending = false; // it sets default the defend stance
        System.out.println(name + " tries block stance");
        double rand = Math.random();
        if(rand < pDefend){
            isDefending = true;
            System.out.println("(Success)\n");
        }
        else System.out.println("(Fails)\n");
    }

    public Character(String name, int hP){
        this.name = name;
        healthPoint = hP;
    }
}
