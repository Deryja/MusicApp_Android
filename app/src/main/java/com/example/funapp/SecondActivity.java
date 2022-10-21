package com.example.funapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //Hvordan skrive videre/gjøre ting videre fra den forrige aktiviteten
        Intent caller = getIntent();

        float rating = caller.getFloatExtra("nbStars", 0);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Thank you for listening to this song, you rated it "+ rating + " stars ");





        //Begynner her

        final ImageView imageView_large = (ImageView) findViewById(R.id.imageView_large);
        imageView_large.setImageResource(R.drawable.img2);


        SeekBar tuner = (SeekBar) findViewById(R.id.seekBar_tuner);






        tuner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            int lastProgress;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lastProgress = progress;


            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                imageView_large.setColorFilter(Color.argb(100, 0, lastProgress, 255-lastProgress));

            }
        });













    }
}