package programacionConcurrente.TrabajoPractico3.EJ2;

public class Sanador implements Runnable {

    private Energia energia;
    public Sanador(Energia e){
        energia = e;
    }

    public void run(){
        while (true){
            energia.modificarEnergia(3);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
