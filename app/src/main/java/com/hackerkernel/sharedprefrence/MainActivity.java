package com.hackerkernel.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

        if(sharedPreferences != null){

            Intent intent=new Intent(MainActivity.this,ShowActivity.class);
            startActivity(intent);

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",edit1.getText().toString());
                editor.putString("phone no",edit2.getText().toString());
                editor.commit();

                Toast.makeText(MainActivity.this, "submit succesfully", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
    }
}