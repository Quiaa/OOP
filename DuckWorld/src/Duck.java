import FlyBehaviors.FlyBehavior;
import QuackBehaviors.QuackBehavior;

abstract class Duck{
    public FlyBehavior flyBehav;
    public QuackBehavior quackBehav;

    public void Quack(){
        quackBehav.Quack();
    }
    public void Fly(){
        flyBehav.Fly();
    }
    public void Swim(){
        System.out.println("Swims");
    }
}
