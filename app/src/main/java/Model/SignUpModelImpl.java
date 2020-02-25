package Model;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import Contractor.SignUpContractor;

public class SignUpModelImpl implements SignUpContractor.Model {

    private SignUpContractor.onCompletionListner mOnCompletionListner;

    public SignUpModelImpl(SignUpContractor.onCompletionListner onCompletionListner) {
        this.mOnCompletionListner = onCompletionListner;
    }

    @Override
    public void RegisterWithFirebase(FirebaseAuth auth, String email, String password) {

        auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            mOnCompletionListner.onFirebaseSuccessListner("User registered successfully");
                        }
                        else
                        {
                            mOnCompletionListner.onFirebaseFailureListner(task.getException().getMessage());
                        }
                     }
                });
    }
}
