package Presenter;

import com.google.firebase.auth.FirebaseAuth;

import Contractor.SignInContractor;
import Model.SignInModelImpl;

public class SignInPresenterImpl implements SignInContractor.Presenter,SignInContractor.onCompletionListner {

    private SignInContractor.View mView;
    private SignInModelImpl mSignInModel;

    public SignInPresenterImpl(SignInContractor.View view) {
        this.mView = view;
        mSignInModel = new SignInModelImpl(this);
    }

    @Override
    public void signInUser(FirebaseAuth auth, String email, String password) {

       mSignInModel.SignInFirebaseUser(auth,email,password);

    }

    @Override
    public void onFirebaseSignInSuccess(String firebaseSuccessMessage) {

        mView.onSignInSuccess(firebaseSuccessMessage);

    }

    @Override
    public void onFirebaseSignInFailure(String firebaseFailureMessage) {

        mView.onSignInFailure(firebaseFailureMessage);

    }
}
