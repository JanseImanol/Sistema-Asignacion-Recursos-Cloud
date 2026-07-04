package ar.edu.unahur.obj2.cloud;

import java.util.ArrayList;
import java.util.List;

public class CloudTrail implements ObservadorCluster {
    private List<String> logs = new ArrayList<>();

    @Override
    public void notificarCambio(String clusterId, int vcpusActuales, int delta){
        String log = "Cluster "+ clusterId + "modifico su capacidad en "+ delta;
        logs.add(log);
        System.out.println(log);
    }

    public List<String> getLogs(){
        return logs;
    }
}
