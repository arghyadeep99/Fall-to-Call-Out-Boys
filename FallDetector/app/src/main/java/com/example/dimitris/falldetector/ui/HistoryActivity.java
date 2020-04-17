package com.example.dimitris.falldetector.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dimitris.falldetector.Constants;
import com.example.dimitris.falldetector.R;

public class HistoryActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mTextView =  (TextView) findViewById(R.id.history_entries);

        // retieve history from shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.MyPREFERENCES, Context.MODE_PRIVATE);
        String history = sharedPreferences.getString(Constants.History,null);
        // set mTextView
        mTextView.setText(history);

        mButton = (Button) findViewById(R.id.history_btn_clear);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // clear shared preferences history key
                SharedPreferences sharedPreferences = getSharedPreferences(Constants.MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Constants.History, "");
                editor.commit();
                // clear mTextView
                mTextView.setText("");

            }
        });
    }
}
