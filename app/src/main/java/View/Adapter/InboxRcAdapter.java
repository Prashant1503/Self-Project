package View.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Pojo.InBoxRcPojo;

public class InboxRcAdapter extends RecyclerView.Adapter<InboxRcAdapter.InboxRcViewHolder> {

    private List<InBoxRcPojo> inboxRcList;
    private Context context;
    boolean isClicked = true;
    Map<String,String> eventStatusMap;

    FirebaseDatabase mDb;
    DatabaseReference mDbRef;


    AppCompatActivity appCompatActivity;

    public InboxRcAdapter(List<InBoxRcPojo> inboxRcList, Context context) {
        this.inboxRcList = inboxRcList;
        this.context = context;


        }

    @NonNull
    @Override
    public InboxRcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inbox_rc_item_layout,parent,false);

        mDb = FirebaseDatabase.getInstance();
        mDbRef = mDb.getReference();

        eventStatusMap = new HashMap<>();


        return new InboxRcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InboxRcViewHolder holder, final int position) {

        final InBoxRcPojo eventModel = inboxRcList.get(position);

        holder.inboxRadioBtn.setText(eventModel.getInboxTitle());
        holder.dayTv.setText(eventModel.getTime());
        holder.dayImageView.setImageResource(R.drawable.calendar_action_bar_icon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//
//                BottomSheetDialog subTaskDialog = new BottomSheetDialog(context);
//                subTaskDialog.setContentView(R.layout.inbox_subtask_bottom_dialog_layout);
//
////                subtask bottom dialog view.
//
//                MaterialRadioButton subtaskInboxRadioBtn = subTaskDialog.findViewById(R.id.inbox_radio_btn);
//                AppCompatTextView subtaskTv = subTaskDialog.findViewById(R.id.subtitle_date_tv);
//                AppCompatEditText subtaskEdt = subTaskDialog.findViewById(R.id.add_subtask_edt);
//
////                getting title
//                subTaskDialog.show();

            }
        });


        holder.inboxRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    removeEvent(position);

                    eventStatusMap.put("Position", String.valueOf(position));
                    eventStatusMap.put("Status", String.valueOf(isClicked));

                    String key = mDbRef.push().getKey();

                    mDbRef.child("Event Status").child(key).setValue(eventStatusMap);
                    mDbRef.push();

                    Toast.makeText(context,"Event is completed,you can check in insights",Toast.LENGTH_SHORT).show();

            }
        });
    }



    @Override
    public int getItemCount() {
        return inboxRcList.size();
    }

    public class InboxRcViewHolder extends RecyclerView.ViewHolder {

        MaterialRadioButton inboxRadioBtn;
        AppCompatTextView radioBtnTitleTv,dayTv;
        AppCompatImageView dayImageView;

        public InboxRcViewHolder(@NonNull View itemView) {
            super(itemView);

            inboxRadioBtn = itemView.findViewById(R.id.inbox_rc_radioBtn);
            radioBtnTitleTv = itemView.findViewById(R.id.inbox_rc_titleTextView);
            dayTv = itemView.findViewById(R.id.inbox_rc_dayTextView);
            dayImageView = itemView.findViewById(R.id.inbox_rc_imageView);

        }

    }
    public void removeEvent(int position) {
        inboxRcList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeRemoved(position,inboxRcList.size());
    }
}
