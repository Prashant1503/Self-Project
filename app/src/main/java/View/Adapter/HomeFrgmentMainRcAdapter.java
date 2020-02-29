package View.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Model.Pojo.FrstFrgmentAgendaPojo;
import Model.Pojo.FrstFrgmentJournalPojo;
import Model.Pojo.MainRcPojo;
import Model.Pojo.doSomedayRcPojo;
import Model.Pojo.doTodayRcPojo;

import static Model.Pojo.MainRcPojo.AGENDA_LAYOUT;
import static Model.Pojo.MainRcPojo.JOURNAL_LAYOUT;

public class HomeFrgmentMainRcAdapter extends RecyclerView.Adapter {

    AppCompatTextView doTodayTextView;
    AppCompatEditText addTodayTaskEdt;
    AppCompatImageButton addTodayTaskImgButton;

//    presenter for addTodayTask.

    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;

//    class for inflating frgemnt.



    public static final String TAG = "do Today Message";





    private List<MainRcPojo> mMainRcPojoslist;
    private Context mContext;

    private List<FrstFrgmentAgendaPojo> agendaList;
    private HomeFrgmentAgendaRcAdapter agendaRcAdapter;

    private List<FrstFrgmentJournalPojo> journalRcList;
    private HomeFrgmentJournalRcAdapter journalRcAdapter;

//    fields for doToday layout...
    private List<doTodayRcPojo> doTodayRcList;
    private doTodayRcAdapter doTodayRcAdapter;
    private RecyclerView doTodayRecycclerView;

//    field for doSomeday layout;

    private List<doSomedayRcPojo> doSomedayList;
    private doSomedayRcAdapter doSomedayRcAdapter;
    private RecyclerView doSomedayRecyclerView;

    public HomeFrgmentMainRcAdapter(List<MainRcPojo> mainRcPojoslist, Context ctx) {
       this.mMainRcPojoslist = mainRcPojoslist;
       this.mContext = ctx;
    }

    @Override
    public int getItemViewType(int position) {

        switch (mMainRcPojoslist.get(position).getViewType()) {

            case 1:

                return AGENDA_LAYOUT;

            case 2:
                return JOURNAL_LAYOUT;

            default:
                return -1;

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case AGENDA_LAYOUT:
                View agendaView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frst_frgment_frst_layout,parent,false);

                return new agendaRecyclerViewHolder(agendaView);

            case JOURNAL_LAYOUT:

                View journalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frst_frgment_second_layout,parent,false);
                return new journalRecyclerViewHolder(journalView);


            default:
                    return null;
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (mMainRcPojoslist.get(position).getViewType()) {

            case AGENDA_LAYOUT:

                String goalcountertext = mMainRcPojoslist.get(position).getGoalCounterText();

                ((agendaRecyclerViewHolder) holder).setData(goalcountertext);



                break;

            case JOURNAL_LAYOUT:

                ((journalRecyclerViewHolder) holder).whtsinMindTextTvListner.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        Toast.makeText(mContext,"Clicked",Toast.LENGTH_SHORT).show();
                        System.out.println("Some other text is been presented");

                    }
                });


            default:
                return;



        }

    }

    @Override
    public int getItemCount() {
        return mMainRcPojoslist.size();
    }

//    view holder class.

    public class agendaRecyclerViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView agendaTitleTv,goalCounterTxtTv,addSomethingTv;
        RecyclerView agendaRecyclerView;




        public agendaRecyclerViewHolder(@NonNull final View itemView) {
            super(itemView);

            agendaTitleTv = itemView.findViewById(R.id.agenda_title_tv);
            goalCounterTxtTv = itemView.findViewById(R.id.goal_counter_tv);
            addSomethingTv = itemView.findViewById(R.id.add_something_textView);


            addSomethingTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    inflateCustomDialog();

                }
            });

            agendaRecyclerView = itemView.findViewById(R.id.frst_frgment_agendaLayoutRecyclerView);
            agendaRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

            agendaList = new ArrayList<>();

