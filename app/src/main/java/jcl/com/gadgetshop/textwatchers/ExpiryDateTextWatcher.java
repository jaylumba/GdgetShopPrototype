package jcl.com.gadgetshop.textwatchers;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by jayanthony.lumba on 3/10/2017.
 */

public class ExpiryDateTextWatcher implements TextWatcher {

    EditText editText;

    public ExpiryDateTextWatcher(EditText editText){
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String working = s.toString();
        boolean isValid = true;
        if (working.length()==2 && before ==0) {
            if (Integer.parseInt(working) < 1 || Integer.parseInt(working)>12) {
                isValid = false;
            } else {
                working+="/";
                editText.setText(working);
                editText.setSelection(working.length());
            }
        }
        else if (working.length()==5 && before ==0) {
            String enteredYear = working.substring(3);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            String currentYearStr = String.valueOf(currentYear).substring(0,2);
            currentYear = Integer.parseInt(currentYearStr);
            if (Integer.parseInt(enteredYear) < currentYear) {
                isValid = false;
            }
        } else if (working.length()!=5) {
            isValid = false;
        }

        if (!isValid) {
            editText.setError("Enter a valid expiry date: MM/YY");
        } else {
            editText.setError(null);
        }

    }

    @Override
    public void afterTextChanged(Editable s)  {

    }
}
