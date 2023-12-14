public class Player{
    private int bulletCount = 0;
    public boolean isAlive = true;
    public boolean isDefending = false;
    public String name;
    public boolean flag;

    public void reload(){
        bulletCount++;
        System.out.println(name + " reloads.");
    }
    public void shoot(Player pl){
        if(flag == true){
            if(bulletCount > 4){
                System.out.println(name + " have more than 5 bullet so shoots a rocket launcher.");
                pl.isAlive = false;
                bulletCount = bulletCount - 5;
            }
            else if(bulletCount > 0){
                if(pl.isDefending == true){
                    System.out.println(name + " shoots");
                    bulletCount--;
                }
                else{
                    System.out.println(name + " shoots");
                    pl.isAlive = false;
                    bulletCount--;
                }
            }
            else{
                System.out.println(name + " tries shot(no ammo).");
            }
        }
        else flag = true;
    }
    public void shield(){
        isDefending = true;
        System.out.println(name + " is defending.");
    }

    public Player(String name){
        this.name = name;
    }
}
