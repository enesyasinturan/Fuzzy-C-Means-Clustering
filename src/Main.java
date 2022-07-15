import com.eyt.fuzzyclustering.FuzzyClustering;

public class Main {
    public static void main(String[] args) throws Exception {

        // Default cluster

        FuzzyClustering fuzzyClustering = new FuzzyClustering();
        fuzzyClustering.cluster();


        // Define custom cluster variables

        // List<Double> xiList = Arrays.asList(1.0, 3.0, 5.0, 9.0, 13.0, 15.0, 17.0);
        // List<Double> centroidList = Arrays.asList(2.0, 16.0);
        // int fuzzyIndex = 2;
        // double stoppingCriterion = 0.069;

        // ClusterVariables clusterVariables = new ClusterVariables(xiList, centroidList, fuzzyIndex,
        // stoppingCriterion);

        // FuzzyClustering fuzzyClustering = new FuzzyClustering(clusterVariables);

        // fuzzyClustering.cluster();

    }
}
