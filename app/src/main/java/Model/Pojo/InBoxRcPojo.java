package Model.Pojo;

public class InBoxRcPojo {

    private String inboxTitle;
    private int dayIcon;
    private String day;
    private String month;
    private String time;


    public InBoxRcPojo() {

    }

    public InBoxRcPojo(String inboxTitle, int dayIcon, String day, String month,String time) {
        this.inboxTitle = inboxTitle;
        this.dayIcon = dayIcon;
        this.day = day;
        this.month = month;
        this.time = time;
    }

    public String getInboxTitle() {
        return inboxTitle;
    }

    public void setInboxTitle(String inboxTitle) {
        this.inboxTitle = inboxTitle;
    }

    public int getDayIcon() {
        return dayIcon;
    }

    public void setDayIcon(int dayIcon) {
        this.dayIcon = dayIcon;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
