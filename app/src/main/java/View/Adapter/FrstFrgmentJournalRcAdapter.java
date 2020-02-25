package View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;

import java.util.List;

import Model.Pojo.FrstFrgmentJournalPojo;

public class FrstFrgmentJournalRcAdapter extends RecyclerView.Adapter {

    private List<FrstFrgmentJournalPojo> journalRcPojoList;
    private Context mContext;

    public FrstFrgmentJournalRcAdapter(List<FrstFrgmentJournalPojo> journalRcPojoList, Context context) {
        this.journalRcPojoList = journalRcPojoList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frst_frgment_second_rc_item_layout,parent,false);

        return new JournalRcViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        FrstFrgmentJournalPojo model = journalRcPojoList.get(position);

        ((JournalRcViewholder) holder).timeTv.setText(model.getTimeText());

    }

    @Override
    public int getItemCount() {
        return journalRcPojoList.size();
    }

    public class JournalRcViewholder extends RecyclerView.ViewHolder {

        AppCompatTextView timeTv;
        AppCompatImageButton editImageBtn;

        RecyclerView journalRecyclerView;

        public JournalRcViewholder(@NonNull View itemView) {
            super(itemView);

            timeTv = itemView.findViewById(R.id.time_textView);
            editImageBtn = itemView.findViewById(R.id.edit_imageButton);

            journalRecyclerView = itemView.findViewById(R.id.frst_frgment_second_rc_one);


        }
    }
}
