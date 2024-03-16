/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.clustering;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class Point {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object cPoint) {
        Point xPoint = (Point) cPoint;
        return xPoint != null && x == xPoint.getX() && y == xPoint.getY();
    }

    @Override
    public String toString() {
        return "Point(" + String.format("%.2f", x) + "," + String.format("%.2f", y) + ')';
    }

}
