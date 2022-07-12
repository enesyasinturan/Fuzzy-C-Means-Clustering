package com.eyt.fuzzyclustering;

public class FuzzyClustering {

    static ClusterVariables clusterVariables = new ClusterVariables();

    public static void cluster() {
        double result = 0.0;

        for (int k = 1; k <= clusterVariables.getCentroidList().size(); k++) {
            System.out.println(k);
        }
    }

}
