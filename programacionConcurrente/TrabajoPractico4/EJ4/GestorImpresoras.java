package programacionConcurrente.TrabajoPractico4.EJ4;

public class GestorImpresoras {

    private Impresora[] impresoras;

    public GestorImpresoras(int cant) {

        this.impresoras = new Impresora[cant];

        for (int i = 0; i < cant; i++) {
            impresoras[i] = new Impresora();
        }

    }

    public void solicitudImprimir(Cliente cliente) {

        while (true) {

            boolean encontrado = false;
            int i = 0;

            while (!encontrado || i < impresoras.length) {
                if (impresoras[i].estaLibre() == 1) {
                    encontrado = true;
                } else {
                    i++;
                }
            }

            if (encontrado) {
                impresoras[i].usar();
                impresoras[i].imprimir();
                impresoras[i].liberar();
            }
            
        }

    }

}
