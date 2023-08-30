package programacionConcurrente.TrabajoPractico2.EJ2;

class TesteoHilos{
    public static void main (String[] args){

        for (int i = 0; i < 100; i++) {
            Thread miHilo= new MiEjecucion();
            miHilo.start();
            System.out.println("En el main");
            try {
                miHilo.join();    
            } catch (Exception e) {
                // TODO: handle exception
            }
            
        }
        

    }

    /*
     * 2) a) En general lo hace primero "en el main" y dsp "en la pila", es decir
     *       empieza el run de miHilo pero no termina de ejecutarse y le da CPU al main,
     *       en otras ocasiones (cuando lo hacemos mas veces) encontramos que aveces se 
     *       imprime 2 veces seguidas el main, y dsp 2 veces la pila, o intercalado
     *    b) Si se podria obligar a que siempre haga "En el main" y dsp "En la pila" con un join,
     *       pero tmb al revez si asi quisiera. Con un sleep tmb se podria hacer, pero no es
     *       garantizado, ya que dependemos de que la CPU le de recursos al hilo que queremos
     */
}