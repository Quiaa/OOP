public class WristWatch extends Clock{
    private double angle;

    public double AngelBetweenArms(){
        int hour = getHour();
        int minute = getMinute();
        if(hour > 12){
            hour -= 12;
        }
        angle = hour*30 - minute*6;
        if(angle < 0) angle *= -1;
        return angle;
    }
    public String TellMeTime(){
        if(getHour() > 12){
            return String.format("%02d", getHour() - 12) + ":" + String.format("%02d", getMinute()) + " PM. Angle between arms: " + AngelBetweenArms();
        }
        else{
            return String.format("%02d", getHour()) + ":" + String.format("%02d", getMinute()) + " AM. Angle between arms: " + AngelBetweenArms();
        }
    }
    public WristWatch(int hour, int minute){
        super(hour, minute);
    }
}
