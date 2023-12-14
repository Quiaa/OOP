public class DriverClass{
    public String TellMeTime(Clock clock){
        return clock.TellMeTime();
    }
    public static void main(String[] args){
        Clock wrWatch = new WristWatch(15,9);
        Clock cC = new CuckcooClock(15, 0);
        Clock cC2 = new CuckcooClock(6, 30);
        Clock sun = new Sundial(21, 0);
        Clock sun2 = new Sundial(12, 30);
        DriverClass dc = new DriverClass();


        System.out.println(dc.TellMeTime(wrWatch));
        System.out.println(dc.TellMeTime(cC));
        System.out.println(dc.TellMeTime(cC2));
        System.out.println(dc.TellMeTime(sun));
        System.out.println(dc.TellMeTime(sun2));

        wrWatch.setHour(14);
        System.out.println(dc.TellMeTime(wrWatch));
    }
}