//            getting data into agenda recycler view whatever the data added by user into bottom sheet dialog.
            mDatabaseReference = FirebaseDatabase.getInstance().getReference();

            mDatabaseReference.child("Do today").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String title = String.valueOf(dataSnapshot.getValue());

                    mDatabaseReference.limitToLast(1);

                    FrstFrgmentAgendaPojo pojo = new FrstFrgmentAgendaPojo(title,title);
                    agendaList.add(pojo);

                    agendaRcAdapter = new HomeFrgmentAgendaRcAdapter(agendaList,mContext);
                    agendaRecyclerView.setAdapter(agendaRcAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(mContext,"SomeThing went wrong"+databaseError.getMessage(),Toast.LENGTH_SHORT).show();

                }
            });


        }

        private void setData(String goalTitleText) {
            goalCounterTxtTv.setText(goalTitleText);
        }
    }

    public class journalRecyclerViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView journalTitleTv,whtsinMindTextTvListner;
        RecyclerView journalRecyclerView;

        public journalRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            journalTitleTv = itemView.findViewById(R.id.journal_title_textView);
            whtsinMindTextTvListner = itemView.findViewById(R.id.whts_inMind_textViewListner);

            journalRecyclerView = itemView.findViewById(R.id.frst_frgment_second_layoutRecyclerView);
            journalRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

            journalRcList = new ArrayList<>();

            journalRcList.add(new FrstFrgmentJournalPojo("2:00 PM"));
            journalRcList.add(new FrstFrgmentJournalPojo("2:00 PM"));

            journalRcList.add(new FrstFrgmentJournalPojo("2:00 PM"));
            journalRcList.add(new FrstFrgmentJournalPojo("2:00 PM"));

            journalRcAdapter = new HomeFrgmentJournalRcAdapter(journalRcList,mContext);
            journalRecyclerView.setAdapter(journalRcAdapter);

        }

    }
    @SuppressLint("ClickableViewAccessibility")
    public void inflateCustomDialog() {


        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mContext);
        bottomSheetDialog.setContentView(R.layout.add_something_first_recycler_view_layout);
        bottomSheetDialog.setCanceledOnTouchOutside(false);

//        initializing widgets for bottomsheet dialog..

        doTodayTextView = bottomSheetDialog.findViewById(R.id.do_today_textView);
        addTodayTaskEdt = bottomSheetDialog.findViewById(R.id.add_today_edt_text);
        addTodayTaskImgButton = bottomSheetDialog.findViewById(R.id.add_task_today_imageBtn);

//        initiazling data for doTodayRecycler view....
        doTodayRecycclerView = bottomSheetDialog.findViewById(R.id.do_today_recycler_view);
//       setting linear layout manager for  do Today recycler view.....

        LinearLayoutManager managerOne = new LinearLayoutManager(mContext);
        managerOne.setOrientation(LinearLayoutManager.VERTICAL);

        doTodayRecycclerView.setLayoutManager(managerOne);

        doTodayRcList = new ArrayList<>();

//        end..



        addTodayTaskEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                final Drawable logo = mContext.getResources().getDrawable(R.drawable.error_icon);

                Drawable img = mContext.getResources().getDrawable(R.drawable.floating_button_icon);



                final String data = s.toString();

                if (data.length() >=1){

                    addTodayTaskImgButton.setVisibility(View.VISIBLE);
                    addTodayTaskImgButton.setBackgroundDrawable(img);

                    addTodayTaskImgButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (data.isEmpty()) {

                                addTodayTaskEdt.setError("Field can't be empty",logo);
                            }
                            else
                            {

//                                getting data from doToday child into recycler view....
                                mDatabaseReference = FirebaseDatabase.getInstance().getReference();

                                final String id = mDatabaseReference.push().getKey();

                                mDatabaseReference.child("Do today").child(id).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        if (task.isSuccessful()) {

                                            Toast.makeText(mContext,"Data saved successfully",Toast.LENGTH_SHORT).show();
                                            addTodayTaskEdt.setText(null);

//                                            displaying data to recycler view whatever the user entered...

                                            mDatabaseReference.child("Do today").addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                    String value = String.valueOf(dataSnapshot.getValue());

                                                    doTodayRcPojo model = new doTodayRcPojo(R.drawable.calendar_action_bar_icon, R.drawable.drag_icon, value);
                                                    doTodayRcList.add(model);

                                                    doTodayRcAdapter = new doTodayRcAdapter(doTodayRcList, mContext);
                                                    doTodayRecycclerView.setAdapter(doTodayRcAdapter);


                                                    Log.i(TAG,value);

                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                    Log.i(TAG,databaseError.getMessage());

                                                }
                                            });


                                        }
                                        else
                                        {
                                            Toast.makeText(mContext,"Data not saved" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                            }
                        };

                    });


                }else {

                    addTodayTaskImgButton.setVisibility(View.VISIBLE);
                }
            }
        });

//

        bottomSheetDialog.show();

    }









}
