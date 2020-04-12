package View.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utility.R;

import java.util.ArrayList;
import java.util.List;

import Model.Pojo.ResourceFrgmentMainRcPojo;
import Model.Pojo.ResourceHorizontalRcPojo;
import Model.Pojo.SettingMainRcPojo;
import View.Adapter.ResourceFrgmentMainRcAdpter;
import View.Adapter.SettingRcAdapter;
import View.Adapter.resource_frgment_horizontal_rc_adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private RecyclerView settingRecyclerView;
    private SettingRcAdapter settingRcAdapter;
    private List<SettingMainRcPojo> settingList;



    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_settings, container, false);

        settingRecyclerView = mView.findViewById(R.id.setting_main_recycler_view);
        settingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false
        ));

        settingRecyclerView.setItemAnimator(new DefaultItemAnimator());

        settingList = new ArrayList<>();
//        setting data to settting list..
        settingList.add(new SettingMainRcPojo(R.drawable.account_icon,"General"));
        settingList.add(new SettingMainRcPojo(R.drawable.account_icon,"Productivity"));
        settingList.add(new SettingMainRcPojo(R.drawable.account_icon,"Remainders"));
        settingList.add(new SettingMainRcPojo(R.drawable.account_icon,"Notifications"));
        settingList.add(new SettingMainRcPojo(R.drawable.account_icon,"Support"));
        settingList.add(new SettingMainRcPojo(R.drawable.account_icon,"About"));

        settingRcAdapter = new SettingRcAdapter(settingList,getContext(),new AccountFragment());
        settingRecyclerView.setAdapter(settingRcAdapter);

        return mView;
    }



}
