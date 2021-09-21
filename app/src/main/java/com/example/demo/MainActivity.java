package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img1,img2;
    TextView tha,sur;

    Animation botmanim,roteat,zoomi;

    public static int SPLASH_TIME = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        botmanim = AnimationUtils.loadAnimation(this,R.anim.botam_anim);
        roteat = AnimationUtils.loadAnimation(this,R.anim.rotet);
        zoomi = AnimationUtils.loadAnimation(this,R.anim.zoomin);

        tha = findViewById(R.id.text1);
        sur = findViewById(R.id.text2);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

        tha.setAnimation(botmanim);
        sur.setAnimation(botmanim);
        img1.startAnimation(zoomi);
        img2.startAnimation(roteat);





        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, deshbord.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME);



    }
}