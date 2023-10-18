package programacionConcurrente.TrabajoPractico5.EJ5;

public class Perro extends Animal {

    public Perro(Comedor comedor,  String nombre){
        super(comedor, nombre);
    }
    
    public void run(){

        try {
            comedor.comer();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
