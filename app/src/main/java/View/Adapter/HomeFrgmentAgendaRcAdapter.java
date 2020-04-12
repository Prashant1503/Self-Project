package View.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;

import java.util.List;

import Model.Pojo.FrstFrgmentAgendaPojo;

public class HomeFrgmentAgendaRcAdapter extends RecyclerView.Adapter<HomeFrgmentAgendaRcAdapter.FrstFrgmentAgendaRcViewHolder> {

    public List<FrstFrgmentAgendaPojo> mFrstFrgmentAgendaPojosList;
    public Context mContext;

    public RecyclerView agendaRc;



    public HomeFrgmentAgendaRcAdapter(List<FrstFrgmentAgendaPojo> frstFrgmentAgendaPojosList, Context context) {
        this.mFrstFrgmentAgendaPojosList = frstFrgmentAgendaPojosList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public FrstFrgmentAgendaRcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.frst_frgment_frst_rc_item_layout,parent,false);

        agendaRc = view.findViewById(R.id.frst_frgment_agendaLayoutRecyclerView);


        return new FrstFrgmentAgendaRcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FrstFrgmentAgendaRcViewHolder holder, final int position) {

        final FrstFrgmentAgendaPojo model = mFrstFrgmentAgendaPojosList.get(position);

        holder.subtitleTextTv.setText(model.getSubtitleText());
        holder.radioBtn.setText(model.getRadioBtnText());

        holder.radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeTodo(position);

                Toast.makeText(mContext,"Todo is removed",Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return mFrstFrgmentAgendaPojosList.size();
    }


    public class FrstFrgmentAgendaRcViewHolder extends RecyclerView.ViewHolder {
            RadioButton radioBtn;
            RadioGroup mRadioGroup;
            AppCompatTextView subtitleTextTv;



        public FrstFrgmentAgendaRcViewHolder(@NonNull final View itemView) {
            super(itemView);

            radioBtn = itemView.findViewById(R.id.frst_frgment_rc_radioButton);
            mRadioGroup = itemView.findViewById(R.id.frst_frgment_rc_radioGroup);

            subtitleTextTv = itemView.findViewById(R.id.frst_frgment_rc_subtitleTextView);


        }
    }

    private void removeTodo(int position) {
        mFrstFrgmentAgendaPojosList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeRemoved(position,mFrstFrgmentAgendaPojosList.size());

    }
}
