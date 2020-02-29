package View.Fragment;


import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utility.R;

import java.util.ArrayList;
import java.util.List;

import Model.Pojo.ResouceFrgmentHorizontalFrstRcPojo;
import View.Adapter.ResourceFrgmentHorizontalMainRcAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResourcesFragment extends Fragment {


    View mView;

    public Toolbar resourceFrgmentToolbar;
    public SearchView resourceFrgmentSearchView;
    public RecyclerView resourceFrgmentCategoryRecyclerView;
    public ResourceFrgmentHorizontalMainRcAdapter mResourceFrgmentHorizontalMainRcAdapter;

    public List<ResouceFrgmentHorizontalFrstRcPojo> mHorizontalRcPojoList;

    private RecyclerView resourceFrgmentMainRc;



    public ResourcesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_resources, container, false);


        initViews();

        return mView;
    }

    private void initViews() {

        resourceFrgmentToolbar = mView.findViewById(R.id.resource_fragment_toolbar);

        resourceFrgmentSearchView = mView.findViewById(R.id.resource_fragment_search_view);


//        1st horizontal recycler view...
        resourceFrgmentCategoryRecyclerView = mView.findViewById(R.id.resource_fragment_category_recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        resourceFrgmentCategoryRecyclerView.setLayoutManager(manager);

//        prepareHorizontalRcData();

//        end

//        main horizontal recycler view ka 1st  layout..



    }

//    private void prepareHorizontalRcData() {
//
//        mHorizontalRcPojoList = new ArrayList<>();
//
//
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("All"));
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("Balance"));
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("Food"));
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("Goal"));
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("Habit"));
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("Mental Health"));
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("Mindfulness"));
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("Motivation"));
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("Productivity"));
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("Sleep"));
//        mHorizontalRcPojoList.add(new ResouceFrgmentHorizontalFrstRcPojo("Tools"));
//
//        mResourceFrgmentHorizontalMainRcAdapter = new ResourceFrgmentHorizontalMainRcAdapter(mHorizontalRcPojoList, getContext());
//        resourceFrgmentCategoryRecyclerView.setAdapter(mResourceFrgmentHorizontalMainRcAdapter);
//
//        mResourceFrgmentHorizontalMainRcAdapter.notifyDataSetChanged();
//    }


}
