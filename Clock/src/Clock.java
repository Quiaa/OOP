abstract class Clock{
    private int hour;
    private int minute;

    abstract String TellMeTime();

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public Clock(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }
}
