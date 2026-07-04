package ar.edu.unahur.obj2.cloud;

public interface OperacionInfraestructura {
    void ejecutar() throws OverprovisioningException;
    void deshacer();
}
