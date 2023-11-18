package programacionConcurrente.TrabajoPractico3.EJ4;

public class Persona extends Thread{
    private Parque p;
    private int nroAct;

    public Persona (Parque p, int nroAct, int i){
        super("Persona "+i);
        this.p = p;
        this.nroAct = nroAct;
    }

    public void run(){
        try {
            p.reserva(nroAct);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
