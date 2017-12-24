package np.cnblabs.asmt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static np.cnblabs.asmt.Utils.validateEmail;

/**
 * Created by sanjogstha on 12/17/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class LoginActivity extends AppCompatActivity {
    EditText emailET, passwordET;
    TextInputLayout emailInputLayout, passwordTextInputLayout;
    SharedPreferences sharedPreferences;

    public static final String PREFERENCES = "my_pref";
    public static final String IS_LOGGED_IN = "is_logged_in";
    public static final String EMAIL_ADDRESS = "email_address";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);

        if(sharedPreferences.contains(IS_LOGGED_IN)){
            boolean isLoggedIn = sharedPreferences.getBoolean(IS_LOGGED_IN, false);
            if(isLoggedIn){
                startMainActivity(sharedPreferences.getString(EMAIL_ADDRESS, null));
            }
        }

        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        emailInputLayout = findViewById(R.id.emailTextInputLayout);
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout);
    }

    private boolean validatePassword(String password) {
        if(password.isEmpty()){
            passwordTextInputLayout.setErrorEnabled(true);
            passwordTextInputLayout.setError(getString(R.string.this_field_is_required));
            passwordET.requestFocus();
            return false;
        }
        passwordTextInputLayout.setErrorEnabled(false);
        return true;
    }

    public void validateUser(View view) {
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();
        if(!validateEmail(email, emailInputLayout, emailET, this))
            return;
        if(!validatePassword(password))
            return;

        if(email.equals("user@user.com") && password.equals("123")){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(EMAIL_ADDRESS, email);
            editor.putBoolean(IS_LOGGED_IN, true);
            editor.apply();
            startMainActivity(email);
        }else{
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
    }

    private void startMainActivity(String email) {
        Intent intent = new Intent(this, HomeActivity.class);
        if(email != null) intent.putExtra("email_address", email);
        startActivity(intent);
        finish();
    }
}
