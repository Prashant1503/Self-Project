package Contractor;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public interface AddTodayLayoutContractor {

    interface View {

        void dataSendSuccess(String successMsg);

        void dataSendFailure(String errMsg);


    }

    interface Model {

        void sendDataToFirebase(FirebaseDatabase mDatabase, DatabaseReference mRef,String addSomethingData);

    }

    interface Presenter {

        void sendData(FirebaseDatabase mDatabase, DatabaseReference mRef,String addSomethingData);

    }

    interface onCompletionListner {

        void dataSendOnFirebaseSuccessListner(String message);

        void daatSendOnFirebaseErrorListner(String message);
    }
}
