/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.clustering;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class Clusters {
    
    /**
     * Stores all the learned clusters (as their indexes). 
     */
    HashMap<Integer, ArrayList<Integer>> allClusters;
    
    /**
     * Default constructor.
     */
    public Clusters(){
        allClusters = new HashMap<>();
    }
    
    /**
     * Updates a point to the newly calculated cluster.
     * @param clusterId
     * @param xIndex 
     */
    public void AddPoint(int clusterId, int xIndex){
        ArrayList<Integer> currentClustersList = allClusters.get(clusterId);
        if(currentClustersList == null){
            currentClustersList = new ArrayList<>();
        }
        currentClustersList.add(xIndex);
        allClusters.put(clusterId, currentClustersList);
    }
    
    /**
     * Returns the list of clusters point indexes.
     * @param clusterId
     * @return clusterIndexes as a list of integers.
     */
    public ArrayList<Integer> GetClusterPoints(int clusterId){
        return allClusters.get(clusterId);
    }

    @Override
    public String toString() {
        return "Clusters Info: [" + "AllClusters = " + allClusters + ']';
    }    
}
