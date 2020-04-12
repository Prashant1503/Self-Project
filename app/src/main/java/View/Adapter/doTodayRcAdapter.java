package View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;

import java.util.List;

import Model.Pojo.doSomedayRcPojo;
import Model.Pojo.doTodayRcPojo;

public class doTodayRcAdapter extends RecyclerView.Adapter {

    private List<doTodayRcPojo> doTodayRcList;
    public Context mContext;

    public doTodayRcAdapter(List<doTodayRcPojo> doTodayRcList, Context context) {
        this.doTodayRcList = doTodayRcList;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.do_today_rc_item_layout_one,parent,false);

        return new doTodayRcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

       doTodayRcPojo model = doTodayRcList.get(position);

//        ((doTodayRcViewHolder) holder).doTodayItemImageView.setImageResource(model.getTaskImage());
        ((doTodayRcViewHolder) holder).doTodayTitleTextView.setText(model.getTaskTitleText());
//        ((doTodayRcViewHolder) holder).doTodayDragImageView.setImageResource(model.getDragImage());


    }

    @Override
    public int getItemCount() {
        return doTodayRcList.size();
    }

    public class doTodayRcViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView doTodayItemImageView;
        AppCompatTextView doTodayTitleTextView;
        AppCompatImageView doTodayDragImageView;


        public doTodayRcViewHolder(@NonNull View itemView) {
            super(itemView);

            doTodayItemImageView = itemView.findViewById(R.id.add_taskToday_ImageView);
            doTodayTitleTextView = itemView.findViewById(R.id.add_task_today_textView);
            doTodayDragImageView = itemView.findViewById(R.id.add_today_task_Drag_ImageView);



        }
    }
}
