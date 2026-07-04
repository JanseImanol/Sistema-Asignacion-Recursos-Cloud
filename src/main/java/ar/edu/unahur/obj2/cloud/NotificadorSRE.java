package ar.edu.unahur.obj2.cloud;

public class NotificadorSRE implements ObservadorCluster {

    @Override
    public void notificarCambio(String clusterId, int vcpusActuales, int delta){
        String accion;
        if (delta > 0){
            accion ="liberado";
        }
        else{
            accion = "asignado";
        }
        System.out.println("se a "+ accion + delta + " en el cluster" + clusterId);
    }
}
