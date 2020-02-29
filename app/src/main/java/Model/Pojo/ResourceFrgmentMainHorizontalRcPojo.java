package Model.Pojo;

public class ResourceFrgmentMainHorizontalRcPojo {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;

    private int goal_image;
    private int viewType;

    public ResourceFrgmentMainHorizontalRcPojo(int image,int ViewType) {
        this.goal_image = image;
        this.viewType = ViewType;

    }

    public static int getTypeOne() {
        return TYPE_ONE;
    }

    public static int getTypeTwo() {
        return TYPE_TWO;
    }

    public int getGoal_image() {
        return goal_image;
    }

    public void setGoal_image(int goal_image) {
        this.goal_image = goal_image;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
