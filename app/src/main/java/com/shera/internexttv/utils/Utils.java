package com.shera.internexttv.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class Utils {

    public static void setError(TextInputLayout textInputLayout, String errorData)
    {
        if(errorData!=null && !errorData.isEmpty())
        {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError(errorData);
        }
        else
        {
            textInputLayout.setErrorEnabled(false);
            textInputLayout.setError("");
        }
    }

    public static void setTextChangeListener(TextInputLayout textInputLayout, EditText editText)
    {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputLayout.setErrorEnabled(false);
                textInputLayout.setError("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
