package View.Adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.utility.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Model.Pojo.ResourceFrgmentMainRcPojo;

import static Model.Pojo.ResourceFrgmentMainRcPojo.GOAL_HORIZONTAL_RC_LAYOUT;
import static Model.Pojo.ResourceFrgmentMainRcPojo.GRID_VERTICAL_RC_LAYOUT;

public class ResourceFrgmentMainRcAdpter extends RecyclerView.Adapter {

    private List<ResourceFrgmentMainRcPojo> mainRcList;
    private Context mContext;

//    1st layout adapter,list..
    private List<ResourceFrgmentMainRcPojo>  frstList;
    private ResourceFrgmentMainRcFrstAdapter frstRcAdapter;

//    2nd layout adapter,list...
    private List<ResourceFrgmentMainRcPojo> scndLIst;
    private ResourceFrgmentMainRcScndAdapter scndAdapter;



    private String TAG = "Resource Frgment Main Rc Adapter Response : ";
    public static final String baseUrl = "https://utilitymanagement-26008.firebaseio.com/goal/horizontalData/-M22z45eUgugkRwRt72I.json";


    public ResourceFrgmentMainRcAdpter(List<ResourceFrgmentMainRcPojo> mainRcList, Context context) {
        this.mainRcList = mainRcList;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {

        return position % 2;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        switch (viewType) {

            case GOAL_HORIZONTAL_RC_LAYOUT:

                View frstView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_frgment_main_rc_frst_layout,parent,false);
                return new frstViewHolder(frstView);

            case GRID_VERTICAL_RC_LAYOUT:

                View scndView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_frgment_main_rc_scnd_layout,parent,false);

                return new ScndViewHolder(scndView);

                default:
                    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_frgment_main_rc_frst_layout,parent,false);

                    return new frstViewHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (mainRcList.get(position).getViewType()) {

            case GOAL_HORIZONTAL_RC_LAYOUT:

                break;

            case GRID_VERTICAL_RC_LAYOUT:

                break;
        }



    }

    @Override
    public int getItemCount() {
        return mainRcList.size();
    }


//    frst view holder...
    public class frstViewHolder extends RecyclerView.ViewHolder {

        RecyclerView frstRc;

        public frstViewHolder(@NonNull View itemView) {
            super(itemView);

            frstRc = itemView.findViewById(R.id.resource_frgment_main_rc_frst_recyclerView);
            frstRc.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));


        }
    }

    public class ScndViewHolder extends RecyclerView.ViewHolder {

        RecyclerView scndRecyclerView;


        public ScndViewHolder(@NonNull View itemView) {
            super(itemView);

            scndRecyclerView = itemView.findViewById(R.id.resource_frgment_scndList);

            scndRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));

            scndLIst= new ArrayList<>();
            scndLIst.add(new ResourceFrgmentMainRcPojo(2,R.drawable.drag_icon,"GOAL TYPE","Welcome prashant"));
            scndLIst.add(new ResourceFrgmentMainRcPojo(2,R.drawable.account_icon,"GOAL TYPE","Welcome prashant"));
            scndLIst.add(new ResourceFrgmentMainRcPojo(2,R.drawable.setting_action_bar_icon ,"GOAL TYPE","Welcome prashant"));
            scndLIst.add(new ResourceFrgmentMainRcPojo(2,R.drawable.drag_icon,"GOAL TYPE","Welcome prashant"));
            scndLIst.add(new ResourceFrgmentMainRcPojo(2,R.drawable.drag_icon,"GOAL TYPE","Welcome prashant"));
            scndLIst.add(new ResourceFrgmentMainRcPojo(2,R.drawable.drag_icon,"GOAL TYPE","Welcome prashant"));
            scndLIst.add(new ResourceFrgmentMainRcPojo(2,R.drawable.drag_icon,"GOAL TYPE","Welcome prashant"));

            scndAdapter = new ResourceFrgmentMainRcScndAdapter(scndLIst,mContext);
            scndRecyclerView.setAdapter(scndAdapter);
        }
    }

}
