package np.cnblabs.asmt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameET, phoneET, emailET, messageET;
    String name, email, phone, message, gender;
    Button submitBtn;
    TextInputLayout nameInputLayout, phoneInputLayout, emailInputLayout, messageInputLayout;
    RadioGroup genderRadioGroup;
    RadioButton maleRadioButton, femaleRadionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String email = getIntent().getStringExtra("email_address");

        nameET = findViewById(R.id.nameET);
        phoneET = findViewById(R.id.phoneET);
        emailET = findViewById(R.id.emailET);
        messageET = findViewById(R.id.messageET);
        nameInputLayout = findViewById(R.id.nameTextInputLayout);
        emailInputLayout = findViewById(R.id.emailTextInputLayout);
        phoneInputLayout = findViewById(R.id.phoneInputLayout);
        messageInputLayout = findViewById(R.id.messageInputLayout);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadionButton = findViewById(R.id.femaleRadioButton);

        submitBtn = findViewById(R.id.submitBtn);

        emailET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateEmail(charSequence.toString(),
                        emailInputLayout,
                        emailET,
                        MainActivity.this);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private boolean validateGender() {
        int selection = genderRadioGroup.getCheckedRadioButtonId();
        if(selection == -1) {
            Toast.makeText(MainActivity.this, getString(R.string.please_select_gender), Toast.LENGTH_LONG).show();
            return false;
        }

        RadioButton radioButton = findViewById(selection);
        gender = radioButton.getText().toString();
        return true;
    }

    private boolean validateName(String name) {
        if(name.isEmpty()){
            nameInputLayout.setError(getString(R.string.this_field_is_required));
            nameInputLayout.setErrorEnabled(true);
            nameET.requestFocus();
            return false;
        }
        nameInputLayout.setError(null);
        nameInputLayout.setErrorEnabled(false);
        return true;
    }

    public static boolean validateEmail(String email,
                                        TextInputLayout emailInputLayout,
                                        EditText emailET,
                                        Context context) {
        if(email.isEmpty()){
            emailInputLayout.setError(context.getString(R.string.this_field_is_required));
            emailInputLayout.setErrorEnabled(true);
            emailET.requestFocus();
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailInputLayout.setError(context.getString(R.string.invalid_email));
            emailInputLayout.setErrorEnabled(true);
            emailET.requestFocus();
            return false;
        }
        emailInputLayout.setError(null);
        emailInputLayout.setErrorEnabled(false);
        return true;
    }

    private boolean validatePhone(String phone) {
        if(phone.isEmpty()){
            phoneInputLayout.setError(getString(R.string.this_field_is_required));
            phoneInputLayout.setEnabled(true);
            phoneET.requestFocus();
            return false;
        }else if(!Patterns.PHONE.matcher(phone).matches()){
            phoneET.setError(getString(R.string.invalid_phone));
            phoneInputLayout.setEnabled(true);
            phoneET.requestFocus();
            return false;
        }
        phoneInputLayout.setError(null);
        phoneInputLayout.setEnabled(false);
        return true;
    }

    private boolean validateMessage(String message) {
        if(message.isEmpty()){
            messageInputLayout.setError(getString(R.string.this_field_is_required));
            messageInputLayout.setEnabled(true);
            messageET.requestFocus();
            return false;
        }
        messageInputLayout.setError(null);
        messageInputLayout.setErrorEnabled(false);
        return true;
    }

    public void validate(View view) {
        name = nameET.getText().toString();
        email = emailET.getText().toString();
        phone = phoneET.getText().toString();
        message = messageET.getText().toString();

       /* if(!validateName(name)) return;
        if(!validateEmail(email)) return;
        if(!validatePhone(phone)) return;
        if(!validateGender()) return;
        if(!validateMessage(message)) return;*/

        startActivity(new Intent(MainActivity.this, DashboardActivity.class));

        System.out.println("name="+ name + " email="+ email + " phone = " + phone + " message = " +  message + " gender = " + gender);
    }
}
