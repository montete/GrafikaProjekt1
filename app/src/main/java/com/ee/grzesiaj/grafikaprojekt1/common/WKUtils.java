package com.ee.grzesiaj.grafikaprojekt1.common;


import com.ee.grzesiaj.grafikaprojekt1.to.Point3D;
import com.ee.grzesiaj.grafikaprojekt1.to.Vector;
import com.ee.grzesiaj.grafikaprojekt1.to.Point2D;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WKUtils {
    public static final int STEP_TRANSLATION = 25;
    public static final int ROTATE_DEGREES = 4;
    public static final double STEP_ROTATE = ROTATE_DEGREES * Math.PI/180;
    public static final int STEP_ZOOM = 15;
    public static final int ShowPanel_WIDTH = 582;
    public static final int ShowPanel_HEIGHT = 529;
    private Camera camera;
    public static ArrayList<Vector<Point3D>> MAPA;// = wczytajMape();

    public static ArrayList<Vector<Point2D>> getVector2DList() {
        ArrayList<Vector<Point2D>> vectors = new ArrayList<>(MAPA.size());

        for (Vector<Point3D> vect : MAPA) {
            Point2D a = translatePoint3D(vect.getA());
            Point2D b = translatePoint3D(vect.getB());
            vectors.add(new Vector<Point2D>(a, b));
        }
        return vectors;
    }
    public WKUtils(){

    }
    public static ArrayList<Vector<Point2D>> translateVector3DList(ArrayList<Vector<Point3D>> list3d) {
        ArrayList<Vector<Point2D>> vectors = new ArrayList<>(MAPA.size());
        Camera camera = Camera.getInstance();
        for (Vector<Point3D> v : list3d) {
            if (camera.isVisible(v.getA()) && camera.isVisible(v.getB())) {
                Point2D a = translatePoint3D(v.getA());
                Point2D b = translatePoint3D(v.getB());
                vectors.add(new Vector<Point2D>(a, b));
            }
        }

        return vectors;
    }

    private static Point2D translatePoint3D(Point3D p) {
        Camera cam = Camera.getInstance();
        double wsp = cam.getOgniskowa() / (p.getY() - cam.getY());
        int x = (int) (wsp * p.getX() + 400 / 2);
        int z = (int) (400 / 2 - wsp * p.getZ());
        return new Point2D(x, z);
    }

    public static ArrayList<Vector<Point3D>> wczytajMape(InputStream is) {
        ArrayList<Vector<Point3D>> vectors = new ArrayList<>();
        System.out.println("wszedlem w wczytaj");

        String nazwaPliku = "mapa.txt";
        //File file = new File();
       /* if (file.exists() == false) {
            System.out.println("Plik nie istnieje");
            return vectors;
        }*/

        BufferedReader br;
       // DataInputStream dis;

        try {
           // FileInputStream fileStream = new FileInputStream(file);
           // dis = new DataInputStream(fileStream);
            br = new BufferedReader(new InputStreamReader(is));

            String line;

            while ((line = br.readLine()) != null) {
                if (line.length() == 0 || line.startsWith("#"))
                    continue;

                String tab[] = line.split(";");

                for (int i = 0; i < tab.length; i++)
                    tab[i] = tab[i].trim();

                Point3D a = new Point3D(Double.parseDouble(tab[0]), Double.parseDouble(tab[1]), Double.parseDouble(tab[2]));
                Point3D b = new Point3D(Double.parseDouble(tab[3]), Double.parseDouble(tab[4]), Double.parseDouble(tab[5]));

                vectors.add(new Vector<Point3D>(a, b));

            }
            //dis.close();
            is.close();
            return vectors;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Vector<Point3D>>(0);
        }
    }

}
