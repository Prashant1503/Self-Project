package Model;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import Contractor.SignInContractor;

public class SignInModelImpl implements SignInContractor.Model {

    private SignInContractor.onCompletionListner mOnCompletionListner;

    public SignInModelImpl(SignInContractor.onCompletionListner onCompletionListner) {
        this.mOnCompletionListner = onCompletionListner;
    }

    @Override
    public void SignInFirebaseUser(FirebaseAuth auth, String email, String password) {

        auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    mOnCompletionListner.onFirebaseSignInSuccess("User logged in successfully");
                }
                else
                {
                    mOnCompletionListner.onFirebaseSignInFailure(task.getException().getMessage());
                }

            }
        });

    }
}
