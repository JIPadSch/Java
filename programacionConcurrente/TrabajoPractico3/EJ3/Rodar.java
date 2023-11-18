package programacionConcurrente.TrabajoPractico3.EJ3;

public class Rodar {
    public synchronized void rodar() throws Exception{
        System.out.println(Thread.currentThread().getName() + " esta rodando");
        Thread.sleep(1000);
    }
}
