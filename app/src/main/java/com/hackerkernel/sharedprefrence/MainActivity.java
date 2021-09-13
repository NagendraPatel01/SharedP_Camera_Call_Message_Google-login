package com.hackerkernel.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        btn=findViewById(R.id.btn);


        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);


        String channel=sharedPreferences.getString("name","");
        Log.d("drftytrewrt", "fghgfdfg: "+channel);
        String channel1=sharedPreferences.getString("phone no","");
        Log.d("dfghjhgfghj", "xcvbdfgbfg: "+channel1);

/*
        if(channel != null){

            Intent intent=new Intent(MainActivity.this,ShowActivity.class);
            startActivity(intent);


        }*/




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // edit2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

                if (edit1.getText().toString().length()==0) {
                    Toast.makeText(MainActivity.this, "please ener valid data", Toast.LENGTH_SHORT).show();
                }else if (edit2.getText().toString().length()==0) {
                    Toast.makeText(MainActivity.this, "please enter valid data", Toast.LENGTH_SHORT).show();
                }else {

                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("name",edit1.getText().toString());
                    editor.putString("phone no",edit2.getText().toString());
                    editor.commit();


                    Toast.makeText(MainActivity.this, "submit succesfully", Toast.LENGTH_SHORT).show();


                    Intent intent=new Intent(MainActivity.this,ShowActivity.class);
                    startActivity(intent);

                    finish();
                }


            }
        });
    }
}