package com.dd.athreya.dev;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.Calendar;

public class Wheat extends AppCompatActivity {
    public CheckBox chck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheat);
        chck=(CheckBox) findViewById(R.id.checkBox);
        chck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    Toast.makeText(Wheat.this, "Notifications will be shown periodically hereafter for the cultivation of Wheat", Toast.LENGTH_SHORT).show();
                    NotificationCompat.BigPictureStyle big=new NotificationCompat.BigPictureStyle();
                    big.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.wheat)).build();
                    NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    Intent resultIntent=new Intent(getApplicationContext(),Wheat.class);
                    resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    PendingIntent piResult=PendingIntent.getActivity(getApplicationContext(),(int) Calendar.getInstance().getTimeInMillis(),resultIntent,0);
                    NotificationCompat.Builder builder=(NotificationCompat.Builder)new NotificationCompat.Builder(getApplicationContext())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Check the wheat activity")
                            .setContentText("Proud to be a Farmer")
                            .setStyle(big)
                            .addAction(R.drawable.show,"show activity",piResult)
                            .addAction(R.drawable.show,"Share",PendingIntent.getActivity(getApplicationContext(),0,getIntent(),0,null));
                    notificationManager.notify(0,builder.build());


                }

            }
        });
        Button contact=(Button)findViewById(R.id.button);
        if (contact != null) {
            contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Intent i=new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:+918438308535"));
                    if(ActivityCompat.checkSelfPermission(Wheat.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(i);
                }
            });
        }

    }

}

