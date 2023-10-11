package programacionConcurrente.TrabajoPractico3.EJ4;

public class Parque {
    private Actividad[] actividades = new Actividad [4];

    public Parque(){
        for (int i = 0; i < actividades.length; i++) {
            actividades[i] = new Actividad(i);
        }
    }

    public void reserva(int nroAct){
        actividades[nroAct].verificarDisponibilidad();
    }
}
