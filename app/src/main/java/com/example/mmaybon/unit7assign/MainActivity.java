package com.example.mmaybon.unit7assign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText lengthText;
    EditText widthText;
    TextView tvExam;
    private static final int CIS3334_REQUEST_CODE = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lengthText = (EditText) findViewById(R.id.length_text);
        widthText = (EditText) findViewById(R.id.width_text);
        tvExam = (TextView) findViewById(R.id.tvExam);

    }



    public void onExample(View view) {

        Double length = Double.parseDouble( lengthText.getText().toString());
        Double width = Double.parseDouble( widthText.getText().toString());
        Intent secActIntent = new Intent(this, SecondActivity.class);
        secActIntent.putExtra("MainName", length);
        secActIntent.putExtra("MainNumber", width);
        //startActivity(secActIntent)     // if no result is returned
        startActivityForResult(secActIntent, CIS3334_REQUEST_CODE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == CIS3334_REQUEST_CODE) {
            if (data.hasExtra("NewName")) {
                String result = data.getExtras().getString("NewName");
                if (result != null && result.length() > 0) {
                    tvExam.setText("New name : " + result);
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
    }