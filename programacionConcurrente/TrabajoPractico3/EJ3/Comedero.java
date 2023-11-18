package programacionConcurrente.TrabajoPractico3.EJ3;

public class Comedero {
    public synchronized void comer() throws Exception{
        System.out.println(Thread.currentThread().getName() + " esta comiendo");
        Thread.sleep(1000);
    }
}
