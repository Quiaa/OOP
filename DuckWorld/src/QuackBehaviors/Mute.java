package QuackBehaviors;

public class Mute implements QuackBehavior{
    @Override
    public void Quack() {
        System.out.println("This duck can not speak");
    }  
}
