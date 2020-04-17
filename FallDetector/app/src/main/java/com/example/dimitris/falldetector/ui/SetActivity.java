package com.example.dimitris.falldetector.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dimitris.falldetector.Constants;
import com.example.dimitris.falldetector.R;

public class SetActivity extends AppCompatActivity {

    public static final String TAG = "SetActivity";

    private EditText mEditTextCode;
    private EditText mEditTextPhoneNumber;
    private Button mBttnDone;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        mEditTextCode = (EditText) findViewById(R.id.et_country_code);
        mEditTextPhoneNumber = (EditText) findViewById(R.id.et_phone_number);

        sharedPreferences = getSharedPreferences(Constants.MyPREFERENCES, Context.MODE_PRIVATE);

        // use last contact's data
        String ph = sharedPreferences.getString(Constants.Phone,null);
        String c = sharedPreferences.getString(Constants.Code,null);
        if (ph!= null && c != null){
            mEditTextPhoneNumber.setText(ph);
            mEditTextCode.setText(c);
        }

        mBttnDone = (Button)    findViewById(R.id.bttn_done);
        mBttnDone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    String countryCode = mEditTextCode.getText().toString();
                    String phoneNumber = mEditTextPhoneNumber.getText().toString();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Constants.Code, countryCode);
                    editor.putString(Constants.Phone, phoneNumber);
                    editor.commit();


                    Log.d(TAG, "country code: "+countryCode+" phone number: "+phoneNumber);
                    String contact = "+" + countryCode + " " + phoneNumber;
                    Toast.makeText(getApplicationContext(), "Contact " + contact + " saved.", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Log.e(TAG, "onClick: error during setting code or phone number");
                    Toast.makeText(getApplicationContext(), "Error during initializing contact", Toast.LENGTH_LONG).show();
                }

                // go back to previous activity
                finish();

            }
        });
    }


}
