package com.porte_ouverte.projetecole.Play;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.ImageView;

/**
 * Created by Nicolas on 23.11.2016.
 */


//Taille d'une lane
public class Lane extends ImageView {
    private ShapeDrawable mDrawable;
    //Valeur en px du milieu de la lane sur l'écran
    private int centerPX;
    private int laneNumber; // number of the line (1 on the far left)
    private int maxLane; // total number of lanes
    private int screenWidth;

    public Lane(Context context, int screenWidth, int laneNumber, int maxLane) {
        super(context);
        this.screenWidth = screenWidth;
        this.laneNumber = laneNumber;
        this.maxLane = maxLane;
        centerPX = screenWidth / maxLane * laneNumber;

        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(0xff74AC23);
    }


    public int getCenterPX() {
        return centerPX;
    }

    public void setCenterPX(int centerPX) {
        this.centerPX = centerPX;
    }

    public int getLeftPX() {
        return (screenWidth/maxLane)*laneNumber - (screenWidth/6 * 45/100);
    }

    public int getRightPX() {
        return (screenWidth/maxLane)*laneNumber + (screenWidth/6 * 45/100);
    }

    protected void onDraw(Canvas canvas) {
        mDrawable.draw(canvas);
    }


}
