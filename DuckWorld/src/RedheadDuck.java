import FlyBehaviors.FlyWithWings;
import QuackBehaviors.Quackk;

public class RedheadDuck extends Duck{
    public RedheadDuck(){
        flyBehav = new FlyWithWings();
        quackBehav = new Quackk();
    }
}
