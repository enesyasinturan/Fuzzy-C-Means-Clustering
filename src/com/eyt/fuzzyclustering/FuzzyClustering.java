package com.eyt.fuzzyclustering;

import java.util.ArrayList;
import java.util.List;

public class FuzzyClustering {

    static ClusterVariables clusterVariables = new ClusterVariables();


    public static void cluster() {

        for (int i = 1; i <= clusterVariables.getCentroidList().size(); i++) {
            for (int j = 1; j <= clusterVariables.getXiList().size(); j++) {
                double result = 0.0;

                for (int k = 1; k <= clusterVariables.getCentroidList().size(); k++) {

                    result += Math.pow((clusterVariables.getXiList().get(j - 1)
                            - clusterVariables.getCentroidList().get(i - 1))
                            / (clusterVariables.getXiList().get(j - 1)
                                    - clusterVariables.getCentroidList().get(k - 1)),
                            2);
                }
                clusterVariables.getUiList().add(1 / result);
                System.out.println("u" + i + j + ": " + 1 / result);
            }
        }

        System.out.println("YENİ MERKEZLER: ");
        for (Double item : newCentroids(clusterVariables)) {
            System.out.println(item);
        }
    }

    public static List<Double> newCentroids(ClusterVariables clusterVariables) {

        List<Double> results = new ArrayList<Double>();

        for (int k = 0; k < clusterVariables.getCentroidNumber(); k++) {
            double result1 = 0.0;
            double result2 = 0.0;

            /*
             * Ui listesinin içinde birinci kümenin 0 <= i < 7 arasında, ikinci merkezin 7 <= i < 14
             * arasında olması gerekiyor.
             * 
             * k döngüsü 0 ve 1 değerleri alacağı için (iki küme merkezi için), döngünün başlangıç
             * kısmı olan i, önce 0'dan başlayacak 7'ye kadar gidecek, sonrasında 7 olarak başlayıp
             * 14'e kadar gidecektir.
             * 
             * c ve aşağıdaki döngünün bitiş değerlerindeki formüller bu aralığı sağlamak içindir.
             */
            int c = k * (clusterVariables.getXiList().size());

            for (int i = c; i < clusterVariables.getXiList().size() * (k + 1); i++) {

                /*
                 * i % clusterVariables.getXiList().size() formülü ise Xi listesinin dışına çıkmamak
                 * için oluşturulmuş ve döngü 7 ile 14 arasında olsa bile Xi'nin ham değerlerine
                 * ulaşmak içindir.
                 */
                result1 += clusterVariables.getUiList().get(i) * clusterVariables.getUiList().get(i)
                        * clusterVariables.getXiList().get(i % clusterVariables.getXiList().size());
                result2 +=
                        clusterVariables.getUiList().get(i) * clusterVariables.getUiList().get(i);
            }

            results.add(result1 / result2);
        }

        return results;
    }

}
