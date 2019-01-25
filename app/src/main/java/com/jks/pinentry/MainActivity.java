package com.jks.pinentry;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Context sContext;
    EditText otpET1, otpET2, otpET3, otpET4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sContext = MainActivity.this;

        otpET1 = findViewById(R.id.otpET1);
        otpET2 = findViewById(R.id.otpET2);
        otpET3 = findViewById(R.id.otpET3);
        otpET4 = findViewById(R.id.otpET4);
        checkPin(otpET1, otpET2);
        checkPin(otpET2, otpET3);
        checkPin(otpET3, otpET4);
        checkPin(otpET4, otpET4);


        otpET2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    otpET1.requestFocus();
                    otpET1.setText("");
                }
                return false;
            }
        });
        otpET3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    otpET2.requestFocus();
                    otpET2.setText("");
                }
                return false;
            }
        });
        otpET4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    if (otpET4.getText().toString().equals("")) {
                        otpET3.requestFocus();
                        otpET3.setText("");
                    } else {
                        otpET4.requestFocus();
                        otpET4.setText("");
                    }

                }
                return false;
            }
        });

    }

    public void checkPin(final EditText editText, final EditText editText1) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editText.getText().toString().length() == 1) {
                    editText1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
