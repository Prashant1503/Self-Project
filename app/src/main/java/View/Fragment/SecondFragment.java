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
import android.widget.Toast;

import com.example.utility.R;

import java.util.ArrayList;
import java.util.List;

import Model.Pojo.AddSomethingMainRcPojo;
import Model.Pojo.FrstFrgmentAgendaPojo;
import View.Adapter.AddSomethingMainRcAdapter;
import View.Adapter.FrstFrgmentAgendaRcAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private FrstFrgmentAgendaRcAdapter mFrstFrgmentAgendaRcAdapter;
    private List<FrstFrgmentAgendaPojo> mFrstFrgmentAgendaPojoList;
    private RecyclerView agendaRc;

    private AppCompatTextView addSomethingTextView;

//    add something recycler view code..
    private AddSomethingMainRcAdapter mAddSomethingMainRcAdapter;
    private List<AddSomethingMainRcPojo> mAddSomethingMainRcPojoList;
    private RecyclerView addSomethingRecyclerView;

    View v;




    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_second, container, false);

//        agenda main recycler view code..
        addSomethingTextView = v.findViewById(R.id.add_something_textView);

        agendaRc = v.findViewById(R.id.frst_frgment_agendaLayoutRecyclerView);
        agendaRc.setLayoutManager(new LinearLayoutManager(getContext()));

        mFrstFrgmentAgendaPojoList = new ArrayList<>();

        mFrstFrgmentAgendaPojoList.add(new FrstFrgmentAgendaPojo("one","two"));
        mFrstFrgmentAgendaPojoList.add(new FrstFrgmentAgendaPojo("one","two"));
        mFrstFrgmentAgendaPojoList.add(new FrstFrgmentAgendaPojo("one","two"));
        mFrstFrgmentAgendaPojoList.add(new FrstFrgmentAgendaPojo("one","two"));

        mFrstFrgmentAgendaRcAdapter = new FrstFrgmentAgendaRcAdapter(mFrstFrgmentAgendaPojoList,getContext());
        agendaRc.setAdapter(mFrstFrgmentAgendaRcAdapter);

//        end..


        return v;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            addSomethingTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openRecentGoals();
                }
            });


    }
    public void openRecentGoals() {


//        add something layout code..
        addSomethingRecyclerView = v.findViewById(R.id.add_something_recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        addSomethingRecyclerView.setLayoutManager(manager);

        mAddSomethingMainRcPojoList = new ArrayList<>();
        mAddSomethingMainRcPojoList.add(new AddSomethingMainRcPojo(1));
        mAddSomethingMainRcPojoList.add(new AddSomethingMainRcPojo(2));

        mAddSomethingMainRcAdapter = new AddSomethingMainRcAdapter(mAddSomethingMainRcPojoList,getContext());
        addSomethingRecyclerView.setAdapter(mAddSomethingMainRcAdapter);


    }

}
