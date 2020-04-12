package View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;

import java.util.List;

import Model.Pojo.ResourceFrgmentMainRcPojo;

public class ResourceFrgmentMainRcScndAdapter extends RecyclerView.Adapter<ResourceFrgmentMainRcScndAdapter.ScndRcViewHolder> {

    private List<ResourceFrgmentMainRcPojo> scndList;
    private Context mContext;

    public ResourceFrgmentMainRcScndAdapter(List<ResourceFrgmentMainRcPojo> scndList, Context context) {
        this.scndList = scndList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ScndRcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frst_frgment_main_rc_second_item_layout,parent,false);

        return new ScndRcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScndRcViewHolder holder, int position) {

        ResourceFrgmentMainRcPojo model = scndList.get(position);

        holder.primaryTextView.setText(model.getGoalPrimaryText());
        holder.SecondaryTextView.setText(model.getGoalSecondaryText());
        holder.scndImageView.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return scndList.size();
    }


    public class ScndRcViewHolder extends RecyclerView.ViewHolder {

        CardView scndCardView;
        AppCompatImageView scndImageView;
        AppCompatTextView primaryTextView,SecondaryTextView;


        public ScndRcViewHolder(@NonNull View itemView) {
            super(itemView);

            scndCardView = itemView.findViewById(R.id.second_cardView);

            scndImageView = itemView.findViewById(R.id.scnd_layout_ImageView);
            primaryTextView = itemView.findViewById(R.id.frst_layout_primaryTextView);
            SecondaryTextView = itemView.findViewById(R.id.frst_layout_SecondaryTextView);

        }
    }
}
