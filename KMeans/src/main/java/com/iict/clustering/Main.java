package com.iict.clustering;

/**
 * This class is a part of the package com.iict.clustering and the package
 * is a part of the project Default (Template) Project.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://integratedict.com.np/
 * https://semantro.com/
 * <p>
 * Created by santa on 2015-03-16.
 * https://github.com/santabasnet
 */

/**
 * Main Class, program starts from here.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Clustering Started ...");
        new KMeansClustering().Run();
        System.out.println("\nClustering Completed !");
    }
}