package programacionConcurrente.TrabajoPractico3.EJ3;

public class Descansar {
    public synchronized void dormir() throws Exception{
        System.out.println(Thread.currentThread().getName() + " esta durmiendo");
        Thread.sleep(1000);
    }
}
