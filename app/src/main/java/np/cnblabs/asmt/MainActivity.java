package np.cnblabs.asmt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nameET, phoneET, emailET, messageET;
    String name, email, phone, message;
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = findViewById(R.id.nameET);
        phoneET = findViewById(R.id.phoneET);
        emailET = findViewById(R.id.emailET);
        messageET = findViewById(R.id.messageET);

        submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate() {
        name = nameET.getText().toString();
        email = emailET.getText().toString();
        phone = phoneET.getText().toString();
        message = messageET.getText().toString();

        if(!validateName(name)) return;
        if(!validateEmail(email)) return;
        if(!validatePhone(phone)) return;
        if(!validateMessage(message)) return;

        System.out.println("name="+ name + " email="+ email + " phone = " + phone + " message = " +  message);

    }

    private boolean validateName(String name) {
        if(name.isEmpty()){
            nameET.setError(getString(R.string.this_field_is_required));
            return false;
        }
        return true;
    }

    private boolean validateEmail(String email) {
        if(email.isEmpty()){
            emailET.setError(getString(R.string.this_field_is_required));
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailET.setError(getString(R.string.invalid_email));
            return false;
        }
        return true;
    }

    private boolean validatePhone(String phone) {
        if(phone.isEmpty()){
            phoneET.setError(getString(R.string.this_field_is_required));
            return false;
        }else if(!Patterns.PHONE.matcher(phone).matches()){
            phoneET.setError(getString(R.string.invalid_phone));
            return false;
        }
        return true;
    }

    private boolean validateMessage(String message) {
        if(message.isEmpty()){
            messageET.setError(getString(R.string.this_field_is_required));
            return false;
        }
        return true;
    }
}
