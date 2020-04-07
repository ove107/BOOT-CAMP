package com.example.jetpackexercise1;

import android.graphics.Color;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class RandomColorGenerator extends ViewModel {
public int colour;
 public static boolean generated = false;
    public RandomColorGenerator() {
        super();
    }

    @Override
    protected void onCleared() {

        super.onCleared();
    }

    public int getColour(){
        if(!generated)
            colour=ColorGenerate();

        return colour;
    }

    public int ColorGenerate(){
        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
      //  generated=true;
        return color;
    }

}
