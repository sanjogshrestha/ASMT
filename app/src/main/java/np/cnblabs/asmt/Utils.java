package np.cnblabs.asmt;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.widget.EditText;

/**
 * Created by sanjogstha on 12/24/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class Utils {
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

    public static boolean validateName(String name, TextInputLayout nameInputLayout,
                                       EditText nameET, Context context) {
        if(name.isEmpty()){
            nameInputLayout.setError(context.getString(R.string.this_field_is_required));
            nameInputLayout.setErrorEnabled(true);
            nameET.requestFocus();
            return false;
        }
        nameInputLayout.setError(null);
        nameInputLayout.setErrorEnabled(false);
        return true;
    }
}
