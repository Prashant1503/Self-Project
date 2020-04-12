package View.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Fragment.EventTimePickerFragment;
import Model.Pojo.EventTodayBtnmodel;
import Model.Pojo.FrstFrgmentAgendaPojo;
import Model.Pojo.FrstFrgmentJournalPojo;
import Model.Pojo.MainRcPojo;
import Model.Pojo.doTodayRcPojo;

import static Model.Pojo.MainRcPojo.AGENDA_LAYOUT;
import static Model.Pojo.MainRcPojo.JOURNAL_LAYOUT;

public class HomeFrgmentMainRcAdapter extends RecyclerView.Adapter implements TimePickerDialog.OnTimeSetListener {

    AppCompatTextView doTodayTextView;
    AppCompatEditText addTodayTaskEdt;
    AppCompatImageButton addTodayTaskImgButton;

//    presenter for addTodayTask.

    FirebaseDatabase rootFirebaseDb;
    DatabaseReference rootDbRef;

//    event fields..
    AppCompatTextView journalTitleTv;
    RecyclerView journalRecyclerView;

//    class for inflating frgemnt.


    public static final String TAG = "do Today Message";
    private doTodayRcPojo modelOne;


    private List<MainRcPojo> mMainRcPojoslist;
    private Context mContext;

    private List<FrstFrgmentAgendaPojo> agendaList;
    private HomeFrgmentAgendaRcAdapter agendaRcAdapter;

    private List<FrstFrgmentJournalPojo> journalRcList;
    private HomeFrgmentEventRcAdapter journalRcAdapter;

    private FloatingActionButton fBtn;

    //    fields for doToday layout...
    private List<doTodayRcPojo> doTodayRcList;
    private doTodayRcAdapter doTodayRcAdapter;
    private RecyclerView doTodayRecycclerView;


//    event fields
    private BottomSheetDialog eventDialog;
    AppCompatEditText addEventEdt;
    AppCompatButton todayBtn,inboxBtn;
    AppCompatImageView labelImageView,priorityImageView,alarmImageView,chatImageView,sendImageView;
    String eventTitle;
    String eventPushId;



    long id;
    String title;

//    field for doSomeday layout;

    private List<FrstFrgmentJournalPojo> eventList;
    private HomeFrgmentEventRcAdapter eventRcAdapter;
    private RecyclerView eventRecyclerView;

     EventTodayBtnmodel eventModel;


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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        switch (viewType) {
            case AGENDA_LAYOUT:
                View agendaView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frst_frgment_frst_layout, parent, false);

                return new agendaRecyclerViewHolder(agendaView);

            case JOURNAL_LAYOUT:

                 final View journalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frst_frgment_second_layout, parent, false);

//                recycler view for journal layout..
                eventRecyclerView = journalView.findViewById(R.id.frst_frgment_second_layoutRecyclerView);

                final LinearLayoutManager manager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
                eventRecyclerView.setLayoutManager(manager);

                eventList = new ArrayList<>();
                eventList.add(new FrstFrgmentJournalPojo("Title one"));

                eventRcAdapter = new HomeFrgmentEventRcAdapter(eventList,mContext);
                eventRecyclerView.setAdapter(eventRcAdapter);


//end of the recycler view..

                fBtn = journalView.findViewById(R.id.mainFbButton);



                eventDialog = new BottomSheetDialog(mContext,R.style.BottomSheetDialogTheme);

                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        View eventBottomSheetView = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.event_bottom_sheet_layout,
                                       (RelativeLayout) parent.findViewById(R.id.bottomSheetContainer));

//                       getting view from event bottom sheet ...
                        addEventEdt = eventBottomSheetView.findViewById(R.id.bottom_sheet_dialog_event_edt);
                        todayBtn = eventBottomSheetView.findViewById(R.id.today_eventButton);
                        inboxBtn = eventBottomSheetView.findViewById(R.id.today_inbox_Button);
                        sendImageView = eventBottomSheetView.findViewById(R.id.event_send_imageView);

                        todayBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                BottomSheetDialog eventDialog = new BottomSheetDialog(mContext,R.style.BottomSheetDialogTheme);

                                View eventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_today_btn_bottom_sheet_layout,
                                        (LinearLayout) journalView.findViewById(R.id.event_main_linearContainer));

