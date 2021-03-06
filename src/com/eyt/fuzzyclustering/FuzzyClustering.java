package com.eyt.fuzzyclustering;

import java.util.ArrayList;
import java.util.List;

public class FuzzyClustering {

    private ClusterVariables clusterVariables;

    private List<Double> newUiList;

    private int iterationCount = 1;

    public FuzzyClustering() {
        this.clusterVariables = new ClusterVariables();
        this.newUiList = new ArrayList<Double>();
    }

    public FuzzyClustering(ClusterVariables clusterVariables) {
        this.clusterVariables = clusterVariables;
        this.newUiList = new ArrayList<Double>();
    }

    public ClusterVariables getClusterVariables() {
        return this.clusterVariables;
    }

    public void setClusterVariables(ClusterVariables clusterVariables) {
        this.clusterVariables = clusterVariables;
    }

    public List<Double> getNewUiList() {
        return this.newUiList;
    }

    public void setNewUiList(List<Double> newUiList) {
        this.newUiList = newUiList;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public void setIterationCount(int iterationCount) {
        this.iterationCount = iterationCount;
    }

    public void cluster() {

        newUiList.clear();


        System.out.println("\n\n-----------------------------------------\n|\t\tITERATION: " + iterationCount + "\t\t|\n-----------------------------------------");

        System.out.println("\n-------------\n| centorids |\n-------------");

        for (Double centorid : clusterVariables.getCentroidList()) {
            System.out.println(centorid);
        }

        if (iterationCount == 1) {
            System.out.println("\n---------------\n| fuzzy index |\n---------------");
            System.out.println(clusterVariables.getFuzzyIndex());

            System.out.println("\n----------------------\n| stopping criterion |\n----------------------");
            System.out.println(clusterVariables.getStoppingCriterion());

            System.out.println("\n------------\n| x values |\n------------");

            for (Double xValues : clusterVariables.getXiList()) {
                System.out.println(xValues);
            }
        }

        System.out.println("\n------------\n| u values |\n------------");

        /**
         * Ui de??erlerinin hesaplanmas??
         */
        for (int i = 1; i <= clusterVariables.getCentroidList().size(); i++) {
            for (int j = 1; j <= clusterVariables.getXiList().size(); j++) {
                double result = 0.0;

                for (int k = 1; k <= clusterVariables.getCentroidList().size(); k++) {

                    result += Math.pow((clusterVariables.getXiList().get(j - 1) - clusterVariables.getCentroidList().get(i - 1)) / (clusterVariables.getXiList().get(j - 1) - clusterVariables.getCentroidList().get(k - 1)), (2 / (clusterVariables.getFuzzyIndex() - 1)));
                }
                newUiList.add(1 / result);

                System.out.println("u" + i + j + ": " + 1 / result);
            }
            System.out.println();
        }

        clusterVariables.setUiList(newUiList);
        newCentroids();


        System.out.println("-----------------\n| new centroids |\n-----------------");

        for (Double item : clusterVariables.getCentroidList()) {
            System.out.println(item);
        }

        System.out.println("\n-----------\n| vi - ei |\n-----------");

        if (StoppingCriterionControl() == true) {
            iterationCount++;
            System.out.println("\nvi > ei\nclustering is continue...");
            cluster();
        } else {
            System.out.println("\nvi < ei\nclustering is done.\n\n");
        }
    }

    private Boolean StoppingCriterionControl() {

        for (int i = 0; i < clusterVariables.getCentroidList().size(); i++) {

            double result = Math.abs(clusterVariables.getCentroidTempList().get(i) - clusterVariables.getCentroidList().get(i));
            System.out.println(result);

            if (result > clusterVariables.getStoppingCriterion() || result == 0) {
                return true;
            }
        }
        return false;
    }

    private void newCentroids() {

        List<Double> results = new ArrayList<Double>();

        clusterVariables.setCentroidTempList(clusterVariables.getCentroidList());

        for (int k = 0; k < clusterVariables.getCentroidNumber(); k++) {
            double result1 = 0.0;
            double result2 = 0.0;

            /*
             * Ui listesinin i??inde birinci k??menin 0 <= i < 7 aras??nda, ikinci merkezin 7 <= i < 14 aras??nda
             * olmas?? gerekiyor.
             * 
             * k d??ng??s?? 0 ve 1 de??erleri alaca???? i??in (iki k??me merkezi i??in), d??ng??n??n ba??lang???? k??sm?? olan i,
             * ??nce 0'dan ba??layacak 7'ye kadar gidecek, sonras??nda 7 olarak ba??lay??p 14'e kadar gidecektir.
             * 
             * c ve a??a????daki d??ng??n??n biti?? de??erlerindeki form??ller bu aral?????? sa??lamak i??indir.
             */
            int c = k * (clusterVariables.getXiList().size());

            for (int i = c; i < clusterVariables.getXiList().size() * (k + 1); i++) {

                /*
                 * i % clusterVariables.getXiList().size() form??l?? ise Xi listesinin d??????na ????kmamak i??in
                 * olu??turulmu?? ve d??ng?? 7 ile 14 aras??nda olsa bile Xi'nin ham de??erlerine ula??mak i??indir.
                 */
                result1 += clusterVariables.getUiList().get(i) * clusterVariables.getUiList().get(i) * clusterVariables.getXiList().get(i % clusterVariables.getXiList().size());
                result2 += clusterVariables.getUiList().get(i) * clusterVariables.getUiList().get(i);
            }

            results.add(result1 / result2);
        }
        clusterVariables.setCentroidList(results);
    }

}
