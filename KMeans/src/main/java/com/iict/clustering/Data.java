/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.clustering;

import java.util.ArrayList;
import java.util.Random;

/**
 * K Means Clustering Demo
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class Data {

    /**
     * Data fields
     */
    private final ArrayList<Point> trainingData;
    private final ArrayList<Point> testData;
    private ArrayList<Point> centroids;

    /**
     * No. of Centroids: k = 3 No. of Dimension: d = 2 No. of Instances: n = 8
     */
    public static final int MAX_ITERATION = 10;
    public static final int K = 3;
    public static final int N = 8;
    public static final int D = 2;
    public static final String LINE = "-------------------------------------------------------------------------------";

    public Data() {

        /** Training Data */
        trainingData = ReadTrainingData();

        /** Test Data */
        testData = new ArrayList<>();

        /** Initial Centroids */
        centroids = ReadCentroids();
    }

    /**
     * Read training data: here sample are initialized in a list.
     *
     * @return trainingData
     */
    private ArrayList<Point> ReadTrainingData() {
        ArrayList<Point> tData = new ArrayList<>();
        tData.add(new Point(2.0, 10.0));//A1
        tData.add(new Point(2.0, 5.0)); //A2
        tData.add(new Point(8.0, 4.0)); //A3
        tData.add(new Point(5.0, 8.0)); //A4
        tData.add(new Point(7.0, 5.0)); //A5
        tData.add(new Point(6.0, 4.0)); //A6
        tData.add(new Point(1.0, 2.0)); //A7
        tData.add(new Point(4.0, 9.0)); //A8
        return tData;
    }

    /**
     * Read initial centroid: here samples are randomly assigned.
     *
     * @return
     */
    private ArrayList<Point> ReadCentroids() {
//        ArrayList<Integer> rIndexList = GetRandomizedIndexes();
        ArrayList<Point> cData = new ArrayList<>();
//        rIndexList.stream().forEach((index) -> {
//            cData.add(trainingData.get(index));
//        });

        cData.add(trainingData.get(0)); //A1
        cData.add(trainingData.get(3)); //A4
        cData.add(trainingData.get(6)); //A7
        return cData;
    }

    /**
     * Get list of k integers, randomly selected from n.
     *
     * @return listOfIntegers
     */
    private ArrayList<Integer> GetRandomizedIndexes() {
        ArrayList<Integer> rList = new ArrayList<>();
        boolean getNext = true;
        Random rndObject = new Random();
        while (getNext) {
            final int rndNumber = rndObject.nextInt(N);
            if (!rList.contains(rndNumber)) {
                rList.add(rndNumber);
            }

            /** Check if all done. */
            if (rList.size() >= K) {
                getNext = false;
            }
        }
        return rList;
    }

    /**
     * Returns the test data.
     *
     * @return
     */
    public ArrayList<Point> GetTestData() {
        return this.testData;
    }

    /**
     * Returns the training data.
     *
     * @return
     */
    public ArrayList<Point> GetTrainingData() {
        return this.trainingData;
    }

    /**
     * Returns the centroids
     *
     * @return
     */
    public ArrayList<Point> GetCentroids() {
        return this.centroids;
    }

    /**
     * Calculates the Euclidean Distance between two points.
     *
     * @param xPoint
     * @param cPoint
     * @return eDistance
     */
    private double GetEuclideanDistance(Point xPoint, Point cPoint) {
        final double xPart = (xPoint.getX() - cPoint.getX());
        final double yPart = (xPoint.getY() - cPoint.getY());
        return Math.sqrt((xPart * xPart) + ((yPart * yPart)));
    }

    /**
     * Calculates the Closest Centroids based on the Euclidean Distance Measure.
     *
     * @param xPoint
     * @return intdexOfCentroid
     */
    public int GetClosestCentroid(Point xPoint) {
        double minValue = Double.MAX_VALUE;
        int closestIndex = -1;
        for (int index = 0; index < centroids.size(); index++) {
            double cDistance = GetEuclideanDistance(xPoint, centroids.get(index));
            if (cDistance < minValue) {
                minValue = cDistance;
                closestIndex = index;
            }
        }
        return closestIndex;
    }

    /**
     * Calculates the updated centroid for all clusters.
     *
     * @param pointIndexes
     * @return centroidPoint
     */
    public Point CalculateCentroid(ArrayList<Integer> pointIndexes) {
        double xPart = 0.0;
        double yPart = 0.0;
        for (int index : pointIndexes) {
            xPart += trainingData.get(index - 1).getX();
            yPart += trainingData.get(index - 1).getY();
        }
        return new Point(xPart / (double) pointIndexes.size(), yPart / (double) pointIndexes.size());
    }

    /**
     * Verifies the latest centroids of all clusters are same with the old one
     * or not.
     *
     * @param newCentroids
     * @return true if the new centroids and old centroids are not same.
     */
    public boolean ChangedCentroids(ArrayList<Point> newCentroids) {
        boolean result = false;
        for (int i = 0; i < K; i++) {
            if (!newCentroids.get(i).equals(centroids.get(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Updates the newly calculated centroids to the old one.
     *
     * @param newCentroids
     */
    public void UpdateCentroids(ArrayList<Point> newCentroids) {
        this.centroids = newCentroids;
    }
}
