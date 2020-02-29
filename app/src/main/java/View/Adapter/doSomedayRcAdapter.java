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

public class doSomedayRcAdapter extends RecyclerView.Adapter {

    public List<doSomedayRcPojo> doSomedayRcPojoList;
    public Context mContext;

    public doSomedayRcAdapter(List<doSomedayRcPojo> doSomedayRcPojoList, Context context) {
        this.doSomedayRcPojoList = doSomedayRcPojoList;
        this.mContext = context;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.do_today_rc_item_layout,parent,false);

        return new doSomedayRcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        doSomedayRcPojo model = doSomedayRcPojoList.get(position);

        ((doSomedayRcViewHolder) holder).doSomedayImageView.setImageResource(model.getTaskImage());
        ((doSomedayRcViewHolder) holder).doSomedayTitleTextView.setText(model.getTaskTitle());
        ((doSomedayRcViewHolder) holder).doSomedaySubtitleTextView.setText(model.getTaskSubtitle());

    }

    @Override
    public int getItemCount() {
        return doSomedayRcPojoList.size();
    }

    //    view holder classs...
    public class doSomedayRcViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView doSomedayImageView;
        AppCompatTextView doSomedayTitleTextView,doSomedaySubtitleTextView;

        public doSomedayRcViewHolder(@NonNull View itemView) {
            super(itemView);

            doSomedayImageView = itemView.findViewById(R.id.do_today_imageView);
            doSomedayTitleTextView = itemView.findViewById(R.id.do_today_title_textView);
            doSomedaySubtitleTextView = itemView.findViewById(R.id.do_today_subtitle_textView);

        }
    }
}
