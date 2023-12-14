public class Sundial extends Clock{ // sabah 8 akşam 8 arası kalan zaman göremiyorum diyecek
    public String TellMeTime(){
        if(getHour() < 8 || getHour() > 20){
            return "I can't see anything";
        }
        else{
            return String.format("%02d", getHour()) + ":" + String.format("%02d", getMinute());
        }
    }
    public Sundial(int hour, int minute){
        super(hour, minute);
    }
}
