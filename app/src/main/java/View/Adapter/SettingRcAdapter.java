package View.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;

import java.util.List;

import Model.Pojo.SettingMainRcPojo;
import View.Fragment.AccountActivity;
import View.Fragment.AccountFragment;
import View.Fragment.HomeFragment;

public class SettingRcAdapter extends RecyclerView.Adapter<SettingRcAdapter.SettingRcHolder> {

    private List<SettingMainRcPojo> settingList;
    private Context mContx;
    public AccountFragment accountFragment;

    public SettingRcAdapter(List<SettingMainRcPojo> settingList, Context mContx, AccountFragment fragment) {
        this.settingList = settingList;
        this.mContx = mContx;
        this.accountFragment = fragment;

    }

    @NonNull
    @Override
    public SettingRcHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.setting_rc_item_layout, parent, false);


        return new SettingRcHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingRcHolder holder, final int position) {

        final SettingMainRcPojo model = settingList.get(position);

        holder.titleImage.setImageResource(model.getImage());
        holder.titleTv.setText(model.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (position) {
                    case 0:
                      Toast.makeText(mContx,settingList.get(position).getTitle() + " " + "is clicked",Toast.LENGTH_SHORT).show();
                      break;

                    case 1:
                        Toast.makeText(mContx,settingList.get(position).getTitle() + " " + "is clicked",Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(mContx,settingList.get(position).getTitle() + " " + "is clicked",Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        Toast.makeText(mContx,settingList.get(position).getTitle() + " " + "is clicked",Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        Toast.makeText(mContx,settingList.get(position).getTitle() + " " + "is clicked",Toast.LENGTH_SHORT).show();
                        break;

                    case 5:
                        Toast.makeText(mContx,settingList.get(position).getTitle() + " " + "is clicked",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return settingList.size();
    }

    public class SettingRcHolder extends RecyclerView.ViewHolder {

        AppCompatTextView titleTv;
        AppCompatImageView titleImage;

        public SettingRcHolder(@NonNull final View itemView) {
            super(itemView);

            titleTv = itemView.findViewById(R.id.setting_rc_title_tv);
            titleImage = itemView.findViewById(R.id.setting_rc_imageView);




        }
    }
}
