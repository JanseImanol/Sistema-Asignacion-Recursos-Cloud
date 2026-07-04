package ar.edu.unahur.obj2.cloud;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ClusterTest {
    private Cluster cluster;
    private PlanificadorDespliegue planificador;

    @BeforeEach
    void serUp(){
        cluster = new Cluster("cluster11", 100);
        planificador = new PlanificadorDespliegue();
    }

    @Test
    void tesOperacionIndividualExitosa() throws OverprovisioningException{
        AsignacionCapacidad asignacion = new AsignacionCapacidad(cluster, 40);
        planificador.ejecutar(asignacion);
        assertEquals(60, cluster.getVcpusDisponibles());

        asignacion.deshacer();
        assertEquals(100, cluster.getVcpusDisponibles());
    }

    @Test
    void testLiberacionIndividualExitosa() throws OverprovisioningException{
        LiberacionCapacidad liberacion = new LiberacionCapacidad(cluster, 50);
        planificador.ejecutar(liberacion);
        assertEquals(150, cluster.getVcpusDisponibles());

        liberacion.deshacer();
        assertEquals(100, cluster.getVcpusDisponibles());
    }

}
