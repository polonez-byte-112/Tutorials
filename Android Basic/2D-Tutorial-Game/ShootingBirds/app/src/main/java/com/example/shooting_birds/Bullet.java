package com.example.shooting_birds;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.shootingbirds.R;

import static com.example.shooting_birds.GameView.screenRatioX;
import static com.example.shooting_birds.GameView.screenRatioY;

public class Bullet {

    int x,y;
    Bitmap bullet;
    int height;
    int width;
    Bullet(Resources res){
        bullet= BitmapFactory.decodeResource(res, R.drawable.bullet);
        width=bullet.getWidth();
         height = bullet.getHeight();

        width /=4;
        height /=4;

        width= (int) (width* screenRatioX);
        height= (int) (height * screenRatioY);

        bullet=Bitmap.createScaledBitmap(bullet,width,height,false);

    }

    Rect getCollisionShape(){
        return new Rect(x,y, x+width, y+height);
    }
}
