package programacionConcurrente.TrabajoPractico2.EJ5;

class UsoHilos {
    public static void main(String[] args) {

        System.out.println("Hilo principal iniciando.");
        // Primero, construye un objeto unHilo.
        MiHilo mh = new MiHilo("#1");
        // Luego, construye un hilo de ese objeto.
        Thread nuevoHilo = new Thread(mh);
        // Finalmente, comienza la ejecución del hilo.
        nuevoHilo.start();
        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }*/
        System.out.println("Hilo principal finalizado.");

    }
}

/*
 * 5) a) Si quitamos el sleep del main pareciera no cambiar nada, y si quitamos
 *       los 2, lo mismo, pero mas rapido
 *    b) Siempre nos termino antes que el run(), puede suceder ambas cosas, esto
 *       puede pasar por la prioridad en los recursos que elija el CPU
 *    c) 
 */
