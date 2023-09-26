package programacionConcurrente.TrabajoPractico3.EJ7;

public class Main {
    public static void main(String[] args) {
        Imprimir imp = new Imprimir();
        A a = new A(imp);
        B b = new B(imp);
        C c = new C(imp);

        Thread uno = new Thread(a, "A");
        Thread dos = new Thread(b, "B");
        Thread tres = new Thread(c, "C");

        uno.start();
        dos.start();
        tres.start();

        try {
            uno.join();
            dos.join();
            tres.join();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println();

    }

}
