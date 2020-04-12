package View.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utility.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Model.Pojo.InBoxRcPojo;
import View.Adapter.InboxRcAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class InboxFragment extends Fragment{

    private FirebaseDatabase mDb;
    private DatabaseReference mDbRef;
    public View v;

//    inbox fragment recycler view field..
    private RecyclerView inboxRecyclerView;
    private InboxRcAdapter inboxRcAdapter;
    public List<InBoxRcPojo> inboxPojoList;
    private String TAG = "Inbox data responses :";
    InBoxRcPojo model;


    public InboxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_inbox, container, false);

         mDb = FirebaseDatabase.getInstance();
         mDbRef = mDb.getReference();


         inboxRecyclerView = v.findViewById(R.id.inbox_recyclerView);

         loadEventData();


        return v;

    }

    private void loadEventData() {

        inboxRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        inboxPojoList = new ArrayList<>();



        mDbRef.child("EventList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

//                int title,day,month;


                if (dataSnapshot.exists()) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                       String month = ds.child("month").getValue().toString();
                       String title = ds.child("eventTitle").getValue().toString();
                       String date = ds.child("day").getValue().toString();
                       String time = ds.child("time").getValue().toString();

                       model = new InBoxRcPojo();
                       model.setInboxTitle(title);
                       model.setDay(date);
                       model.setMonth(month);
                       model.setTime(time);

                       inboxPojoList.add(model);

                       inboxRcAdapter = new InboxRcAdapter(inboxPojoList,getContext());
                       inboxRecyclerView.setAdapter(inboxRcAdapter);

                        Log.d(TAG, "Month : " + month + "Title : " + title + "Date : " + date);

                    }

                }
                else
                {
                    Log.d(TAG, "onDataChange: " + "Something went wrong,please check it..");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Log.d(TAG, "Database Error: " + databaseError.getMessage());
            }
        });

    }
}
