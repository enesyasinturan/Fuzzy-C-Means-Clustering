package com.eyt.fuzzyclustering;

import java.util.ArrayList;
import java.util.List;

public class FuzzyClustering {

    private static ClusterVariables clusterVariables = new ClusterVariables();

    private static List<Double> newUiList = new ArrayList<Double>();

    private static int iterationCount = 1;

    public static void cluster() {

        System.out.println();
        System.out.println();
        System.out.println("ITERASYON: " + iterationCount);
        System.out.println();
        System.out.println();

        newUiList.clear();


        for (int i = 1; i <= clusterVariables.getCentroidList().size(); i++) {
            for (int j = 1; j <= clusterVariables.getXiList().size(); j++) {
                double result = 0.0;

                for (int k = 1; k <= clusterVariables.getCentroidList().size(); k++) {

                    result += Math.pow((clusterVariables.getXiList().get(j - 1) - clusterVariables.getCentroidList().get(i - 1)) / (clusterVariables.getXiList().get(j - 1) - clusterVariables.getCentroidList().get(k - 1)), 2);
                }
                newUiList.add(1 / result);
                System.out.println("u" + i + j + ": " + 1 / result);
            }
        }

        clusterVariables.setUiList(newUiList);
        newCentroids();

        if (StoppingCriterionControl() == true) {
            iterationCount++;
            cluster();
        } else {
            System.out.println("Kümeleme bitti.");
            for (Double item : clusterVariables.getCentroidList()) {
                System.out.println("new c: " + item);
            }
        }
    }

    // private static Boolean FirstIteration() {
    // Boolean firsIteration = false;

    // /*
    // * Küme merkezlerinin hata ile karşılaştırılması yapılmadan önce, kümelemenin ilk başında olup
    // * olmadığının kontrolü burada gerçekleşiyor. Eğer geçici listedeki küme merkez değerleri ile
    // normal
    // * küme merkezleri aynıysa ilk iterasyondayız diyebiliriz.
    // */
    // for (int i = 0; i < clusterVariables.getCentroidList().size(); i++) {
    // for (int j = i; j <= i; j++) {
    // if (clusterVariables.getCentroidList().get(i) == clusterVariables.getCentroidTempList().get(i)) {
    // firsIteration = true;
    // }
    // }
    // }
    // return firsIteration;
    // }

    private static Boolean StoppingCriterionControl() {

        for (int i = 0; i < clusterVariables.getCentroidList().size(); i++) {

            double result = Math.abs(clusterVariables.getCentroidTempList().get(i) - clusterVariables.getCentroidList().get(i));
            System.out.println("RESULT:::" + result);

            if (result > clusterVariables.getStoppingCriterion() || result == 0) {
                return true;
            }
        }
        return false;
    }

    private static void newCentroids() {

        List<Double> results = new ArrayList<Double>();

        clusterVariables.setCentroidTempList(clusterVariables.getCentroidList());

        for (int k = 0; k < clusterVariables.getCentroidNumber(); k++) {
            double result1 = 0.0;
            double result2 = 0.0;

            /*
             * Ui listesinin içinde birinci kümenin 0 <= i < 7 arasında, ikinci merkezin 7 <= i < 14 arasında
             * olması gerekiyor.
             * 
             * k döngüsü 0 ve 1 değerleri alacağı için (iki küme merkezi için), döngünün başlangıç kısmı olan i,
             * önce 0'dan başlayacak 7'ye kadar gidecek, sonrasında 7 olarak başlayıp 14'e kadar gidecektir.
             * 
             * c ve aşağıdaki döngünün bitiş değerlerindeki formüller bu aralığı sağlamak içindir.
             */
            int c = k * (clusterVariables.getXiList().size());

            for (int i = c; i < clusterVariables.getXiList().size() * (k + 1); i++) {

                /*
                 * i % clusterVariables.getXiList().size() formülü ise Xi listesinin dışına çıkmamak için
                 * oluşturulmuş ve döngü 7 ile 14 arasında olsa bile Xi'nin ham değerlerine ulaşmak içindir.
                 */
                result1 += clusterVariables.getUiList().get(i) * clusterVariables.getUiList().get(i) * clusterVariables.getXiList().get(i % clusterVariables.getXiList().size());
                result2 += clusterVariables.getUiList().get(i) * clusterVariables.getUiList().get(i);
            }

            results.add(result1 / result2);
        }
        clusterVariables.setCentroidList(results);
    }

}
