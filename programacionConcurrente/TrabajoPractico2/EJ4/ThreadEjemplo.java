package programacionConcurrente.TrabajoPractico2.EJ4;

public class ThreadEjemplo implements Runnable {
    
    String nombre;

    public ThreadEjemplo(String str) {
        nombre = str;
    }

    public void run() {
        for (int i = 0; i < 10 ; i++)
        System.out.println(i + " " + nombre);
        System.out.println("Termina thread " + nombre);
    }
}