//                               fields for event bottom dialog..
                                AppCompatButton addEventBtn = eventView.findViewById(R.id.add_event_calender_btn);
                                CalendarView eventCalender = eventView.findViewById(R.id.today_btn_calendar_view);

                                eventModel = new EventTodayBtnmodel();

                                final Toolbar eventToolbar = eventView.findViewById(R.id.event_today_toolbar);

                                addEventBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        Log.d(TAG, "onClick: " + "Something went wrong please check it");

                                    }
                                });

                                eventCalender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                                    @Override
                                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                                        String title = addEventEdt.getText().toString();

                                        Calendar calendar = Calendar.getInstance();
                                        calendar.set(Calendar.YEAR,year);
                                        calendar.set(Calendar.MONTH,month);
                                        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                                        String time = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());

                                        Log.d(TAG, "onSelectedDayChange: " + time);

                                        eventModel.setMonth((month));
                                        eventModel.setDay(dayOfMonth);
                                        eventModel.setYear(year);
                                        eventModel.setTime(time);
                                        eventModel.setEventTitle(title);


                                        eventToolbar.setTitle(time);

                                    }
                                });

                                eventDialog.setContentView(eventView) ;
                                eventDialog.show();

                            }
                        });



                        sendImageView.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {



                               if (TextUtils.isEmpty(addEventEdt.getText().toString())) {
                                   eventDialog.dismiss();
                               }
                               if (!TextUtils.isEmpty(addEventEdt.getText().toString())) {

                                   rootFirebaseDb = FirebaseDatabase.getInstance();
                                   rootDbRef = rootFirebaseDb.getReference();

                                   eventPushId = rootDbRef.push().getKey();

//                                   FrstFrgmentJournalPojo model = new FrstFrgmentJournalPojo(addEventEdt.getText().toString());

                                   rootFirebaseDb = FirebaseDatabase.getInstance();
                                   rootDbRef = rootFirebaseDb.getReference();


                                   rootDbRef.child("EventList").child(String.valueOf(eventPushId)).setValue(eventModel);
                                   rootDbRef.push();

                                   Toast.makeText(mContext,"Task successfully added",Toast.LENGTH_SHORT).show();
                                   addEventEdt.setText("");


//                                   getting data of event from firebase child node ...
                                   rootDbRef.child("EventList").child(eventPushId).addValueEventListener(new ValueEventListener() {
                                       @Override
                                       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                           eventList = new ArrayList<>();

                                           for (DataSnapshot eventDs : dataSnapshot.getChildren()) {
                                               Log.d(TAG, "onDataChange: " + eventDs.getValue());
                                           }
//                                                    eventTitle = dataSnapshot.child("taskTitle").getValue(String.class);


                                           journalRecyclerView = journalView.findViewById(R.id.frst_frgment_second_layoutRecyclerView);
                                           journalRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

                                           journalRcList = new ArrayList<>();
                                           journalRcList.add(new FrstFrgmentJournalPojo(eventTitle));

                                           journalRcAdapter = new HomeFrgmentEventRcAdapter(journalRcList,mContext);
                                           journalRecyclerView.setAdapter(journalRcAdapter);

//                                                   setting data to event list...

                                       }

                                       @Override
                                       public void onCancelled(@NonNull DatabaseError databaseError) {

                                           Log.d(TAG, "onDatabase Error: " + databaseError.getMessage());

                                       }
                                   });
                               }
                           }
                       });

                       eventDialog.setContentView(eventBottomSheetView);
                       eventDialog.show();
                    }
                });
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

//                ((journalRecyclerViewHolder) holder).eventItemRadioBtn.setText(eventPojo.getTaskTitle());


            default:
                return;


        }

    }


    @Override
    public int getItemCount() {
        return mMainRcPojoslist.size();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        eventModel.setHour(hourOfDay);
        eventModel.setMinute(minute);

    }

