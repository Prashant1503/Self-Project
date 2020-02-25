package View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;

import java.util.ArrayList;
import java.util.List;

import Model.Pojo.AddSomethingMainRcPojo;
import Model.Pojo.doMainRcPojo;

import static Model.Pojo.AddSomethingMainRcPojo.TYPE_ONE;
import static Model.Pojo.AddSomethingMainRcPojo.TYPE_TWO;

public class AddSomethingMainRcAdapter extends RecyclerView.Adapter{

    public List<AddSomethingMainRcPojo> mAddSomethingMainRcPojoList;
    public Context mContext;

    public List<doMainRcPojo> doTodayList;
    public doTodayRcAdapter doTodayRcAdapter;
    public RecyclerView doTodayRecyclerView;

    public List<doMainRcPojo> doSomedayList;
    public doSomedayRcAdapter mDoSomedayRcAdapter;
    public RecyclerView doSomedayRecyclerView;



    public AddSomethingMainRcAdapter(List<AddSomethingMainRcPojo> addSomethingMainRcPojoList, Context context) {
        this.mAddSomethingMainRcPojoList = addSomethingMainRcPojoList;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {

        switch (mAddSomethingMainRcPojoList.get(position).getViewType()) {

            case 1:
                return TYPE_ONE;

            case 2:
                return TYPE_TWO;

                default:
                    return -1;

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {

            case TYPE_ONE:
                View viewOne = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_something_first_recycler_view_layout,parent,false);



                return new FrstRcViewholder(viewOne);

            case TYPE_TWO:
                View viewTwo = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_something_second_recycler_view_layout,parent,false);

                return new FrstRcViewholder(viewTwo);

                default:
                    return null;

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (mAddSomethingMainRcPojoList.get(position).getViewType()) {
            case TYPE_ONE:

                break;

            case TYPE_TWO:


                break;

                default:
                    return;


        }

    }

    @Override
    public int getItemCount() {
        return mAddSomethingMainRcPojoList.size();
    }


    //    1st recycler view holder...
    public  class FrstRcViewholder extends RecyclerView.ViewHolder {

        AppCompatTextView doTodayTitleTv;
        AppCompatEditText addSomethingEdt;



        public FrstRcViewholder(@NonNull View itemView) {
            super(itemView);

            doTodayTitleTv = itemView.findViewById(R.id.do_today_textView);
            addSomethingEdt = itemView.findViewById(R.id.add_today_edt_text);

            doTodayRecyclerView = itemView.findViewById(R.id.do_today_recycler_view);
            doTodayRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

            doTodayList = new ArrayList<>();
            doTodayList.add(new doMainRcPojo(R.drawable.add_something_icon,"title","subtitle"));
            doTodayList.add(new doMainRcPojo(R.drawable.add_something_icon,"title","subtitle"));
            doTodayList.add(new doMainRcPojo(R.drawable.add_something_icon,"title","subtitle"));
            doTodayList.add(new doMainRcPojo(R.drawable.add_something_icon,"title","subtitle"));

            doTodayRcAdapter = new doTodayRcAdapter(doTodayList,mContext);
            doTodayRecyclerView.setAdapter(doTodayRcAdapter);

        }
    }

//    2nd recycler view holder...

    public  class SecondRcViewholder extends RecyclerView.ViewHolder {

        AppCompatTextView doSomethingTextTv;



        public SecondRcViewholder(@NonNull View itemView) {
            super(itemView);

            doSomethingTextTv = itemView.findViewById(R.id.do_someday_textView);

            doSomedayRecyclerView = itemView.findViewById(R.id.do_someday_recyclerView);
            doSomedayRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

            doSomedayList = new ArrayList<>();
            doSomedayList.add(new doMainRcPojo(R.drawable.camera_icon,"Title is here","Subtitle 1is here"));
            doSomedayList.add(new doMainRcPojo(R.drawable.camera_icon,"Title is here","Subtitle 1is here"));
            doSomedayList.add(new doMainRcPojo(R.drawable.camera_icon,"Title is here","Subtitle 1is here"));
            doSomedayList.add(new doMainRcPojo(R.drawable.camera_icon,"Title is here","Subtitle 1is here"));
            doSomedayList.add(new doMainRcPojo(R.drawable.camera_icon,"Title is here","Subtitle 1is here"));

            mDoSomedayRcAdapter = new doSomedayRcAdapter(doSomedayList,mContext);
            doSomedayRecyclerView.setAdapter(mDoSomedayRcAdapter);


        }
    }
}
