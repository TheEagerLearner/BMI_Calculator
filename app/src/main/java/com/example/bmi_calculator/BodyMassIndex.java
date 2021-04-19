package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BodyMassIndex extends AppCompatActivity {

    TextView bmival;
    Button recall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_mass_index);
        bmival=findViewById(R.id.bmival);
        recall=findViewById(R.id.btnRecal);

        Intent i = getIntent();
        float bmi=i.getFloatExtra("bmi",0);
        bmival.setText(String.valueOf(bmi));

        recall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BodyMassIndex.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}