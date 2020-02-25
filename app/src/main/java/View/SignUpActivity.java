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

import Contractor.SignUpContractor;
import Presenter.SignUpPresenterImpl;

public class SignUpActivity extends AppCompatActivity implements SignUpContractor.View {

    public TextInputLayout emaiInputLayout,passwordInputLayout;
    public TextInputEditText emailEdt,passwordEdt;
    public AppCompatButton signUpBtn;
    public AppCompatTextView alreadyHveAnAccountTv;

    private SignUpPresenterImpl mSignUpPresenterImpl;
    private FirebaseAuth mFirebaseAuth;

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

    private String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mSignUpPresenterImpl = new SignUpPresenterImpl(this);


        initViews();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validated();


            }
        });
    }

    private boolean validated() {

        if (validateEmail() && validatePassword()) {

            mSignUpPresenterImpl.registerUser(mFirebaseAuth,email,password);
            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
        }
        else
        {
            return false;
        } return false;
    }

    private void initViews() {

        emaiInputLayout = findViewById(R.id.sign_up_email_txtInputLayout);
        passwordInputLayout = findViewById(R.id.sign_up_password_txtInputLayout);

        emailEdt = findViewById(R.id.sign_up_email_txtInputEdt);
        passwordEdt = findViewById(R.id.sign_up_password_txtInputEdt);

        signUpBtn = findViewById(R.id.sign_up_btn);
        alreadyHveAnAccountTv = findViewById(R.id.already_hve_an_account_tv);

    }

    private boolean validateEmail() {

        email = emailEdt.getText().toString().trim();


        if(email.isEmpty()) {

            emaiInputLayout.setError(getResources().getString(R.string.both_field_error_txt));
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            emaiInputLayout.setError(getResources().getString(R.string.both_field_error_txt));
            return false;

        }
        else
        {
            emaiInputLayout.setError(null);
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


    @Override
    public void onRegisterFailure(String message) {

        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterSuccess(String message) {

        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

    }
}
