package View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;

import java.util.List;

import Model.Pojo.FrstFrgmentJournalPojo;

public class HomeFrgmentEventRcAdapter extends RecyclerView.Adapter {

    private List<FrstFrgmentJournalPojo> eventList;
    private Context mContext;


    public HomeFrgmentEventRcAdapter(List<FrstFrgmentJournalPojo> eventList, Context context) {
        this.eventList = eventList;
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

        FrstFrgmentJournalPojo model = eventList.get(position);

        ((JournalRcViewholder) holder).eventRadioBtn.setText(model.getTaskTitle());


    }

    @Override
    public int getItemCount() {

        return eventList.size();
    }

    public class JournalRcViewholder extends RecyclerView.ViewHolder {

        MaterialRadioButton eventRadioBtn;


        public JournalRcViewholder(@NonNull View itemView) {
            super(itemView);

            eventRadioBtn = itemView.findViewById(R.id.event_radioBtn);


        }
    }
}
