package programacionConcurrente.TrabajoPractico2.EJ4;

public class test {
    
    public static void main (String [] args) {

        for (int i = 0; i < 10; i++) {
            
            ThreadEjemplo mj = new ThreadEjemplo("Maria Jose");
            ThreadEjemplo jm =  new ThreadEjemplo("Jose Maria");
            Thread t1 = new Thread(mj);
            Thread t2 = new Thread(jm);
            t1.run();
            t2.run();
            System.out.println("Termina thread main");            
        }

    }

    /*
     * 4) Deberia suceder lo mismo que en el ejercicio anterior, de todas maneras,
     *    lo ejecutamos varias veces y la prioridad de hilos parecio haber cambiado,
     *    porque no empezaba uno sin haber terminado el otro. Y si, es necesario hacer
     *    el constructor porque no hereda ningun constructor, ya que no es sublcase de 
     *    Thread, sino que implementa la interfaz Runnable
    */
     
}