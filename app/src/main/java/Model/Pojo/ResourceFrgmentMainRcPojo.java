package Model.Pojo;

public class ResourceFrgmentMainRcPojo {

    public static final int GOAL_HORIZONTAL_RC_LAYOUT = 1;
    public static final int GRID_VERTICAL_RC_LAYOUT = 2;

    public int image;
    public String goalPrimaryText;
    public String goalSecondaryText;
    public String goalDescription;

    public int ViewType;

    public ResourceFrgmentMainRcPojo(int viewType,int image,String primaryText,String secondaryText) {
        this.ViewType = viewType;
        this.image = image;
        this.goalPrimaryText = primaryText;
        this.goalSecondaryText = secondaryText;
    }

    public ResourceFrgmentMainRcPojo(int viewType,int image,String primaryText,String secondaryText,String goalDescription) {
        this.ViewType = viewType;
        this.image = image;
        this.goalPrimaryText = primaryText;
        this.goalSecondaryText = secondaryText;
        this.goalDescription = goalDescription;

    }

    public ResourceFrgmentMainRcPojo(int viewType) {
        this.ViewType = viewType;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getViewType() {
        return ViewType;
    }

    public int getImage() {
        return image;
    }

    public String getGoalPrimaryText() {
        return goalPrimaryText;
    }

    public String getGoalSecondaryText() {
        return goalSecondaryText;
    }
}
