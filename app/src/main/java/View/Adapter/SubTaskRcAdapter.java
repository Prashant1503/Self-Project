package View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;
import com.google.android.material.radiobutton.MaterialRadioButton;

import java.util.List;

import Model.Pojo.SubtaskRcPojo;

public class SubTaskRcAdapter extends RecyclerView.Adapter<SubTaskRcAdapter.SubTaskRcViewHolder> {

    private List<SubtaskRcPojo> subtaskRcPojoList;
    private Context mContext;

    public SubTaskRcAdapter(List<SubtaskRcPojo> subtaskRcPojoList, Context mContext) {
        this.subtaskRcPojoList = subtaskRcPojoList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SubTaskRcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subtask_rc_item_layout,parent,false);

        return new SubTaskRcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubTaskRcViewHolder holder, int position) {

        SubtaskRcPojo model = subtaskRcPojoList.get(position);

        holder.subtaskRadioBtn.setText(model.getSubtaskRadioBtnTitle());

    }

    @Override
    public int getItemCount() {
        return subtaskRcPojoList.size();
    }

    public class SubTaskRcViewHolder extends RecyclerView.ViewHolder {

        MaterialRadioButton subtaskRadioBtn;

        public SubTaskRcViewHolder(@NonNull View itemView) {
            super(itemView);

            subtaskRadioBtn = itemView.findViewById(R.id.subtask_rc_radio_btn);
        }
    }
}
