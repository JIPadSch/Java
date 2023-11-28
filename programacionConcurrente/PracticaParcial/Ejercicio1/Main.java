package PracticaParcial.Ejercicio1;

public class Main {

    public static void main(String[] args) {
        
        Almacen unAlmacen = new Almacen();
        Empaquetador unEmpaquetador = new Empaquetador(unAlmacen);
        Transportador unTransportador = new Transportador(unAlmacen);
        Embotellador[] colEmbotelladorA = new Embotellador[6];
        Embotellador[] colEmbotelladorV = new Embotellador[6];

        for (int i = 0; i < 6; i++) {
            colEmbotelladorA[i] = new Embotellador("Agua Saborizada "+i, unAlmacen);
            colEmbotelladorV[i] = new Embotellador("Vino "+i, unAlmacen);
            colEmbotelladorA[i].start();
            colEmbotelladorV[i].start();
        }

        unEmpaquetador.start();
        unTransportador.start();

    }
    
}
