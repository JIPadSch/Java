package programacionConcurrente.TrabajoPractico4.EJ5;

import java.util.concurrent.Semaphore;

public class Impresora {

    Semaphore libre;

    public Impresora(){
        this.libre = new Semaphore(1);
    }

    public int estaLibre(){
        return libre.availablePermits();
    }

    public void imprimir(){
        
        System.out.println(Thread.currentThread().getName()+" esta utilizando una impresora");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void usar(){
        try {
            libre.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void liberar(){
        try {
            libre.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
