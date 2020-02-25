package Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Contractor.AddTodayLayoutContractor;

public class AddTodayLayoutModelImpl implements AddTodayLayoutContractor.Model,AddTodayLayoutContractor.onCompletionListner {
    @Override
    public void sendDataToFirebase(FirebaseDatabase mDatabase, DatabaseReference mRef, String addSomethingData) {

        mRef = mDatabase.getReference();
        mRef = mDatabase.getReference().child("doToday");
        mRef.setValue(addSomethingData);



    }

    @Override
    public void dataSendOnFirebaseSuccessListner(String message) {

    }

    @Override
    public void daatSendOnFirebaseErrorListner(String message) {

    }
}
