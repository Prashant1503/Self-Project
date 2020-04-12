package Model.Pojo;

public class SubtaskRcPojo {

    private String subtaskRadioBtnTitle;
    private String subtaskTitle;
    private String day;
    private String date;
    private String minute;
    private String hours;

    public SubtaskRcPojo() {

    }
    public SubtaskRcPojo( String subtaskRadioBtnTitle,String subtaskTitle, String day, String date, String minute, String hours) {
        this.subtaskTitle = subtaskTitle;
        this.day = day;
        this.date = date;
        this.minute = minute;
        this.hours = hours;
        this.subtaskRadioBtnTitle = subtaskRadioBtnTitle;
    }

    public String getSubtaskTitle() {
        return subtaskTitle;
    }

    public void setSubtaskTitle(String subtaskTitle) {
        this.subtaskTitle = subtaskTitle;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getSubtaskRadioBtnTitle() {
        return subtaskRadioBtnTitle;
    }

    public void setSubtaskRadioBtnTitle(String subtaskRadioBtnTitle) {
        this.subtaskRadioBtnTitle = subtaskRadioBtnTitle;
    }
}
