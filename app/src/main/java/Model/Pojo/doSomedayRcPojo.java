package Model.Pojo;

public class doSomedayRcPojo {

    private int taskImage;
    private String taskTitle;
    private String taskSubtitle;

    public doSomedayRcPojo(int taskImage, String taskTitle, String taskSubtitle) {
        this.taskImage = taskImage;
        this.taskTitle = taskTitle;
        this.taskSubtitle = taskSubtitle;
    }

    public int getTaskImage() {
        return taskImage;
    }

    public void setTaskImage(int taskImage) {
        this.taskImage = taskImage;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskSubtitle() {
        return taskSubtitle;
    }

    public void setTaskSubtitle(String taskSubtitle) {
        this.taskSubtitle = taskSubtitle;
    }


}
