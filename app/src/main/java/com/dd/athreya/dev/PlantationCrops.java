package com.dd.athreya.dev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PlantationCrops extends AppCompatActivity {
    ListView list;
    ListViewAdapter adapter;
    String[] Version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantation_crops);
        Version=new String[] { "Coffee","Coconut","Tea","Rubber"};
        list=(ListView)findViewById(R.id.listView);
        adapter=new ListViewAdapter(this,Version);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,long id){
                switch(position){
                    case 0:
                        Intent i=new Intent(getApplicationContext(),Coffee.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i1=new Intent(getApplicationContext(),Coconut.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2=new Intent(getApplicationContext(),Tea.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3=new Intent(getApplicationContext(),Rubber.class);
                        startActivity(i3);
                        break;
                }

            }
        } );

    }
}
