package com.ee.grzesiaj.grafikaprojekt1.common;


import android.view.View;


import com.ee.grzesiaj.grafikaprojekt1.to.Point3D;
import com.ee.grzesiaj.grafikaprojekt1.to.Vector;

import java.util.ArrayList;

public class Camera {
    private static Camera instance = null;

    public void setShowPanel(ShowView showPanel) {
        this.showPanel = showPanel;
    }

    private ShowView showPanel = null;
    private int ogniskowa;
    private int y;
    private ArrayList<Vector<Point3D>> vectorsList;

    public Camera() {
        y = 50;
        this.ogniskowa = 300;

    }

    public static final Camera getInstance() {
        if (instance == null)
            instance = new Camera();

        return instance;
    }

    public void zoomIn() {
        ogniskowa += WKUtils.STEP_ZOOM;
        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();

    }

    public void zoomOut() {
        ogniskowa -= WKUtils.STEP_ZOOM;
        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void moveForward() {
        for (Vector<Point3D> v : vectorsList) {
            double yA = v.getA().getY() - WKUtils.STEP_TRANSLATION;
            double yB = v.getB().getY() - WKUtils.STEP_TRANSLATION;

            v.getA().setY(yA);
            v.getB().setY(yB);
        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void moveBack() {
        for (Vector<Point3D> v : vectorsList) {
            double yA = v.getA().getY() + WKUtils.STEP_TRANSLATION;
            double yB = v.getB().getY() + WKUtils.STEP_TRANSLATION;

            v.getA().setY(yA);
            v.getB().setY(yB);
        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void moveLeft() {
        for (Vector<Point3D> v : vectorsList) {
            double xA = v.getA().getX() + WKUtils.STEP_TRANSLATION;
            double xB = v.getB().getX() + WKUtils.STEP_TRANSLATION;

            v.getA().setX(xA);
            v.getB().setX(xB);
        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void moveRight() {
        for (Vector<Point3D> v : vectorsList) {
            double xA = v.getA().getX() - WKUtils.STEP_TRANSLATION;
            double xB = v.getB().getX() - WKUtils.STEP_TRANSLATION;

            v.getA().setX(xA);
            v.getB().setX(xB);
        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void moveUp() {
        for (Vector<Point3D> v : vectorsList) {
            double zA = v.getA().getZ() - WKUtils.STEP_TRANSLATION;
            double zB = v.getB().getZ() - WKUtils.STEP_TRANSLATION;

            v.getA().setZ(zA);
            v.getB().setZ(zB);
        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void moveDown() {
        for (Vector<Point3D> v : vectorsList) {
            double zA = v.getA().getZ() + WKUtils.STEP_TRANSLATION;
            double zB = v.getB().getZ() + WKUtils.STEP_TRANSLATION;

            v.getA().setZ(zA);
            v.getB().setZ(zB);
        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void rotateDown() {

        for (Vector<Point3D> v : vectorsList) {

            double aY = (v.getA().getY() * Math.cos(WKUtils.STEP_ROTATE)) - (v.getA().getZ() * Math.sin(WKUtils.STEP_ROTATE));
            double aZ = (v.getA().getY() * Math.sin(WKUtils.STEP_ROTATE)) + (v.getA().getZ() * Math.cos(WKUtils.STEP_ROTATE));

            double bY = (v.getB().getY() * Math.cos(WKUtils.STEP_ROTATE)) - (v.getB().getZ() * Math.sin(WKUtils.STEP_ROTATE));
            double bZ = (v.getB().getY() * Math.sin(WKUtils.STEP_ROTATE)) + (v.getB().getZ() * Math.cos(WKUtils.STEP_ROTATE));

            v.getA().setY(aY);
            v.getA().setZ(aZ);
            v.getB().setY(bY);
            v.getB().setZ(bZ);

        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void rotateUp() {

        for (Vector<Point3D> v : vectorsList) {
            double aY = (v.getA().getY() * Math.cos((-1) * WKUtils.STEP_ROTATE)) - (v.getA().getZ() * Math.sin((-1) * WKUtils.STEP_ROTATE));
            double aZ = (v.getA().getY() * Math.sin((-1) * WKUtils.STEP_ROTATE)) + (v.getA().getZ() * Math.cos((-1) * WKUtils.STEP_ROTATE));

            double bY = (v.getB().getY() * Math.cos((-1) * WKUtils.STEP_ROTATE)) - (v.getB().getZ() * Math.sin((-1) * WKUtils.STEP_ROTATE));
            double bZ = (v.getB().getY() * Math.sin((-1) * WKUtils.STEP_ROTATE)) + (v.getB().getZ() * Math.cos((-1) * WKUtils.STEP_ROTATE));

            v.getA().setY(aY);
            v.getA().setZ(aZ);
            v.getB().setY(bY);
            v.getB().setZ(bZ);

        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();

    }

    public void rotateRight() {
        for (Vector<Point3D> v : vectorsList) {
            double aX = (v.getA().getX() * Math.cos(WKUtils.STEP_ROTATE)) - (v.getA().getY() * Math.sin(WKUtils.STEP_ROTATE));
            double aY = (v.getA().getX() * Math.sin(WKUtils.STEP_ROTATE)) + (v.getA().getY() * Math.cos(WKUtils.STEP_ROTATE));
            double bX = (v.getB().getX() * Math.cos(WKUtils.STEP_ROTATE)) - (v.getB().getY() * Math.sin(WKUtils.STEP_ROTATE));
            double bY = (v.getB().getX() * Math.sin(WKUtils.STEP_ROTATE)) + (v.getB().getY() * Math.cos(WKUtils.STEP_ROTATE));
            v.getA().setX(aX);
            v.getA().setY(aY);

            v.getB().setX(bX);
            v.getB().setY(bY);
        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void rotateLeft() {
        for (Vector<Point3D> v : vectorsList) {
            double aX = (v.getA().getX() * Math.cos((-1) * WKUtils.STEP_ROTATE)) - (v.getA().getY() * Math.sin((-1) * WKUtils.STEP_ROTATE));
            double aY = (v.getA().getX() * Math.sin((-1) * WKUtils.STEP_ROTATE)) + (v.getA().getY() * Math.cos((-1) * WKUtils.STEP_ROTATE));
            double bX = (v.getB().getX() * Math.cos((-1) * WKUtils.STEP_ROTATE)) - (v.getB().getY() * Math.sin((-1) * WKUtils.STEP_ROTATE));
            double bY = (v.getB().getX() * Math.sin((-1) * WKUtils.STEP_ROTATE)) + (v.getB().getY() * Math.cos((-1) * WKUtils.STEP_ROTATE));
            v.getA().setX(aX);
            v.getA().setY(aY);

            v.getB().setX(bX);
            v.getB().setY(bY);
        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void rotateRightZ() {
        for (Vector<Point3D> v : vectorsList) {
            double aX = (v.getA().getX() * Math.cos((-1) * WKUtils.STEP_ROTATE)) + (v.getA().getZ() * Math.sin((-1) * WKUtils.STEP_ROTATE));
            double aZ = ((-1) * v.getA().getX() * Math.sin((-1) * WKUtils.STEP_ROTATE)) + (v.getA().getZ() * Math.cos((-1) * WKUtils.STEP_ROTATE));
            double bX = (v.getB().getX() * Math.cos((-1) * WKUtils.STEP_ROTATE)) + (v.getB().getZ() * Math.sin((-1) * WKUtils.STEP_ROTATE));
            double bZ = ((-1) * v.getB().getX() * Math.sin((-1) * WKUtils.STEP_ROTATE)) + (v.getB().getZ() * Math.cos((-1) * WKUtils.STEP_ROTATE));

            v.getA().setX(aX);
            v.getA().setZ(aZ);

            v.getB().setX(bX);
            v.getB().setZ(bZ);
        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public void rotateLeftZ() {
        for (Vector<Point3D> v : vectorsList) {
            double aX = (v.getA().getX() * Math.cos(WKUtils.STEP_ROTATE)) + (v.getA().getZ() * Math.sin(WKUtils.STEP_ROTATE));
            double aZ = ((-1) * v.getA().getX() * Math.sin(WKUtils.STEP_ROTATE)) + (v.getA().getZ() * Math.cos(WKUtils.STEP_ROTATE));
            double bX = (v.getB().getX() * Math.cos(WKUtils.STEP_ROTATE)) + (v.getB().getZ() * Math.sin(WKUtils.STEP_ROTATE));
            double bZ = ((-1) * v.getB().getX() * Math.sin(WKUtils.STEP_ROTATE)) + (v.getB().getZ() * Math.cos(WKUtils.STEP_ROTATE));

            v.getA().setX(aX);
            v.getA().setZ(aZ);

            v.getB().setX(bX);
            v.getB().setZ(bZ);
        }

        showPanel.setVectorsList(WKUtils.translateVector3DList(getVectorsList()));
        showPanel.invalidate();
    }

    public double getOgniskowa() {
        return ogniskowa;
    }

    public void setOgniskowa(int rzutnia) {
        this.ogniskowa = rzutnia;
    }

    public boolean isVisible(Point3D point) {
        if (point.getY() >= getY() + ogniskowa)
            return true;

        return false;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Vector<Point3D>> getVectorsList() {
        return vectorsList;
    }
    public void setShowView(ShowView wju){
        this.showPanel = wju;
    }
    public void setVectorsList(ArrayList<Vector<Point3D>> vectorsList) {
        this.vectorsList = vectorsList;
        showPanel.setVectorsList(WKUtils.translateVector3DList(vectorsList));
        showPanel.invalidate();
    }
}
