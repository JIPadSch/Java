package programacionConcurrente.TrabajoPractico3.EJ2;

public class Energia {

    int cantEnergia;

    public Energia(){
        cantEnergia = 10;
    }

    public synchronized int getCantEnergia(){
        return cantEnergia;
    }

    public synchronized void modificarEnergia(int cant){
        cantEnergia += cant;
        System.out.println(Thread.currentThread().getName() + " modifico la energia, ahora esta en: " + cantEnergia);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
  
}
