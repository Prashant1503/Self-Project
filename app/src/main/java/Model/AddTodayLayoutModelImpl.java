package Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Contractor.AddTodayLayoutContractor;

public class AddTodayLayoutModelImpl implements AddTodayLayoutContractor.Model {

    public AddTodayLayoutContractor.onCompletionListner mOnCompletionListner;

    public AddTodayLayoutModelImpl(AddTodayLayoutContractor.onCompletionListner onCompletionListner) {
        this.mOnCompletionListner = onCompletionListner;
    }

    @Override
    public void sendDataToFirebase(FirebaseDatabase mDatabase,
                                   DatabaseReference mRef, String addSomethingData) {

        mRef = mDatabase.getReference().child("AddSomething");

        mRef.setValue(addSomethingData);

        mRef.setValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {

                if (databaseError!=null) {
                    mOnCompletionListner.daatSendOnFirebaseErrorListner("Data could not be saved" + databaseError.toString());
                }
                else
                {
                    mOnCompletionListner.dataSendOnFirebaseSuccessListner("Data saved successfully");
                }
            }
        });

    }

}