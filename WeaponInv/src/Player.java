import Weapons.*;

enum State{
    Alive,
    Dead
}

public class Player{
    private int hP;
    private Weapon wp;
    private String name;
    private State state = State.Alive;

    public Player(String name, int hP){
        this.name = name;
        this.hP = hP;
        this.wp = new Sword();
    }

    public void sethP(int hP){
        this.hP = hP;
    }
    public int gethP(){
        return hP;
    }
    public String getName(){
        return name;
    }
    public State getState() {
        return state;
    }

    public void Attack(Player enemy){
        if(getState() == State.Dead){
            System.out.println("Dead man can not");
            return;
        }

        int dmg = wp.Attack();
        enemy.sethP(enemy.gethP() - dmg);
        if(enemy.gethP() <= 0) enemy.state = State.Dead;
    }

    public void changeWeapon(Weapon wp){
        if(getState() == State.Dead){
            System.out.println("Dead man can not");
            return;
        }
        this.wp = wp;
    }
    public void Info(){
        System.out.println(getName() +"|| HealtPoint: "+ hP + " || Weapon: "+ wp.getClass().getSimpleName()+ " || " + state);
    }

}
