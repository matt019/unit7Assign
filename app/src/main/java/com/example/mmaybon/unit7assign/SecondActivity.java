package com.example.mmaybon.unit7assign;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;

/**
 * Created by mmaybon on 4/1/2017.
 */

public class SecondActivity extends AppCompatActivity {

    TextView resultView;
    Double width;
    Double length;
    Double area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        resultView = (TextView) findViewById(R.id.result_text);

        Bundle extras = getIntent().getExtras();
        width = extras.getDouble("MainNumber");
        length = extras.getDouble("MainName");4
        area = width * length;
        resultView.setText("Width is " + width + " and length is " + length + " and flooring needed is " + area);


    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("NewName", length + "@css.edu");
        intent.putExtra("NewNum", width * 2);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
