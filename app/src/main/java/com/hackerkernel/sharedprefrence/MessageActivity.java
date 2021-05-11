package com.hackerkernel.sharedprefrence;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    EditText edit1,edit2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                        String[] permissions = {Manifest.permission.SEND_SMS};

                        requestPermissions(permissions, 1);

                    }
                }


                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)

                {

                    String number=edit1.getText().toString();
                    String sms=edit2.getText().toString();


                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(number, null, sms, null, null);

                        Toast.makeText(MessageActivity.this, "Message sent successfully", Toast.LENGTH_SHORT).show();
                    }

                    catch (Exception e)
                    {

                        e.printStackTrace();
                    }

                }

                else {

                    requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                }

            }


        });
    }
}