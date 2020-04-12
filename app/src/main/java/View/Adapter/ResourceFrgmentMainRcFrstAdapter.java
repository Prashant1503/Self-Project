package View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.utility.R;

import java.util.List;

import Model.Pojo.ResourceFrgmentMainRcPojo;
import View.Fragment.CollapsingToolbarGoalActivity;

public class ResourceFrgmentMainRcFrstAdapter extends RecyclerView.Adapter<ResourceFrgmentMainRcFrstAdapter.FrstAdapterViewHolder> {

    private List<ResourceFrgmentMainRcPojo> frstList;
    private Context mContext;

    AppCompatImageView frstRcImageView;

    public ResourceFrgmentMainRcFrstAdapter(List<ResourceFrgmentMainRcPojo> frstList, Context context) {
        this.frstList = frstList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ResourceFrgmentMainRcFrstAdapter.FrstAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_frgment_main_rc_frst_item_layout,parent,false);
        return new FrstAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourceFrgmentMainRcFrstAdapter.FrstAdapterViewHolder holder, int position) {

        final ResourceFrgmentMainRcPojo model = frstList.get(position);

        holder.primaryTextView.setText(model.getGoalPrimaryText());
        holder.secondaryTextView.setText(model.getGoalSecondaryText());

        Glide.with(mContext).load(model.getImage()).into(frstRcImageView);

        holder.frstCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,CollapsingToolbarGoalActivity.class);
                intent.putExtra("Title",model.getGoalPrimaryText());

                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return frstList.size();
    }

    public class FrstAdapterViewHolder extends RecyclerView.ViewHolder {

        CardView frstCardView;
        AppCompatTextView primaryTextView,secondaryTextView;

        public FrstAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            frstCardView = itemView.findViewById(R.id.frst_layout_CardView);

            frstRcImageView = itemView.findViewById(R.id.main_rc_frst_item_layout_ImageView);
            primaryTextView = itemView.findViewById(R.id.main_rc_frst_item_layout_primarYtextView);
            secondaryTextView = itemView.findViewById(R.id.main_rc_frst_item_layout_SecondarytextView);

        }
    }

}
