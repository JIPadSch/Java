package programacionConcurrente.TrabajoPractico3.EJ7;
import java.util.Random;
public class B  implements Runnable{
    Imprimir imp;
    
    public B (Imprimir a){
        imp=a;
    } 
    public void run(){        
        Random ran=new Random();           
        int cant=ran.nextInt(10)+1;
        imp.imprimeNombre(cant);
    }
    
}
