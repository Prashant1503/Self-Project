package Model.Pojo;

public class MainRcPojo {

    public static final int AGENDA_LAYOUT = 1;
    public static final int JOURNAL_LAYOUT = 2;

    //    main model ..
    private int ViewType;

//    model for frst frgment frst Layout..

    public String goalCounterText;


    public MainRcPojo(int viewType, String goalCounterText) {
        this.ViewType = viewType;
        this.goalCounterText = goalCounterText;
    }

    public MainRcPojo(int viewType) {
        this.ViewType = viewType;
    }

    public String getGoalCounterText() {
        return goalCounterText;
    }

    public void setGoalCounterText(int viewType, String goalCounterText) {
        this.goalCounterText = goalCounterText;
        this.ViewType = viewType;
    }

    public int getViewType() {
        return ViewType;
    }

    public MainRcPojo(String goalCounterText) {
        this.goalCounterText = goalCounterText;
    }



    //    end

//    model for frst frgment second layout..


}
