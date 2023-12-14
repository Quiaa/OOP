import Weapons.Pistol;

public class App {
    public static void main(String[] args){
        Player pl1 = new Player("Recaizade",50);
        Player pl2 = new Player("Mahmut",50);

        pl1.Info();
        pl2.Info();

        pl1.Attack(pl2);
        pl2.Info();

        pl1.changeWeapon(new Pistol());
        pl1.Info();
        pl1.Attack(pl2);
        pl2.Info();

        pl2.Attack(pl1);
        pl1.Info();

        pl1.Attack(pl2);
        pl1.Attack(pl2);
        pl1.Attack(pl2);
        pl2.Info();
        pl1.Attack(pl2);
        pl2.Info();
    }
}
