package com.eyt.fuzzyclustering;

public class Point {
    private double x;
    private double y;

    Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
