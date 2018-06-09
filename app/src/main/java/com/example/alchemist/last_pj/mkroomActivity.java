package com.example.alchemist.last_pj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ggyoz on 2018-06-08.
 */

public class mkroomActivity extends AppCompatActivity {
EditText roomName, departure, destination;
Button cancelbtn, mkroombtn;

List<RoomInfo> info = new ArrayList<>();


private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
private DatabaseReference databaseReference = firebaseDatabase.getReference("RoomInfo");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mkroom);


        roomName = (EditText) findViewById(R.id.roomName);
        departure = (EditText) findViewById(R.id.departure);
        destination = (EditText) findViewById(R.id.destination);

        mkroombtn = (Button) findViewById(R.id.btnmkroom);
        mkroombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Rname = roomName.getText().toString();
                String Departure = departure.getText().toString();
                String Destination = destination.getText().toString();

                String key = databaseReference.push().getKey();

                Map<String,String> postValues = new HashMap<>();
                postValues.put("Rname", Rname);
                postValues.put("Departure", Departure);
                postValues.put("Destination", Destination);

                DatabaseReference keyRef = databaseReference.child(key);
                keyRef.setValue(postValues);
            }
        });

        cancelbtn = (Button) findViewById(R.id.btncancel);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mkroomActivity.this, RoomListActivity.class);
                startActivity(intent);
            }
        });


    }

    public class RoomInfo {

        public String roomname;
        public String departure;
        public String destination;

        public RoomInfo(String roomname, String departure, String destination){
            this.roomname = roomname;
            this.departure = departure;
            this.destination = destination;
        }
    }



}
