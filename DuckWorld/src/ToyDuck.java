import FlyBehaviors.NoFly;
import QuackBehaviors.Squeck;

public class ToyDuck extends Duck{
    public ToyDuck(){
        flyBehav = new NoFly();
        quackBehav = new Squeck();
    }
    @Override
    public void Swim(){
        System.out.println("Swims above bathwater");
    }
}
