package programacionConcurrente.TrabajoPractico3.EJ3;

public class Jaula {

    public synchronized void comer(Hamster unHamster) throws Exception{
        System.out.println("El hamster "+unHamster.getNro()+" esta comiendo");
        Thread.sleep(1000);
    }
    
    public synchronized void rodar(Hamster unHamster) throws Exception{
        System.out.println("El hamster "+unHamster.getNro()+" esta rodando");
        Thread.sleep(1000);
    }

    public synchronized void descansar(Hamster unHamster) throws Exception{
        System.out.println("El hamster "+unHamster.getNro()+" esta descansando");
        Thread.sleep(1000);
    }
}
