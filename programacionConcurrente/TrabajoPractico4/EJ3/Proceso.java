package programacionConcurrente.TrabajoPractico4.EJ3;

import java.util.concurrent.Semaphore;

public class Proceso extends Thread {

    Semaphore inicio, fin;

    public Proceso(String nombre, Semaphore s1, Semaphore s2) {
        super(nombre);
        inicio = s1;
        fin = s2;
    }

    public void run() {
        try {

            inicio.acquire();
            
            for (int i = 0; i < 10; i++) {
                System.out.println("Este es el proceso: " + this.getName());    
            }
            
            fin.release();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
