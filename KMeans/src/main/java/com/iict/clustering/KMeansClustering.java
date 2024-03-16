/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.clustering;

import java.util.ArrayList;

/**
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class KMeansClustering {

    private final Data dataSet;

    /**
     * Constructor, initialized with no. of clusters.
     */
    public KMeansClustering() {
        dataSet = new Data();
    }

    /**
     * Print Utility
     */
    private void PrintCentroids() {
        System.out.println(Data.LINE);
        System.out.println("Updated Centroids: " + dataSet.GetCentroids());
        System.out.println(Data.LINE);
    }

    /**
     * Returns the array list of formatted centroids.
     *
     * @return listOfCentroids
     */
    public ArrayList<Point> GetCentroids() {
        return dataSet.GetCentroids();
    }

    /**
     * Print Utility
     */
    private void PrintTrainingData() {
        System.out.println(Data.LINE);
        System.out.println("Training Data:\t" + dataSet.GetTrainingData());
    }

    /**
     * Calculates the centroids of all clusters and returns the list of centroids.
     *
     * @return newCentroids of all clusters.
     */
    private ArrayList<Point> GetCentroids(Clusters currentClusters) {
        ArrayList<Point> newCentroids = new ArrayList<>();
        for (int i = 0; i < Data.K; i++) {
            newCentroids.add(dataSet.CalculateCentroid(currentClusters.GetClusterPoints(i)));
        }
        return newCentroids;
    }

    /**
     * Run procedure to perform clustering.
     */
    public void Run() {
        System.out.println("Initial Data : ");
        PrintTrainingData();
        PrintCentroids();

        /**
         * Loop until the model gets trained.
         */
        int iteration = 1;
        boolean loop = true;
        while (loop && iteration < Data.MAX_ITERATION) {
            System.out.println("\nIteration : " + iteration + " started ...");
            /**
             * Calculate each point to the closest cluster.
             */
            Clusters currentClusters = new Clusters();
            for (int i = 0; i < dataSet.GetTrainingData().size(); i++) {
                final Point xPoint = dataSet.GetTrainingData().get(i);
                final int closestCluster = dataSet.GetClosestCentroid(xPoint);
                currentClusters.AddPoint(closestCluster, i + 1);
            }
            /**
             * Print Current Clusters.
             */
            System.out.println("Current Clusters : \n" + currentClusters);

            ArrayList<Point> newCentroids = GetCentroids(currentClusters);
            if (dataSet.ChangedCentroids(newCentroids)) {
                dataSet.UpdateCentroids(newCentroids);
            } else {
                loop = false;
            }
            PrintCentroids();
            iteration++;
            try {
                System.out.println("Press any key to continue ...");
                System.in.read();
            } catch (Exception ee) {
            }
        }
    }
}
