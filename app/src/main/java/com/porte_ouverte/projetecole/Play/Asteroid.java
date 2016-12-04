package com.porte_ouverte.projetecole.Play;

/**
 * Created by Damien on 04.12.2016.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

class Asteroid
{
    private BitmapDrawable img=null; // image de l'asteroid
    private int x,y; // coordonnées x,y de l'asteroid en pixel
    private int asteroidW, asteroidH; // largeur et hauteur de l'asteroid en pixels
    private int wEcran,hEcran; // largeur et hauteur de l'écran en pixels
    private int fallSpeed; // Vitesse de déplacement sur l'axe Y

    // contexte de l'application Android
    // il servira à accéder aux ressources, dont l'image de la balle
    private final Context mContext;


    // Constructeur de l'objet "Asteroid"
    public Asteroid(final Context c, int x, int y, int fallSpeed)
    {
        this.x = x;
        this.y = y;
        this.fallSpeed = fallSpeed;
        mContext=c; // sauvegarde du contexte
    }

    // on attribue à l'objet "Asteroid" l'image passée en paramètre
    // w et h sont sa largeur et hauteur définis en pixels
    public BitmapDrawable setImage(final Context c, final int ressource, final int w, final int h)
    {
        Drawable dr = c.getResources().getDrawable(ressource);
        Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
        return new BitmapDrawable(c.getResources(), Bitmap.createScaledBitmap(bitmap, w, h, true));
    }

    // redimensionnement de l'image selon la largeur/hauteur de l'écran passés en paramètre
    public void resize(int wScreen, int hScreen) {
        // wScreen et hScreen sont la largeur et la hauteur de l'écran en pixel
        // on sauve ces informations en variable globale, car elles serviront
        // à détecter les collisions sur les bords de l'écran
        wEcran=wScreen;
        hEcran=hScreen;

        // on définit (au choix) la taille de la balle à 1/5ème de la largeur de l'écran
        asteroidW=wScreen/5;
        asteroidH=wScreen/5;
        img = setImage(mContext,R.mipmap.asteroid,asteroidW,asteroidH);
    }

    // Getters & Setters
    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getAsteroidW() {
        return asteroidW;
    }


    public int getAsteroidH() {
        return asteroidH;
    }

    public void moveAsteroid() {
        // L'asteroid se déplace à la vitesse speedY
        y+=fallSpeed;
    }

    // on dessine la balle, en x et y
    public void draw(Canvas canvas) {
        if(img==null) {return;}
        canvas.drawBitmap(img.getBitmap(), x, y, null);
    }

} // public class Asteroid
