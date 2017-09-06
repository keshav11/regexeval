package com.regexapp.regexeval;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.PatternSyntaxException;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button checkButton = (android.widget.Button)findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText regex = (EditText) findViewById(R.id.regex);
                String regexString = regex.getText().toString();
                Log.d("LOG", regexString);
                EditText toCheck = (EditText) findViewById(R.id.stringcheck);
                String stringToCheck = toCheck.getText().toString();
                Log.d("LOG", stringToCheck);
                TextView result = (TextView) findViewById(R.id.result);
                try {
                    if(stringToCheck.matches(regexString)) {
                        result.setText("Match!");
                        result.setTextColor(Color.GREEN);
                    }
                    else {
                        result.setText("Match failed.");
                        result.setTextColor(Color.RED);
                    }
                }
                catch (PatternSyntaxException e) {
                    Toast.makeText(MainActivity.this,
                            "Regular Expression not valid. Please check.", Toast.LENGTH_SHORT).show();
                }


            }
        });
        //mTextMessage = (TextView) findViewById(R.id.message);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
