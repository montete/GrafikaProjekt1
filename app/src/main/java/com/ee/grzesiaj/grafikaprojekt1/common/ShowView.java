package com.ee.grzesiaj.grafikaprojekt1.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.view.View;
import android.util.AttributeSet;
import android.widget.Button;

import com.ee.grzesiaj.grafikaprojekt1.R;
import com.ee.grzesiaj.grafikaprojekt1.to.Point2D;
import com.ee.grzesiaj.grafikaprojekt1.to.Vector;

import java.io.InputStream;
import java.util.ArrayList;



public class ShowView extends View {


    private ArrayList<Vector<Point2D>> vectorsList;

    public Camera getKamera() {
        return kamera;
    }
    private Paint nib = new Paint();
    //private static ShowView instance = null;
    private Camera kamera;
/*    public static ShowView getInstance() {
        if (instance == null)
            instance = new ShowView();
            instance.setVectorList(new ArrayList<Vector<Point2D>>());
        return instance;
    }*/

    public ShowView(Context context) {
        super(context);
        this.setVectorsList(new ArrayList<Vector<Point2D>>());
        setup();
    }
    public ShowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup();
    }
    void setup() {
        this.kamera = Camera.getInstance();
        kamera.setShowPanel(this);
        InputStream is = this.getResources().openRawResource(R.raw.mapa);
        WKUtils.MAPA = WKUtils.wczytajMape(is);
        kamera.setVectorsList(WKUtils.MAPA);
        this.setVectorsList(WKUtils.getVector2DList());
        //for(int i =0;i<3;i++) kamera.rotateDown();



        }
    @Override
    protected void onDraw(Canvas canvas){
        this.nib.setColor(Color.BLUE);
        //System.out.println("rysuje moze " + vectorsList.size());
        for (Vector<Point2D> v : vectorsList) {
            //System.out.println("wczytuje" + v);
            canvas.drawLine(v.getA().getX(), v.getA().getY(), v.getB().getX(), v.getB().getY(), nib);
        }

    }



    public ArrayList<Vector<Point2D>> getVectorsList() {
        return vectorsList;
    }

    public void setVectorsList(ArrayList<Vector<Point2D>> vectorsList) {
        this.vectorsList = vectorsList;
    }

}

