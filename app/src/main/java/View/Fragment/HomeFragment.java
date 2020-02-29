package View.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utility.R;

import java.util.ArrayList;
import java.util.List;

import Model.Pojo.MainRcPojo;
import Presenter.AddTodayLayoutPresenterImpl;
import View.Adapter.HomeFrgmentMainRcAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment  {
    View itemView;


    private RecyclerView frstFrgmentMainRecyclerView;
    private HomeFrgmentMainRcAdapter mHomeFrgmentMainRcAdapter;
    private List<MainRcPojo> mMainRcPojosList;

    private AppCompatTextView whtsInMindTextViewListner;




//    end


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        itemView = inflater.inflate(R.layout.fragment_home, container, false);

        whtsInMindTextViewListner = itemView.findViewById(R.id.whts_inMind_textViewListner);




        return itemView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setMainRecyclerView();


    }

    public void setMainRecyclerView() {

        frstFrgmentMainRecyclerView =itemView.findViewById(R.id.frst_fragment_main_recyclerView);

        LinearLayoutManager mainLayoutManager =new LinearLayoutManager(getContext());
        frstFrgmentMainRecyclerView.setLayoutManager(mainLayoutManager);

        mMainRcPojosList = new ArrayList<>();
        mMainRcPojosList.add(new MainRcPojo(MainRcPojo.AGENDA_LAYOUT,"1"));
        mMainRcPojosList.add(new MainRcPojo(MainRcPojo.JOURNAL_LAYOUT));

        mHomeFrgmentMainRcAdapter = new HomeFrgmentMainRcAdapter(mMainRcPojosList,getContext());
        frstFrgmentMainRecyclerView.setAdapter(mHomeFrgmentMainRcAdapter);

    }





}
