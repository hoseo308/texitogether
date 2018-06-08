package com.example.alchemist.last_pj;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSignin;
    TextView textID, textPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignin = (Button) findViewById(R.id.btnSignin);

        textID = (TextView) findViewById(R.id.textID);
        textPW = (TextView) findViewById(R.id.textPW);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/BMJUA.ttf");
        textID.setTypeface(typeFace);
        textPW.setTypeface(typeFace);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sign_inActivity.class);

                startActivity(intent);

            }
        });
    }
}
