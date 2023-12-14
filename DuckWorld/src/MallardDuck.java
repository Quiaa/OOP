import FlyBehaviors.FlyWithWings;
import QuackBehaviors.Quackk;

public class MallardDuck extends Duck{
    public MallardDuck(){
        flyBehav = new FlyWithWings();
        quackBehav = new Quackk();
    }
}
