package com.example.horoscopeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String [] times = {"yesterday", "today", "tomorrow"};
    private AutoCompleteTextView autoCompleteTextView;
    private ArrayAdapter<String> stringArrayAdapter;
    private String horoscope;
    private String time;
    private String timesFor;
    private CardView capricornBtn, aquariusBtn, piscesBtn, ariesBtn, taurusBtn, geminiBtn, cancerBtn,
            leoBtn, virgoBtn, libraBtn, scorpioBtn, sagittariusBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        capricornBtn = findViewById(R.id.capricornBtn);
        aquariusBtn = findViewById(R.id.aquariusBtn);
        piscesBtn = findViewById(R.id.piscesBtn);
        ariesBtn = findViewById(R.id.ariesBtn);
        taurusBtn = findViewById(R.id.taurusBtn);
        geminiBtn = findViewById(R.id.geminiBtn);
        cancerBtn = findViewById(R.id.cancerBtn);
        leoBtn = findViewById(R.id.leoBtn);
        virgoBtn = findViewById(R.id.virgoBtn);
        libraBtn = findViewById(R.id.libraBtn);
        scorpioBtn = findViewById(R.id.scorpioBtn);
        sagittariusBtn = findViewById(R.id.sagittariusBtn);

        capricornBtn.setOnClickListener(this);
        aquariusBtn.setOnClickListener(this);
        piscesBtn.setOnClickListener(this);
        ariesBtn.setOnClickListener(this);
        taurusBtn.setOnClickListener(this);
        geminiBtn.setOnClickListener(this);
        cancerBtn.setOnClickListener(this);
        leoBtn.setOnClickListener(this);
        virgoBtn.setOnClickListener(this);
        libraBtn.setOnClickListener(this);
        scorpioBtn.setOnClickListener(this);
        sagittariusBtn.setOnClickListener(this);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.list_time, times);
        autoCompleteTextView.setAdapter(stringArrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                time = parent.getItemAtPosition(position).toString();
                timesFor = time;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.capricornBtn:
                horoscope = "capricorn";
                showValue(time,horoscope);
                break;
            case R.id.aquariusBtn:
                horoscope = "aquarius";
                showValue(time,horoscope);
                break;
            case R.id.piscesBtn:
                horoscope = "pisces";
                showValue(time,horoscope);
                break;
            case R.id.ariesBtn:
                horoscope = "aries";
                showValue(time,horoscope);
                break;
            case R.id.taurusBtn:
                horoscope = "taurus";
                showValue(time,horoscope);
                break;
            case R.id.geminiBtn:
                horoscope = "gemini";
                showValue(time,horoscope);
                break;
            case R.id.cancerBtn:
                horoscope = "cancer";
                showValue(time,horoscope);
                break;
            case R.id.leoBtn:
                horoscope = "leo";
                showValue(time,horoscope);
                break;
            case R.id.virgoBtn:
                horoscope = "virgo";
                showValue(time,horoscope);
                break;
            case R.id.libraBtn:
                horoscope = "libra";
                showValue(time,horoscope);
                break;
            case R.id.scorpioBtn:
                horoscope = "scorpio";
                showValue(time,horoscope);
                break;
            case R.id.sagittariusBtn:
                horoscope = "sagittarius";
                showValue(time,horoscope);
                break;
        }
    }

    private void showValue(String time, String horo) {
//        intent = new Intent(this,HorscopeDaily.class);
//        intent.putExtra("horo", horoscope);
//        intent.putExtra("time", time);
//        startActivity(intent);
        if (time == null) {
            Toast.makeText(this, "Please chose time", Toast.LENGTH_SHORT).show();
        } else {
            intent = new Intent(this,HorscopeDaily.class);
            intent.putExtra("horo", horoscope);
            intent.putExtra("time", time);
            startActivity(intent);
        }
    }
}