# K-Means-Java
K-Means Demo from Scratch in Java, implemented during undergraduate lecture. 

A centroid based implementation of K-Means clustering algorithm, which utilizes 
iterative process to keep finding new centroids. This demonstrates the working
of unsupervised clustering algorithm in Machine Learning.

```
Clustering Started ...
Initial Data : 
-------------------------------------------------------------------------------
Training Data:	[Point(2.00,10.00), Point(2.00,5.00), Point(8.00,4.00), 
Point(5.00,8.00), Point(7.00,5.00), Point(6.00,4.00), Point(1.00,2.00), Point(4.00,9.00)]
-------------------------------------------------------------------------------
Updated Centroids: [Point(2.00,10.00), Point(5.00,8.00), Point(1.00,2.00)]
-------------------------------------------------------------------------------

Iteration : 1 started ...
Current Clusters : 
Clusters Info: [AllClusters = {0=[1], 1=[3, 4, 5, 6, 8], 2=[2, 7]}]
-------------------------------------------------------------------------------
Updated Centroids: [Point(2.00,10.00), Point(6.00,6.00), Point(1.50,3.50)]
-------------------------------------------------------------------------------
Press any key to continue ...


Iteration : 2 started ...
Current Clusters : 
Clusters Info: [AllClusters = {0=[1, 8], 1=[3, 4, 5, 6], 2=[2, 7]}]
-------------------------------------------------------------------------------
Updated Centroids: [Point(3.00,9.50), Point(6.50,5.25), Point(1.50,3.50)]
-------------------------------------------------------------------------------
Press any key to continue ...


Iteration : 3 started ...
Current Clusters : 
Clusters Info: [AllClusters = {0=[1, 4, 8], 1=[3, 5, 6], 2=[2, 7]}]
-------------------------------------------------------------------------------
Updated Centroids: [Point(3.67,9.00), Point(7.00,4.33), Point(1.50,3.50)]
-------------------------------------------------------------------------------
Press any key to continue ...


Iteration : 4 started ...
Current Clusters : 
Clusters Info: [AllClusters = {0=[1, 4, 8], 1=[3, 5, 6], 2=[2, 7]}]
-------------------------------------------------------------------------------
Updated Centroids: [Point(3.67,9.00), Point(7.00,4.33), Point(1.50,3.50)]
-------------------------------------------------------------------------------
Press any key to continue ...


Clustering Completed !
```
