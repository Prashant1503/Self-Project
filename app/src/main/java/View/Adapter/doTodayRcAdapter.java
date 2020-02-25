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

import Model.Pojo.doMainRcPojo;

public class doTodayRcAdapter extends RecyclerView.Adapter {

    private List<doMainRcPojo> doTodayRcList;
    private Context mContext;

    public doTodayRcAdapter(List<doMainRcPojo> doTodayRcList, Context context) {
        this.doTodayRcList = doTodayRcList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.do_today_rc_item_layout,parent,false);

        return new doTodayRcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        doMainRcPojo model = doTodayRcList.get(position);

        ((doTodayRcViewHolder) holder).doTodayImageView.setImageResource(model.getTaskImage());
        ((doTodayRcViewHolder) holder).doTodayTitleTextView.setText(model.getTaskTitle());

        ((doTodayRcViewHolder) holder).doTodaySubtitleTitleTextView.setText(model.getTaskSubtitle());

    }

    @Override
    public int getItemCount() {
        return doTodayRcList.size();
    }

    public class doTodayRcViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView doTodayImageView;
        AppCompatTextView doTodayTitleTextView,doTodaySubtitleTitleTextView;


        public doTodayRcViewHolder(@NonNull View itemView) {
            super(itemView);

            doTodayImageView = itemView.findViewById(R.id.do_today_imageView);
            doTodayTitleTextView = itemView.findViewById(R.id.do_today_title_textView);
            doTodaySubtitleTitleTextView = itemView.findViewById(R.id.do_today_subtitle_textView);

        }
    }
}
