package View.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;

import java.util.List;

import Model.Pojo.ResourceHorizontalRcPojo;

public class resource_frgment_horizontal_rc_adapter extends RecyclerView.Adapter{

    private List<ResourceHorizontalRcPojo> horizontalRcList;
    private Context mContext;

    private String TAG = "Recycler view responses";

    public resource_frgment_horizontal_rc_adapter(List<ResourceHorizontalRcPojo> horizontalRcList, Context context) {
        this.horizontalRcList = horizontalRcList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_fragment_recycler_view_horizontal_layout,parent,false);

        return new HorizontalRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ResourceHorizontalRcPojo model = horizontalRcList.get(position);

        ((HorizontalRecyclerViewHolder) holder).categoryTitleTv.setText(model.getGoal_text());

        int pos = holder.getAdapterPosition();






    }

    @Override
    public int getItemCount() {
        return horizontalRcList.size();
    }


    public  class HorizontalRecyclerViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView categoryTitleTv;


        public HorizontalRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTitleTv = itemView.findViewById(R.id.resource_frgment_Category_item_textView);

        }
    }
}
