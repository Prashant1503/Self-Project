package Model.Pojo;

public class doTodayRcPojo {

    public int taskImage;
    public int dragImage;
    public String taskTitleText;

    public doTodayRcPojo(int taskImage, int dragImage, String taskTitleText) {
        this.taskImage = taskImage;
        this.dragImage = dragImage;
        this.taskTitleText = taskTitleText;
    }

    public int getTaskImage() {
        return taskImage;
    }

    public void setTaskImage(int taskImage) {
        this.taskImage = taskImage;
    }

    public int getDragImage() {
        return dragImage;
    }

    public void setDragImage(int dragImage) {
        this.dragImage = dragImage;
    }

    public String getTaskTitleText() {
        return taskTitleText;
    }

    public void setTaskTitleText(String taskTitleText) {
        this.taskTitleText = taskTitleText;
    }
}
