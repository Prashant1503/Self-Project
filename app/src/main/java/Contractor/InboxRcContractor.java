package Contractor;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import Model.Pojo.InBoxRcPojo;

public interface InboxRcContractor {

    interface View {

        void onFailure(String message);

        void onSuccess(String message);


    }

    interface Model {

        void loadInboxDataFromFirebase(FirebaseDatabase mDb, DatabaseReference mdbRef, List<InBoxRcPojo> inboxList);



    }

    interface Presenter {

        void loadData(FirebaseDatabase mDb, DatabaseReference mdbRef, List<InBoxRcPojo> inboxList);


    }

    interface FirebaseOnCompleteListner {

        void onFirebaseSuccess(String message);

        void onFirebaseFailure(String message);


    }
}
