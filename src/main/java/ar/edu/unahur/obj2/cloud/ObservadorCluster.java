package ar.edu.unahur.obj2.cloud;

public interface ObservadorCluster {
    void notificarCambio(String clusterId, int vcpusActuales, int delta);
}   
