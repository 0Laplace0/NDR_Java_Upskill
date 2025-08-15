public class Time {
    
    private int second = 0, minute = 0, hour = 0;

    //Constructer that initialized the time  with specofied hour, minute nad second.
    public Time(){}

    public Time(int hour, int minute, int second){
        setTime(hour, minute, second);
    }

    public int getHour(){
        return this.hour;
    }

    public int getMinute(){
        return this.minute;
    }

    public int getSecond(){
        return this.second;
    }

    //Setter methods with validation
    public void setHour(int hour){
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("Hour must be between 0 and 23.");
        }
        this.hour = hour;
    }

    public void setMinute(int minute){
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Minute must be between 0 and 60.");
        }
        this.minute = minute;
    }

    public void setSecond(int second){
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("Second must be between 0 and 60.");
        }
        this.second = second;
    }

    public void setTime(int hour, int minute, int second){
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    /*
     * Advance the Time by one second.
     * Return the current object to allow for method chaining.
     * Return the curent Time object.
     */

    public Time nextSecond(){
        this.second++;
        if (this.second == 60) {
            this.second = 0;
            this.minute++;
            if (this.minute == 60) {
                this.minute = 0;
                this.hour++;
                if (hour == 24) {
                    this.hour = 0;
                    this.minute = 0;
                    this.second = 0;
                }
            }
        }
        return this;
    }
}
