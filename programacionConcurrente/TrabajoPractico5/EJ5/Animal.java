package programacionConcurrente.TrabajoPractico5.EJ5;

public class Animal extends Thread {

    protected Comedor comedor;

    public Animal(Comedor comedor, String nombre){
        super(nombre);
        this.comedor = comedor;
    }
    
}
