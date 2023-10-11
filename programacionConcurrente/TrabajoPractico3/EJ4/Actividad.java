package programacionConcurrente.TrabajoPractico3.EJ4;

public class Actividad {
    private int dispoibilidad =  2;
    private int id;

    public Actividad(int i){
        id = i;
    }

    public synchronized void verificarDisponibilidad(){
        if (dispoibilidad != 0){
            this.reservar();
        }else{
            System.out.println(Thread.currentThread().getName()+" No hay disponibilidad, lola");
        }
    }

    public void reservar(){
        dispoibilidad--;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " Se pudo, GOL");
    }
}
