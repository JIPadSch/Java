package programacionConcurrente.TrabajoPractico4.EJ5;

public class test {

    public static void main(String[] args) {

        GestorImpresoras gestor = new GestorImpresoras(3);
        
        Cliente c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
        c1 = new Cliente("C1", gestor);
        c2 = new Cliente("C2", gestor);
        c3 = new Cliente("C3", gestor);
        c4 = new Cliente("C4", gestor);
        c5 = new Cliente("C5", gestor);
        c6 = new Cliente("C6", gestor);
        c7 = new Cliente("C7", gestor);
        c8 = new Cliente("C8", gestor);
        c9 = new Cliente("C9", gestor);
        c10 = new Cliente("C10", gestor);
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();
    }

}
