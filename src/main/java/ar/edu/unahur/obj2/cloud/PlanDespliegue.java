package ar.edu.unahur.obj2.cloud;

import java.util.ArrayList;
import java.util.List;

public class PlanDespliegue implements OperacionInfraestructura {
    private final List<OperacionInfraestructura> operaciones = new ArrayList<>();

    public void agregarOperaciones(OperacionInfraestructura op){
        operaciones.add(op);
    }

    @Override
    public void ejecutar() throws OverprovisioningException{
        List<OperacionInfraestructura> ejecutadasConExito = new ArrayList<>();

        try{
            for(OperacionInfraestructura op : operaciones){
                op.ejecutar();
                ejecutadasConExito.add(op);
            }
        }catch(OverprovisioningException e){
            for(int i = ejecutadasConExito.size() -1; i>=0; i--){
                ejecutadasConExito.get(i).deshacer();
            }
            throw e;
        }
    }

    @Override
    public void deshacer(){
        for (int i = operaciones.size() -1; 1>=0; i--){
            operaciones.get(i).deshacer();
        }
    }

    public void vaciar(){
        operaciones.clear();
    }

    public int getCantidadOperaciones(){
        return(operaciones.size());
    }


}
