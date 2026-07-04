package ar.edu.unahur.obj2.cloud;

public class PlanificadorDespliegue {
    private final PlanDespliegue planActual = new PlanDespliegue();

    public void ejecutar(OperacionInfraestructura op) throws OverprovisioningException{
        op.ejecutar();
    }

    public void registrarOperacion(OperacionInfraestructura op){
        planActual.agregarOperaciones(op);
    }

    public void ejecutarPlan() throws OverprovisioningException{
        try{
            planActual.ejecutar();
        }finally{
            planActual.vaciar();
        }
    }

    public PlanDespliegue getPlanActual(){
        return planActual;
    }

}
