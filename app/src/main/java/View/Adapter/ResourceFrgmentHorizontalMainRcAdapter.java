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

import Model.Pojo.ResouceFrgmentHorizontalFrstRcPojo;
import Model.Pojo.ResourceFrgmentMainHorizontalRcPojo;

import static Model.Pojo.AddSomethingMainRcPojo.TYPE_ONE;
import static Model.Pojo.AddSomethingMainRcPojo.TYPE_TWO;

public class ResourceFrgmentHorizontalMainRcAdapter extends RecyclerView.Adapter{

   private List<ResourceFrgmentMainHorizontalRcPojo> mainRcList;
   private Context mContext;

    public ResourceFrgmentHorizontalMainRcAdapter(List<ResourceFrgmentMainHorizontalRcPojo> mainRcList, Context context) {
        this.mainRcList = mainRcList;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {

       switch (mainRcList.get(position).getViewType()) {
           case 1:
               return TYPE_ONE;

           case 2:
               return TYPE_TWO;

               default:
                   return -1;

       }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {

            case 1:
                View cardViewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_frgment_frst_horizontal_rc_second_item_layout,parent,false);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mainRcList.size();
    }


//    v1st view holder ...

    public static class FirstRecyclerViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView cardImageView;

        public FirstRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            cardImageView = itemView.findViewById(R.id.horizontal_scnd_rc_ImageView);
        }
    }

//    2nd view holder...

    public static class SecondRecyclerViewHolder extends RecyclerView.ViewHolder {





        public SecondRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
