package FlyBehaviors;

public class NoFly implements FlyBehavior{
    @Override
    public void Fly() {
        System.out.println("This duck can not fly");
    }
}
