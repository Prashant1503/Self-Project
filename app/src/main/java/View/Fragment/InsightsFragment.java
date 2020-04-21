package View.Fragment;


import android.graphics.drawable.RotateDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.utility.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsightsFragment extends Fragment {

    public AppCompatTextView completionPercentageTv,increasingPercentageTv;
    public ProgressBar taskProgressBar;
    double completionRate =0;

    FirebaseDatabase mDb;
    DatabaseReference mDbRef;

    boolean completedStatus = true;

    public InsightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insights, container, false);

        taskProgressBar = view.findViewById(R.id.insight_task_completion_progressBar);
        completionPercentageTv = view.findViewById(R.id.complete_percentage_textView);
        increasingPercentageTv = view.findViewById(R.id.increasing_percentage_textView);

        mDb = FirebaseDatabase.getInstance();
        mDbRef = mDb.getReference();

        return view;

    }
    @Override
    public void onStart() {
        super.onStart();

        mDbRef.child("Event Status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot status : dataSnapshot.getChildren()) {

//                    Log.d("Status Responses", "onDataChange: " + status.getChildrenCount());
                    String statusCount = String.valueOf(dataSnapshot.getChildrenCount());
//
                    if (dataSnapshot.getChildrenCount() >0) {

                        completionPercentageTv.setText(String.valueOf(dataSnapshot.getChildrenCount() * 0.04 + "%"));
                        taskProgressBar.setProgress(10);
                        increasingPercentageTv.setText(String.valueOf(dataSnapshot.getChildrenCount() * 0.02 + "%"));

                    }

                    Log.d("TAG", "onDataChange: " + statusCount);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),"Database error : " + databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }

}
