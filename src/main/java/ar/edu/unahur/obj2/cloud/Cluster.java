package ar.edu.unahur.obj2.cloud;

import java.util.ArrayList;
import java.util.List;

public class Cluster {

    private String id;
    private int vcpusDisponibles;
    private final List<ObservadorCluster> observadores = new ArrayList<>();

    public Cluster(String id, int vcpusDisponibles) {
        this.id = id;
        this.vcpusDisponibles = vcpusDisponibles;
    }

    public int getVcpusDisponibles() {
        return vcpusDisponibles;
    }

    public String getId() {
        return id;
    }

    public void modificarCapacidad(int delta) throws OverprovisioningException {
        if (this.vcpusDisponibles + delta < -200) {
            throw new OverprovisioningException("limite de overprovisionig superado");
        }
        this.vcpusDisponibles += delta;
        notificar(delta);
    }

    public void suscribir(ObservadorCluster o) {
        observadores.add(o);
    }

    public void desuscribir(ObservadorCluster o) {
        observadores.remove(o);
    }

    private void notificar(int delta) {
        for (ObservadorCluster o : observadores) {
            o.notificarCambio(id, vcpusDisponibles, delta);
        }
    }

}
