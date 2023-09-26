package programacionConcurrente.TrabajoPractico3.EJ7;

import java.util.Random;

public class A  implements Runnable{  
    Imprimir imp;

    public A (Imprimir a){
        imp=a;
    }  
    public void run(){     
        Random ran=new Random();           
        int cant=ran.nextInt(10)+1;
        imp.imprimeNombre(cant);
    }
    
}
