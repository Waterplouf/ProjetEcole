package com.porte_ouverte.projetecole.Play;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.porte_ouverte.projetecole.R;

/**
 * Created by Nicolas on 29.11.2016.
 */

public class Starship extends ImageView {


    public Starship(Context context) {
        super(context);
        setImageResource(R.drawable.vaisseau);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100,200);
        setLayoutParams(params);
    }

}
