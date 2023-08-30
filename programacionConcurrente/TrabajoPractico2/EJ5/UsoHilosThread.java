package programacionConcurrente.TrabajoPractico2.EJ5;

public class UsoHilosThread {
    public static void main(String[] args) {

        System.out.println("Hilo principal iniciando.");
        // Primero, construye un objeto unHilo.
        new MiHiloThread("#1").start();
        new MiHiloThread("#2").start();
        new MiHiloThread("#3").start();

        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }
        /*
         * try {
         * Thread.sleep(100);
         * } catch (InterruptedException exc) {
         * System.out.println("Hilo principal interrumpido.");
         * }
         */
        System.out.println("Hilo principal finalizado.");

    }

    /*
     * Al ejecutarlo varias veces con 3 hios diferentes se ejecutaron en el orden al
     * que accedian a su tiempo en
     * de memoria. Vemos en el siguiente ejemplo que el hilo 2 perdio su tiempo en
     * memoria, comenzo el hilo 3, termino el hilo 3 y luego
     * termino el hilo 2.
     * Comenzando #1
     * En #1, el recuento 0
     * En #1, el recuento 1
     * En #1, el recuento 2
     * En #1, el recuento 3
     * En #1, el recuento 4
     * En #1, el recuento 5
     * En #1, el recuento 6
     * En #1, el recuento 7
     * En #1, el recuento 8
     * En #1, el recuento 9
     * Terminando #1
     * . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
     * . . . . . . . . . . .Hilo principal finalizado.
     * Comenzando #2
     * En #2, el recuento 0
     * En #2, el recuento 1
     * En #2, el recuento 2
     * En #2, el recuento 3
     * En #2, el recuento 4
     * En #2, el recuento 5
     * En #2, el recuento 6
     * En #2, el recuento 7
     * Comenzando #3
     * En #3, el recuento 0
     * En #3, el recuento 1
     * En #3, el recuento 2
     * En #3, el recuento 3
     * En #3, el recuento 4
     * En #3, el recuento 5
     * En #3, el recuento 6
     * En #3, el recuento 7
     * En #3, el recuento 8
     * En #3, el recuento 9
     * Terminando #3
     * En #2, el recuento 8
     * En #2, el recuento 9
     * Terminando #2
     */
}
