package ar.edu.unahur.obj2.cloud;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClusterTest {
    private Cluster cluster;
    private PlanificadorDespliegue planificador;

    @BeforeEach
    void setUp(){
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

    @Test
    void testValorInvalido(){
        assertThrows(ValorInvalidoExeception.class, ()-> new AsignacionCapacidad(cluster,0));
        assertThrows(ValorInvalidoExeception.class, ()->new LiberacionCapacidad(cluster, -5));
    }

    @Test
    void testFallaOverprovisioning(){
        AsignacionCapacidad asignacionCapacidad = new AsignacionCapacidad(cluster,350);

        assertThrows(OverprovisioningException.class, ()-> {planificador.ejecutar(asignacionCapacidad);});
        
    }

}
