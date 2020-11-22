package com.example.shooting_birds;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.shootingbirds.R;

public class Background {

    int x=0;
    int y=0;
    Bitmap background;

    Background(int screenX, int screenY, Resources res){

        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }
}
