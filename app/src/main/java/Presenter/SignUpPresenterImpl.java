package Presenter;

import com.google.firebase.auth.FirebaseAuth;

import Contractor.SignUpContractor;
import Model.SignUpModelImpl;

public class SignUpPresenterImpl implements SignUpContractor.Presenter, SignUpContractor.onCompletionListner {

    private SignUpModelImpl mSignInModel;
    private SignUpContractor.View mView;

    public SignUpPresenterImpl(SignUpContractor.View view) {
        this.mView = view;
        mSignInModel = new SignUpModelImpl(this);
    }

    @Override
    public void registerUser(FirebaseAuth auth, String email, String password) {

        mSignInModel.RegisterWithFirebase(auth,email,password);

    }

    @Override
    public void onFirebaseSuccessListner(String firebasesuccess) {

        mView.onRegisterSuccess(firebasesuccess);

    }

    @Override
    public void onFirebaseFailureListner(String firebaseFailure) {

        mView.onRegisterFailure(firebaseFailure);

    }
}
