package View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.utility.R;

import java.util.List;

import Model.Pojo.ResourceFrgmentMainHorizontalRcPojo;

public class ResourceFrgmenHorizontalScndViewRcAdapter extends RecyclerView.Adapter<ResourceFrgmenHorizontalScndViewRcAdapter.ResourceFrgmentHorizontalScndRcViewHolder> {

    private List<ResourceFrgmentMainHorizontalRcPojo> HorizontalScndRcLIst;
    private Context mContext;

    public ResourceFrgmenHorizontalScndViewRcAdapter(List<ResourceFrgmentMainHorizontalRcPojo> horizontalScndRcLIst, Context context) {
        this.HorizontalScndRcLIst = horizontalScndRcLIst;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ResourceFrgmentHorizontalScndRcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_frgment_frst_horizontal_rc_second_item_layout,parent,false);

        return new ResourceFrgmentHorizontalScndRcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourceFrgmentHorizontalScndRcViewHolder holder, int position) {

        ResourceFrgmentMainHorizontalRcPojo mode = HorizontalScndRcLIst.get(position);

//        holder.mAppCompatImageView.setImageResource(mode.getImages());
//
//        Glide.with(mContext).load(mode.getImages()).into(holder.mAppCompatImageView);

    }

    @Override
    public int getItemCount() {
        return HorizontalScndRcLIst.size();
    }

    public static class ResourceFrgmentHorizontalScndRcViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView mAppCompatImageView;


        public ResourceFrgmentHorizontalScndRcViewHolder(@NonNull View itemView) {
            super(itemView);

            mAppCompatImageView = itemView.findViewById(R.id.horizontal_scnd_rc_ImageView);
        }
    }
}
