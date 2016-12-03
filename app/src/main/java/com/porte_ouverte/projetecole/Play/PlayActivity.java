package com.porte_ouverte.projetecole.Play;


import android.graphics.Color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import java.util.HashMap;
import com.porte_ouverte.projetecole.*;
import com.porte_ouverte.projetecole.Utils.Helper;


public class PlayActivity extends AppCompatActivity {

    private static final String TAG = PlayActivity.class.getSimpleName();

    private ViewGroup mContentView;
    private int screenWidthWithMargin;
    private HashMap<Integer, Lane> listLanes = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        //We keep a reference to the whole screen (the frame_Layout is our main screen)
        mContentView = (ViewGroup) findViewById(R.id.frame_Layout);
        //for testing
        mContentView.setBackgroundColor(Color.BLUE);

        screenWidthWithMargin = Helper.getScreenWidth() - 100;
        //we set to fullscreen
        setToFullScreen();
        //for testing
        mContentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "HELLLLLLLLLLLLO");
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    Starship hello = new Starship(PlayActivity.this);
                    hello.setX(event.getX());
                    hello.setY(event.getY());
                    mContentView.addView(hello);
                    Log.d(TAG, "HELLLLLLLLLLLLO");
                }
                return false;
            }
        });


    //the user has a way to put the screen back in fullscreen(just in case)
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setToFullScreen();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
         setToFullScreen();
         placeLanes(8);

    }
    //fonction creating the number of lane desired and keeping them in a HashMap for easy access
    protected void placeLanes(int nbrLanes) {

        for(int i = 1; i<= nbrLanes; i++) {
            //the Lanes keep track of their own center and border
           Lane lane = new Lane(this, screenWidthWithMargin, i, nbrLanes);
           //we add the lane to the mainScreen(debatable if useful or not ?)
            mContentView.addView(lane);
            //we keep the lanes in a HashMap
           listLanes.put(i, lane);
            //for testing
           Log.d(TAG, "HHH LEFT " + String.valueOf(lane.getLeftPX()));
           Log.d(TAG, "HHH CENTER  "+ String.valueOf(lane.getCenterPX()));
           Log.d(TAG, "HHH RIGHT  " + String.valueOf(lane.getRightPX()));
       }
    }

    //fonction for immersive fullscreen
    protected void setToFullScreen() {

        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

}
