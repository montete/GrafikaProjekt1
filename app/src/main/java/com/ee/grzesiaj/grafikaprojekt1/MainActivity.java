package com.ee.grzesiaj.grafikaprojekt1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ee.grzesiaj.grafikaprojekt1.common.Camera;
import com.ee.grzesiaj.grafikaprojekt1.common.ShowView;

public class MainActivity extends AppCompatActivity {

    //zoom
    private Button zoomin= null;
    private Button zoomout= null;
    //translacka
    private Button transleft=null;
    private Button transup=null;
    private Button transforward=null;
    private Button transbackward=null;
    private Button transdown=null;
    private Button transright=null;
    //obracanie
    private Button obrlewo=null;
    private Button przechyllewo=null;
    private Button obrup=null;
    private Button obrdown=null;
    private Button przechylprawo=null;
    private Button obrprawo=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //zoomin
        this.zoomin = (Button)findViewById(R.id.zoom1);
        View.OnClickListener zoomInLis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().zoomIn();
                System.out.println("wypisz");
            }


        };
        this.zoomin.setOnClickListener(zoomInLis);

        //zoomout
        this.zoomout = (Button)findViewById(R.id.zoom2);
        View.OnClickListener zoomOutLis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().zoomOut();
                System.out.println("wypisz");
            }


        };
        this.zoomout.setOnClickListener(zoomOutLis);

        //transleft
        this.transleft = (Button)findViewById(R.id.left);
        View.OnClickListener transleftLis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().moveLeft();
                System.out.println("wypisz");
            }


        };
        this.transleft.setOnClickListener(transleftLis);

        //transup
        this.transup = (Button)findViewById(R.id.up);
        View.OnClickListener transupLis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().moveUp();
                System.out.println("wypisz");
            }


        };
        this.transup.setOnClickListener(transupLis);

        //tranforward
        this.transforward = (Button)findViewById(R.id.forward);
        View.OnClickListener tranforLis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().moveForward();
                System.out.println("wypisz");
            }


        };
        this.transforward.setOnClickListener(tranforLis);

        //tranbackward
        this.transbackward = (Button)findViewById(R.id.backward);
        View.OnClickListener transbackLis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().moveBack();
                System.out.println("wypisz");
            }


        };
        this.transbackward.setOnClickListener(transbackLis);

        //tranDOWN
        this.transdown = (Button)findViewById(R.id.down);
        View.OnClickListener transdownLis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().moveDown();
                System.out.println("wypisz");
            }


        };
       this.transdown.setOnClickListener(transdownLis);
        //tranright
        this.transright = (Button)findViewById(R.id.right);
        View.OnClickListener transrightLis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().moveRight();
                System.out.println("wypisz");
            }


        };
        this.transright.setOnClickListener(transrightLis);

        //obracanie

        //obroclewo
        this.obrlewo = (Button)findViewById(R.id.button);
        View.OnClickListener obrlewoLis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().rotateLeft();
                System.out.println("wypisz");
            }


        };
        this.obrlewo.setOnClickListener(obrlewoLis);

        //przechyllewo
        this.przechyllewo = (Button)findViewById(R.id.button2);
        View.OnClickListener przechlewlis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().rotateLeftZ();
                System.out.println("wypisz");
            }


        };
        this.przechyllewo.setOnClickListener(przechlewlis);

        //przechylup
        this.obrup = (Button)findViewById(R.id.button3);
        View.OnClickListener przechuplis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().rotateUp();
                System.out.println("wypisz");
            }


        };
        this.obrup.setOnClickListener(przechuplis);

        //przechyldown
        this.obrdown = (Button)findViewById(R.id.button4);
        View.OnClickListener przechdownlis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().rotateDown();
                System.out.println("wypisz");
            }


        };
        this.obrdown.setOnClickListener(przechdownlis);

        //przechylprawo
        this.przechylprawo = (Button)findViewById(R.id.button5);
        View.OnClickListener przechprawlis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().rotateRightZ();
                System.out.println("wypisz");
            }


        };
        this.przechylprawo.setOnClickListener(przechprawlis);

        //obrprawo
        this.obrprawo = (Button)findViewById(R.id.button6);
        View.OnClickListener obrprawlis = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowView wju = (ShowView)findViewById(R.id.view);
                wju.getKamera().rotateRight();
                System.out.println("wypisz");
            }


        };
        this.obrprawo.setOnClickListener(obrprawlis);

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
