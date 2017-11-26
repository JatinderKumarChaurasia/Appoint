package Helpers;

import android.app.Activity;
import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Jatinder Kumar on 02-11-2017.
 */

public class InputValidation {

    private Context context;

    public InputValidation(Context context) {
        this.context = context;
    }

    public boolean isInputEditTextFilled(EditText textInputEditText, String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()) {
            textInputEditText.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }

        return true;
    }
    public boolean isInputEditTextEmail(EditText textInputEditText,String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputEditText.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }
        return true;
    }
    public  boolean isInputEditTextUserName(EditText textInputEditText,String message)
    {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputEditText.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }
        return true;
    }
    public  boolean isInputEditTextPhone(EditText textInputEditText,String message)
    {
        String value =textInputEditText.getText().toString().trim() ;
        if (value.isEmpty()|| !Patterns.PHONE.matcher(value).matches()) {
            textInputEditText.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }
        return  true;

    }

    public boolean isInputEditTextMatches(EditText textInputEditText1, EditText textInputEditText2, String message) {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            textInputEditText1.setError(message);
            textInputEditText2.setError( message );
            hideKeyboardFrom(textInputEditText2);
            return false;

        }
        return true;
    }

    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService( Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
