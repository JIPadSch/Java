package programacionConcurrente.TrabajoPractico3.EJ3;

public class Hamster extends Thread{

    private Jaula jaula;

    public Hamster(Jaula jaula, String nombre){
        super(nombre);
        this.jaula = jaula;
    }
    
    public void run(){
        while(true){
            try {
                jaula.comer();
                jaula.descansar();
                jaula.rodar();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
    }
}
