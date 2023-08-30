package programacionConcurrente.TrabajoPractico2.EJ1;

public class testeoRecurso {
            
    public static void main (String[] args){


        Cliente juan=new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines=new Cliente ();
        ines.setName ("Ines Garcia");
        ines.start();
        juan.start();
        /*
        *  Cambiar el lugar de los starts no determina quien va a tomar la CPU
        *  primero ni cuanto tiempo se le va a asignar, pero si nunca va a decir
        *  que esta usando recurso antes de decir quien es (por secuencia de
        *  lectura de codigo)
        */
        Recurso.uso();        
        
    }

    /* 
     * RESPUESTAS:
     * 1) a) 2 hilos, 3 si consideramos el main
     *    b) Sirve para saber que metodo se esta ejecutando
     *    c) soyJuan Lopez
     *       en Recurso: SoyJuan Lopez
     *       soyInes Garcia
     *       en Recurso: SoyInes Garcia
     *    d) soyInes Garcia
     *       en Recurso: SoyInes Garcia
     *       en Recurso: Soymain
     *       soyJuan Lopez
     *       en Recurso: SoyJuan Lopez
     */
}