public class App {
    public static void main(String[] args){
        Duck rhd = new RedheadDuck();
        rhd.Quack();
        rhd.Fly();
        rhd.Swim();

        Duck md = new MallardDuck();

        md.Quack();
        md.Fly();
        md.Swim();

        Duck td = new ToyDuck();
        td.Quack();
        td.Fly();
        td.Swim();
    }
}
