package programacionConcurrente.TrabajoPractico3.EJ2;

public class Main {

    public static void main(String[] args) {

        Energia e = new Energia();
        CriaturaOscura c = new CriaturaOscura(e);
        Sanador s = new Sanador(e);

        Thread hilo1 = new Thread(c, "Criatura");
        Thread hilo2 = new Thread(s, "Sanador");

        hilo1.start();
        hilo2.start();
    }
    
}
