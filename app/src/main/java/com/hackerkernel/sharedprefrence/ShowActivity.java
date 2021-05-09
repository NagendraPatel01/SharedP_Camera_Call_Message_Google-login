package com.hackerkernel.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {

    TextView text1,text2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        btn=findViewById(R.id.btn);


        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);

        text1.setText(sharedPreferences.getString("name",""));
        text2.setText(sharedPreferences.getString("phone no",""));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();


                Toast.makeText(ShowActivity.this, "logout succesfull", Toast.LENGTH_SHORT).show();
            }

        });
    }
}