package Contractor;

import com.google.firebase.auth.FirebaseAuth;

public interface SignInContractor {

    interface View {

        void onSignInFailure(String failureMsg);

        void onSignInSuccess(String successMsg);


    }

    interface Model {

        void SignInFirebaseUser(FirebaseAuth auth,String email,String password);



    }

    interface Presenter {

        void signInUser(FirebaseAuth auth,String email,String password);


    }

    interface onCompletionListner {

        void onFirebaseSignInSuccess(String firebaseSuccessMessage);

        void onFirebaseSignInFailure(String firebaseFailureMessage);
    }
}
