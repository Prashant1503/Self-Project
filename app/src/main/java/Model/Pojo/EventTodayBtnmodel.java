package Model.Pojo;

public class EventTodayBtnmodel {

    private String eventTitle;
    private int year;
    private int day;
    private int month;
    private int hour;
    private int minute;
    private String time;

    public EventTodayBtnmodel() {

    }


    public EventTodayBtnmodel(String eventTitle, int year, int day, int month, int hour, int minute,String time) {
        this.eventTitle = eventTitle;
        this.year = year;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.minute = minute;
        this.time = time;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
