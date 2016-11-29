package com.porte_ouverte.projetecole;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import com.porte_ouverte.projetecole.*;
import com.porte_ouverte.projetecole.Play.PlayActivity;

// Utiliser une "frame" fixe dans la frame de base
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //appelle l'activité PlayActivity
        Intent playActivity = new Intent(this, PlayActivity.class);
        startActivity(playActivity);


    }

}
