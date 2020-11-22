package com.example.shooting_birds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shootingbirds.R;

public class MainActivity extends AppCompatActivity {

    private boolean isMute;
    ImageView volumCtrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });


        TextView highScoreTxt = findViewById(R.id.highScoreText);

        final SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        highScoreTxt.setText("HighScore: " + prefs.getInt("highscore", 0));


       isMute=  prefs.getBoolean("isMute",false);

         volumCtrl = findViewById(R.id.volumeCtrl);

        if(isMute){
            volumCtrl.setImageResource(R.drawable.ic_baseline_volume_off_24);
        }else{
            volumCtrl.setImageResource(R.drawable.ic_baseline_volume_up_24);
        }


        volumCtrl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                isMute=!isMute;

                if(isMute){
                    volumCtrl.setImageResource(R.drawable.ic_baseline_volume_off_24);
                }else{
                    volumCtrl.setImageResource(R.drawable.ic_baseline_volume_up_24);
                }


                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute",isMute);
                editor.apply();
            }
        });

    }
}