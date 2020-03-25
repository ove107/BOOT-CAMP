package com.example.android_storage_part_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText ed;
TextView tv;
Button b1,b2;
String s;
SharedPreferences sp;
public static final String MyPrefs = "My preferences";
public static final String input = "input key";
public static final String display = "display key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = (EditText)findViewById(R.id.input);
        tv = (TextView)findViewById(R.id.display);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        sp =getSharedPreferences(MyPrefs,MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
         s= ed.getText().toString();
         SharedPreferences.Editor edit = sp.edit();
         edit.putString(display,s);
         edit.apply();
         edit.commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=sp.getString(display,"NO DATA ENTERED");
                tv.setText(s);
            }
        });
    }

}
