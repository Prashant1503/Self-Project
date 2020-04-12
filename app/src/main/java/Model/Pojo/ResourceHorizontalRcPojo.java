package Model.Pojo;

public class ResourceHorizontalRcPojo {

    private String goal_text;
    private int goal_image;

    public ResourceHorizontalRcPojo(String goal_text, int goal_image) {
        this.goal_text = goal_text;
        this.goal_image = goal_image;
    }

    public ResourceHorizontalRcPojo(int goal_image) {
        this.goal_image = goal_image;
    }

    public ResourceHorizontalRcPojo(String goal_text) {
        this.goal_text = goal_text;
    }

    public String getGoal_text() {
        return goal_text;
    }

    public int getGoal_image() {
        return goal_image;
    }

    public void setGoal_text(String goal_text) {
        this.goal_text = goal_text;
    }

    public void setGoal_image(int goal_image) {
        this.goal_image = goal_image;
    }
}
