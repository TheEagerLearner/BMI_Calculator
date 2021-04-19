package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    ImageView imgFemale,imgMale;
    Button btnCalculate,btnWAdd,btnASub,btnWSub,btnAAdd;
    TextView txtHeightValue,txtWeightValue,txtAgeValue;
    SeekBar sliderHeight;

    int gender=0;
    float weight=0;
    int age=0;
    float height=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing
        imgFemale=findViewById(R.id.imgFemale);
        imgMale=findViewById(R.id.imgMale);

        btnCalculate=findViewById(R.id.btnCalculate);
        btnAAdd=findViewById(R.id.btnAAdd);
        btnASub=findViewById(R.id.btnASub);
        btnWAdd=findViewById(R.id.btnWAdd);
        btnWSub=findViewById(R.id.btnWSub);

        txtAgeValue=findViewById(R.id.txtAgeValue);
        txtHeightValue=findViewById(R.id.txtHeightValue);
        txtWeightValue=findViewById(R.id.txtWeightValue);

        sliderHeight=findViewById(R.id.sliderHeight);

        imgFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgFemale.setImageResource(R.drawable.ic_clickedfemale);
                imgMale.setImageResource(R.drawable.ic_unclickedmale);
                gender=1;
            }
        });


        imgMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgMale.setImageResource(R.drawable.ic_clickedmale);
                imgFemale.setImageResource(R.drawable.ic_unclickedfemale);
                gender=2;
            }
        });

        sliderHeight.setOnSeekBarChangeListener(seek);

        btnWAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight=weight+1;
                txtWeightValue.setText(String.valueOf(weight));

            }
        });

        btnWSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weight > 0) {
                    weight = weight - 1;
                    txtWeightValue.setText(String.valueOf(weight));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"How Come your weight is in negative ? Consult a Doctor Directly",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age=age+1;
                txtAgeValue.setText(String.valueOf(age));

            }
        });

        btnASub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (age > 0) {
                    age = age - 1;
                    txtAgeValue.setText(String.valueOf(age));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"How Come your Age is in negative ? Consult a Doctor Directly",Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if(weight>0 && gender!=0)
                {
                    height=height/100;
                    height=height*height;
                    float bmi=weight/height;
                    if(bmi>=18.5 && bmi <24.9)
                    {
                        intent=new Intent(MainActivity.this,BodyMassIndex.class);
                        intent.putExtra("bmi",bmi);

                    }
                    else
                    {
                        intent=new Intent(MainActivity.this,danger.class);
                        intent.putExtra("bmi",bmi);
                    }
                    startActivity(intent);
                    finish();

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please Enter your details properly",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    SeekBar.OnSeekBarChangeListener seek=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            txtHeightValue.setText(String.valueOf(i)+"cm");
            height=i;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}