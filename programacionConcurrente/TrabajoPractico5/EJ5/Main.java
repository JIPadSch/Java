package programacionConcurrente.TrabajoPractico5.EJ5;

public class Main {
    public static void main(String[] args) {

        Comedor comedor = new Comedor(100);

        Perro perros[] = new Perro[2000];
        Gato gatos[] = new Gato[2000];

        for (int i = 0; i < gatos.length; i++) {
            perros[i] = new Perro(comedor, "Perro "+i);
            perros[i].start();

            gatos[i] = new Gato(comedor, "Gato "+i);
            gatos[i].start();
        }

    }
}
