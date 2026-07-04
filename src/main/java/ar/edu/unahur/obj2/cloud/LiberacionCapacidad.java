package ar.edu.unahur.obj2.cloud;

public class LiberacionCapacidad implements OperacionInfraestructura {
    private final Cluster cluster;
    private final int vcpus;

    public LiberacionCapacidad(Cluster cluster, int vcpus) {
        if(vcpus <= 0){
            throw new ValorInvalidoExeception("la cantidad debe ser mayor a cero");
        }
        this.cluster = cluster;
        this.vcpus = vcpus;
    }

    @Override
    public void ejecutar() throws OverprovisioningException{
        cluster.modificarCapacidad(vcpus);
    }

    @Override
    public void deshacer(){
        try {
            cluster.modificarCapacidad(-vcpus);
        } catch (OverprovisioningException e) {
        }
    }
    
}

