package com.porte_ouverte.projetecole.Play;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import com.porte_ouverte.projetecole.*;

import java.util.HashMap;

import static com.porte_ouverte.projetecole.Utils.Helper.getScreenHeight;
import static com.porte_ouverte.projetecole.Utils.Helper.getScreenWidth;


public class PlayActivity extends AppCompatActivity {

    private static final String TAG = PlayActivity.class.getSimpleName();

    private ViewGroup mContentView;
    private int screenWidthWithMargin;
    private HashMap<Integer, Lane> listLanes = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        getWindow().setBackgroundDrawableResource(R.drawable.space_background);
        mContentView = (ViewGroup) findViewById(R.id.activity_play);
        screenWidthWithMargin = getScreenWidth() - 100;
        //avant de prendre les dimensions de l'écran, on doit s'assurer que l'écran est en FullScreen
        //et on rajoute un global listener pour s'assurer qu'on reçoive les bonnes valeurs au bon moment
        setToFullScreen();

        Log.d(TAG, "WIDTH 3 :" + String.valueOf(getScreenWidth()));
        Log.d(TAG, "hEIGHT 3 :" + String.valueOf(getScreenHeight()));



    //permet a l'utilisateur de remettre le fullscreen
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

    protected void placeLanes(int nbrLanes) {
       for(int i = 1; i<= nbrLanes; i++) {
           Lane lane = new Lane(this, screenWidthWithMargin, i, nbrLanes);
           setContentView(lane);
           listLanes.put(i, lane);

           Log.d(TAG, "HHH LEFT " + String.valueOf(lane.getLeftPX()));
           Log.d(TAG, "HHH CENTER  "+ String.valueOf(lane.getCenterPX()));
           Log.d(TAG, "HHH RIGHT  " + String.valueOf(lane.getRightPX()));
       }
    }

    //    method pour mettre en full screen
    protected void setToFullScreen() {
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

}
