package ar.edu.unahur.obj2.cloud;

public class AlarmaSaturacionCritica implements ObservadorCluster{
    private boolean alarma = false;

    @Override
    public void notificarCambio(String clusterId, int vcpusActuales, int delta){
        if (vcpusActuales < 0){
            alarma = true;
            System.out.println("Alarma, el cluster "+ clusterId +" esta operando en la zona de overprovisioning");
        }else{
            alarma = false;
        }
    }
}
