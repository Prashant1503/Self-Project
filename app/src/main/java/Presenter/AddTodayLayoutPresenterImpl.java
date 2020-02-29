package Presenter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Contractor.AddTodayLayoutContractor;
import Model.AddTodayLayoutModelImpl;

public class AddTodayLayoutPresenterImpl implements AddTodayLayoutContractor.Presenter,AddTodayLayoutContractor.onCompletionListner {

    private AddTodayLayoutContractor.View mView;
    private AddTodayLayoutModelImpl mAddTodayLayoutModel;

    public AddTodayLayoutPresenterImpl(AddTodayLayoutContractor.View view) {
        this.mView = view;
        mAddTodayLayoutModel = new AddTodayLayoutModelImpl(this);
    }

    @Override
    public void sendData(FirebaseDatabase mDatabase, DatabaseReference mRef, String addSomethingData) {

        mAddTodayLayoutModel.sendDataToFirebase(mDatabase,mRef,addSomethingData);
    }

    @Override
    public void dataSendOnFirebaseSuccessListner(String message) {

        mView.dataSendSuccess(message);
    }

    @Override
    public void daatSendOnFirebaseErrorListner(String message) {

        mView.dataSendFailure(message);
    }
}
