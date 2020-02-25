package View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.utility.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

import Contractor.SignInContractor;
import Presenter.SignInPresenterImpl;

public class SignInActivity extends AppCompatActivity implements SignInContractor.View {

    public TextInputLayout emailInputLayout,passwordInputLayout;
    public TextInputEditText emailEdt,passwordEdt;
    public AppCompatButton signInBtn,googleSignInBtn,skipBtn;
    public AppCompatTextView forgotPwdTv,alreadyHveAnAccountTv;

    private SignInPresenterImpl mSignInPresenter;
    private FirebaseAuth mFirebaseAuth;



     private String email,password;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mSignInPresenter = new SignInPresenterImpl(this);


        initViews();

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validated();
            }
        });
        alreadyHveAnAccountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignInActivity.this,HomeActivity.class));
            }
        });
    }

    private boolean validated() {

        if (validateEmail() && validatePassword()) {

            mSignInPresenter.signInUser(mFirebaseAuth,email,password);
            startActivity(new Intent(SignInActivity.this, HomeActivity.class));
        }
        else
        {
            return false;
        } return false;
    }

    private boolean validateEmail() {

        email = emailEdt.getText().toString().trim();


       if(email.isEmpty()) {

           emailInputLayout.setError(getResources().getString(R.string.both_field_error_txt));
           return false;
       }
       else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

           emailInputLayout.setError(getResources().getString(R.string.both_field_error_txt));
           return false;

       }
       else
       {
           emailInputLayout.setError(null);
           return true;
       }
    }

    private boolean validatePassword() {

        password = passwordEdt.getText().toString().trim();


        if(password.isEmpty()) {

            passwordInputLayout.setError(getResources().getString(R.string.both_field_error_txt));
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(password).matches()) {

            passwordInputLayout.setError(getResources().getString(R.string.password_weak_txt));
            return false;

        }
        else
        {
            passwordInputLayout.setError(null);
            return true;
        }
    }

    public void initViews() {

        emailEdt = findViewById(R.id.sign_in_email_txtInputEdt);
        passwordEdt = findViewById(R.id.sign_in_password_txtInputEdt);

        emailInputLayout = findViewById(R.id.sign_in_email_txtInputLayout);
        passwordInputLayout = findViewById(R.id.sign_in_password_txtInputLayout);

        signInBtn = findViewById(R.id.sign_in_btn);



        forgotPwdTv = findViewById(R.id.forgot_password_tv);
        alreadyHveAnAccountTv = findViewById(R.id.already_hve_an_account_tv);

        skipBtn = findViewById(R.id.skipBtn);


    }


    @Override
    public void onSignInFailure(String failureMsg) {

        Toast.makeText(this,failureMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignInSuccess(String successMsg) {

        Toast.makeText(this,successMsg,Toast.LENGTH_SHORT).show();

    }


}
