package programacionConcurrente.TrabajoPractico2.EJ6;

public class Corredor implements Runnable {

    private String nombre;
    private int distRec;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.distRec = 0;
    }

    @Override
    public void run() {
        try {
            int dist = 0;
            for (int i = 0; i < 100; i++) {
                dist = (int) (Math.random() * 10) + 1;
                distRec += dist;
                System.out.println("El corredor " + nombre + " avanzo " + dist + " pasos");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public String toString() {
        return "" + nombre + " recorrio " + distRec + " pasos";
    }

}
