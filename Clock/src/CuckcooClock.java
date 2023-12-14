public class CuckcooClock extends Clock{

    public String TellMeTime(){
        int hour = getHour();
        if(hour > 12) hour = hour - 12;
        if(getMinute() == 0){
            for(int i = 0; i < hour; i++) System.out.println("It's a hour GOOOOCK");
            return String.format("%02d", hour) + ":" + String.format("%02d", getMinute());
        }
        else{
            return String.format("%02d", hour) + ":" + String.format("%02d", getMinute());
        }
    }
    public CuckcooClock(int hour, int minute){
        super(hour, minute);
    }
}
