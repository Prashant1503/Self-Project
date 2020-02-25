package View.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utility.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import Model.Pojo.FrstFrgmentAgendaPojo;
import Model.Pojo.FrstFrgmentJournalPojo;
import Model.Pojo.MainRcPojo;
import Model.Pojo.doMainRcPojo;

import static Model.Pojo.MainRcPojo.AGENDA_LAYOUT;
import static Model.Pojo.MainRcPojo.JOURNAL_LAYOUT;

public class FrstFrgmentMainRcAdapter extends RecyclerView.Adapter {

    AppCompatTextView doTodayTextView;
    AppCompatEditText addTodayTaskEdt;



    private List<MainRcPojo> mMainRcPojoslist;
    private Context mContext;

    private List<FrstFrgmentAgendaPojo> agendaList;
    private FrstFrgmentAgendaRcAdapter agendaRcAdapter;

    private List<FrstFrgmentJournalPojo> journalRcList;
    private FrstFrgmentJournalRcAdapter journalRcAdapter;

//    fields for doToday layout...
    private List<doMainRcPojo> doTodayRcList;
    private doTodayRcAdapter doTodayRcAdapter;
    private RecyclerView doTodayRecycclerView;

//    field for doSomeday layout;

    private List<doMainRcPojo> doSomedayList;
    private doSomedayRcAdapter doSomedayRcAdapter;
    private RecyclerView doSomedayRecyclerView;

    public FrstFrgmentMainRcAdapter(List<MainRcPojo> mainRcPojoslist,Context ctx) {
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

                        Toast.makeText(mContext,"Clicked",Toast.LENGTH_SHORT).show();
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


//


            agendaRecyclerView = itemView.findViewById(R.id.frst_frgment_agendaLayoutRecyclerView);
            agendaRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

            agendaList = new ArrayList<>();
            agendaList.add(new FrstFrgmentAgendaPojo("radioSubtitle","Frst radio btn text"));
            agendaList.add(new FrstFrgmentAgendaPojo("radioSubtitle","Frst radio btn text"));

            agendaRcAdapter = new FrstFrgmentAgendaRcAdapter(agendaList,mContext);
            agendaRecyclerView.setAdapter(agendaRcAdapter);



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

            journalRcAdapter = new FrstFrgmentJournalRcAdapter(journalRcList,mContext);
            journalRecyclerView.setAdapter(journalRcAdapter);


        }

    }
    public void inflateCustomDialog() {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mContext);
        bottomSheetDialog.setContentView(R.layout.add_something_first_recycler_view_layout);
        bottomSheetDialog.setCanceledOnTouchOutside(false);

//        initializing widgets for bottomsheet dialog..

        doTodayTextView = bottomSheetDialog.findViewById(R.id.do_today_textView);
        addTodayTaskEdt = bottomSheetDialog.findViewById(R.id.add_today_edt_text);

        addTodayTaskEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!addTodayTaskEdt.getText().toString().trim().isEmpty()) {


                }
                else
                {
                    addTodayTaskEdt.setError("Field can't be empty");
                }

            }
        });


//        initiazling data for doTodayRecycler view....
        doTodayRecycclerView = bottomSheetDialog.findViewById(R.id.do_today_recycler_view);
//       setting linear layout manager for  do Today recycler view.....

        LinearLayoutManager managerOne = new LinearLayoutManager(mContext);
        managerOne.setOrientation(LinearLayoutManager.VERTICAL);

        doTodayRecycclerView.setLayoutManager(managerOne);

        doTodayRcList = new ArrayList<>();

        doTodayRcList.add(new doMainRcPojo(R.drawable.account_icon,"Title one","Subtitle task one"));
        doTodayRcList.add(new doMainRcPojo(R.drawable.camera_icon,"Title one","Subtitle task one"));
        doTodayRcList.add(new doMainRcPojo(R.drawable.calendar_action_bar_icon,"Title one","Subtitle task one"));
        doTodayRcList.add(new doMainRcPojo(R.drawable.clear_icon,"Title one","Subtitle task one"));


        doTodayRcAdapter = new doTodayRcAdapter(doTodayRcList,mContext);
        doTodayRecycclerView.setAdapter(doTodayRcAdapter);

//        end..

        bottomSheetDialog.show();

    }
}