//    view holder class.

    public class agendaRecyclerViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView agendaTitleTv, goalCounterTxtTv, addSomethingTv;
        RecyclerView agendaRecyclerView;


        public agendaRecyclerViewHolder(@NonNull final View itemView) {
            super(itemView);

            agendaTitleTv = itemView.findViewById(R.id.agenda_title_tv);
            goalCounterTxtTv = itemView.findViewById(R.id.goal_counter_tv);
            addSomethingTv = itemView.findViewById(R.id.add_something_textView);

            rootFirebaseDb = FirebaseDatabase.getInstance();
            rootDbRef = rootFirebaseDb.getReference();

//setting data to agenda list..
            agendaRecyclerView = itemView.findViewById(R.id.frst_frgment_agendaLayoutRecyclerView);
            agendaList = new ArrayList<>();

            agendaRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            agendaList = new ArrayList<>();

            rootDbRef.child("doToday").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot ds: dataSnapshot.getChildren()) {


                        String title = ds.child("taskTitleText").getValue(String.class);


                        agendaList.add(new FrstFrgmentAgendaPojo("",title));

                        agendaRcAdapter = new HomeFrgmentAgendaRcAdapter(agendaList,mContext);
                        agendaRecyclerView.setAdapter(agendaRcAdapter);


                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(mContext,"Database Error : " +databaseError.getMessage(),Toast.LENGTH_SHORT).show();

                }
            });


            addSomethingTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    inflateCustomDialog();

                }
            });




        }

        private void setData(String goalTitleText) {
            goalCounterTxtTv.setText(goalTitleText);
        }
    }

    public class journalRecyclerViewHolder extends RecyclerView.ViewHolder {

        MaterialRadioButton eventItemRadioBtn;


        public journalRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);


            eventItemRadioBtn = itemView.findViewById(R.id.event_radioBtn);

            journalTitleTv = itemView.findViewById(R.id.journal_title_textView);
            journalRecyclerView = itemView.findViewById(R.id.frst_frgment_second_layoutRecyclerView);
            journalRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));


            journalRcList = new ArrayList<>();
            eventList.add(new FrstFrgmentJournalPojo("Title one"));

            journalRcAdapter = new HomeFrgmentEventRcAdapter(eventList,mContext);
            journalRecyclerView.setAdapter(journalRcAdapter);

        }


    }

//    method to load data from firebase...


    @SuppressLint("ClickableViewAccessibility")
    public void inflateCustomDialog() {


        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mContext);
        bottomSheetDialog.setContentView(R.layout.add_something_first_recycler_view_layout);
        bottomSheetDialog.setCanceledOnTouchOutside(false);

//        initializing firebase database and firebase database refrence...

        rootFirebaseDb = FirebaseDatabase.getInstance();
        rootDbRef = rootFirebaseDb.getReference();
//        end..

//        initializing widgets for bottomsheet dialog..

        doTodayTextView = bottomSheetDialog.findViewById(R.id.do_today_textView);
        addTodayTaskEdt = bottomSheetDialog.findViewById(R.id.add_today_edt_text);
        addTodayTaskImgButton = bottomSheetDialog.findViewById(R.id.add_task_today_imageBtn);

//        initiazling data for doTodayRecycler view....
        doTodayRecycclerView = bottomSheetDialog.findViewById(R.id.do_today_recycler_view);


//       setting linear layout manager for  do Today recycler view.....


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

                if (data.length() >= 1) {

                    addTodayTaskImgButton.setVisibility(View.VISIBLE);
                    addTodayTaskImgButton.setBackgroundDrawable(img);

                    addTodayTaskImgButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (addTodayTaskEdt.getText().toString().isEmpty()) {

                                addTodayTaskEdt.setError("Field can't be empty", logo);
                            } else {

//                                getting data from doToday child into recycler view...
                                title = addTodayTaskEdt.getText().toString();

                                if (!title.isEmpty()) {

//                                    adding data to firebase data..
                                    String id = rootDbRef.push().getKey();
                                    doTodayRcPojo model = new doTodayRcPojo(R.id.add_taskToday_ImageView,R.id.add_today_task_Drag_ImageView,title);
                                    rootDbRef.child("doToday").child(id).setValue(model);

                                    Toast.makeText(mContext,"Goal added success",Toast.LENGTH_SHORT).show();
                                    addTodayTaskEdt.setText("");

                                    doTodayRecycclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
                                    doTodayRcList = new ArrayList<>();


//                                    setting data to doToday recycler view,when added with all data stored on firebase database.
                                    rootDbRef.child("doToday").addValueEventListener(new ValueEventListener() {

                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                            for (DataSnapshot ds: dataSnapshot.getChildren()) {


                                                String title = ds.child("taskTitleText").getValue(String.class);

                                                Log.d(TAG, "Title: " + title);



                                                doTodayRcList.add(new doTodayRcPojo(R.id.add_taskToday_ImageView,R.id.add_today_task_Drag_ImageView,title));

                                                doTodayRcAdapter = new doTodayRcAdapter(doTodayRcList,mContext);
                                                doTodayRecycclerView.setAdapter(doTodayRcAdapter);

                                            }

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {
                                            Toast.makeText(mContext,"Database Error : " + databaseError.getMessage().toString(),Toast.LENGTH_SHORT).show();

                                        }
                                    });


                                }

                            }
                        }

                        ;

                    });


                } else {

                    addTodayTaskImgButton.setVisibility(View.VISIBLE);
                }
            }
        });

        bottomSheetDialog.show();

    }

}