package Contractor;

import com.google.firebase.auth.FirebaseAuth;

public interface SignUpContractor {

    interface  View {

       void onRegisterFailure(String message);

        void onRegisterSuccess(String message);



    }

    interface Presenter {

        void registerUser(FirebaseAuth auth,String email,String password);


    }

    interface Model {

        void RegisterWithFirebase(FirebaseAuth auth,String email,String password);

    }

    interface onCompletionListner {

        void onFirebaseSuccessListner(String firebasesuccess);

        void onFirebaseFailureListner(String firebaseFailure);
    }
}
