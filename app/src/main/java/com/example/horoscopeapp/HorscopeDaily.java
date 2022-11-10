package com.example.horoscopeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HorscopeDaily extends AppCompatActivity {

    private String horoscope;
    private String time;
    private String url;
    private String tempUrl;
    private TextView horoName, horoDate, horoComp, horoMood, horoColor, horoNum, horoTime, horoDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horscope_daily);
        horoName = findViewById(R.id.horoName);
        horoDate = findViewById(R.id.horoDate);
        horoComp = findViewById(R.id.horoComp);
        horoMood = findViewById(R.id.horoMood);
        horoColor = findViewById(R.id.horoColor);
        horoNum = findViewById(R.id.horoNum);
        horoTime = findViewById(R.id.horoTime);
        horoDesc = findViewById(R.id.horoDesc);

        url = "https://aztro.sameerkumar.website?sign=";


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        horoscope = getIntent().getStringExtra("horo");
        time = getIntent().getStringExtra("time");
        tempUrl = url + horoscope + "&day=" + time;


        StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl.toString(), new Response.Listener<String>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    horoName.setText( horoscope.toUpperCase() + "\n" +jsonObject.getString("date_range"));
                    horoComp.setText(jsonObject.getString("compatibility"));
                    horoDate.setText(jsonObject.getString("current_date"));
                    horoColor.setText(jsonObject.getString("color"));
                    horoMood.setText(jsonObject.getString("mood"));
                    horoNum.setText(jsonObject.getString("lucky_number"));
                    horoTime.setText(jsonObject.getString("lucky_time"));
                    horoDesc.setText(jsonObject.getString("description"));

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(HorscopeDaily.this, "ERROR " + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HorscopeDaily.this, "ERROR " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);

    }
}