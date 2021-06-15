package com.example.growify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int DELAY = 700;

    //variables
    Animation logoAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change colour of status bar
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.grey,getTheme()));


        //animation
        logoAnim = AnimationUtils.loadAnimation(this,R.anim.spashscreen_anim);

        //Logo
        TextView logo = findViewById(R.id.logo);
        Shader shader = new LinearGradient(0f, 0f, 0f, logo.getTextSize(), Color.parseColor("#30cfd0"), Color.parseColor("#330867"), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        logo.getPaint().setShader(shader);
        logo.setAnimation(logoAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },DELAY);

        //

    }
}