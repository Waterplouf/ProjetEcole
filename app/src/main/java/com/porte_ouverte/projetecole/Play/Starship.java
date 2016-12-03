package com.porte_ouverte.projetecole.Play;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.renderscript.Sampler;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.porte_ouverte.projetecole.R;
import com.porte_ouverte.projetecole.Utils.Helper;

import java.util.HashMap;

/**
 * Created by Nicolas on 29.11.2016.
 */

public class Starship extends ImageView implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    private int centerPX;
    private Lane currentLane;
    private int screenWidth;
    private ValueAnimator shipMoveAnimation;

    public Starship(Context context, int screenWidth, HashMap<Integer, Lane> listLane) {
        super(context);
        setImageResource(R.drawable.vaisseau);
        this.screenWidth = screenWidth;
        //we take an arbitrary lane to start
        currentLane = listLane.get(2);
        //we calculate the width of the lane in px
        int laneWidth = currentLane.getRightPX() - currentLane.getLeftPX();
        //we set the size of the ship to be the same width as the lane
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(laneWidth,300);
        setLayoutParams(params);
        //we place our ship on the screen in the middle of lane 2
        centerPX = currentLane.getCenterPX() - laneWidth/2;
        setX(centerPX);
        setY(Helper.getScreenHeight() - 300);
    }
    public boolean switchLaneLeft(HashMap<Integer, Lane> listLane, int duration) {
        Lane leftLane = null;

        shipMoveAnimation = new ValueAnimator();
        shipMoveAnimation.setDuration(duration);
        try {
            leftLane = listLane.get(currentLane.getLaneNumber() - 1);
        }
        catch (Exception e){
            return false;
        }
        shipMoveAnimation.setFloatValues(currentLane.getCenterPX(), leftLane.getCenterPX());
        shipMoveAnimation.setInterpolator(new LinearInterpolator());
        shipMoveAnimation.setTarget(this);
        shipMoveAnimation.addListener(this);
        shipMoveAnimation.addUpdateListener(this);
        shipMoveAnimation.start();
        currentLane = leftLane;
        return true;
    }
    public boolean switchLaneRight(HashMap<Integer, Lane> listLane, int duration) {
        Lane rightLane = null;

        shipMoveAnimation = new ValueAnimator();
        shipMoveAnimation.setDuration(duration);
        try {
            rightLane = listLane.get(currentLane.getLaneNumber() + 1);

        }
        catch (Exception e){
            return false;
        }
        shipMoveAnimation.setFloatValues(currentLane.getCenterPX(), rightLane.getCenterPX());
        shipMoveAnimation.setInterpolator(new LinearInterpolator());
        shipMoveAnimation.setTarget(this);
        shipMoveAnimation.addListener(this);
        shipMoveAnimation.addUpdateListener(this);
        shipMoveAnimation.start();
        currentLane = rightLane;
        return true;

    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        setX((Float) shipMoveAnimation.getAnimatedValue());
    }
}
