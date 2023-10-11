package programacionConcurrente.TrabajoPractico3.EJ2;

public class CriaturaOscura implements Runnable {

    private Energia energia;

    public CriaturaOscura (Energia e){
        energia = e;
    }

    public void run(){
        while (true){
            energia.modificarEnergia(-3);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    
}
