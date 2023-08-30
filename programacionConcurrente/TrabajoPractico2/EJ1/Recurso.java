package programacionConcurrente.TrabajoPractico2.EJ1;

    public class Recurso {

        static void uso(){
            Thread t=Thread.currentThread();
            System.out.println("en Recurso: Soy " + t.getName());
        }
        
    }