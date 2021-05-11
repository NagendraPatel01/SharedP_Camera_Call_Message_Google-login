package com.hackerkernel.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {

    EditText edit;
    Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        edit=findViewById(R.id.edit);
        btn=findViewById(R.id.btn);
        btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(CallActivity.this,CameraActivity.class);
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int permissionCheck = ContextCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE);
              if (permissionCheck != PackageManager.PERMISSION_GRANTED){

                  ActivityCompat.requestPermissions(
                          CallActivity.this,
                          new String[]{Manifest.permission.CALL_PHONE},
                          Integer.parseInt("123"));
              }

              else {

                  String number=edit.getText().toString();

                  Intent intent=new Intent(Intent.ACTION_CALL);
                  intent.setData(Uri.parse("tel:"+number));
                  startActivity(intent);
              }
            }
        });
    }
}