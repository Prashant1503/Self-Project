package Model.Pojo;

public class AddSomethingMainRcPojo {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO =2;

    private int ViewType;


    public AddSomethingMainRcPojo(int viewType) {
        ViewType = viewType;
    }



    public static int getTypeOne() {
        return TYPE_ONE;
    }

    public static int getTypeTwo() {
        return TYPE_TWO;
    }

    public int getViewType() {
        return ViewType;
    }

    public void setViewType(int viewType) {
        ViewType = viewType;
    }
}
