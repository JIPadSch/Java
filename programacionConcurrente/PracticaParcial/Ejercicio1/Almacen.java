package PracticaParcial.Ejercicio1;

import java.util.concurrent.Semaphore;

public class Almacen {

    private char embotellando = 'A';
    private int contadorCajas = 0;
    private boolean cajasListas = false;
    private Semaphore caja = new Semaphore(10);

    public void embotellar(){

        if(Thread.currentThread().getName().charAt(0) == 'A' && embotellando == 'A'){ 

            if(caja.tryAcquire()){
                System.out.println("El Embotellador "+Thread.currentThread().getName()+" esta embotellando");
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }else if (Thread.currentThread().getName().charAt(0) == 'V' && embotellando == 'V'){

            if(caja.tryAcquire()){
                System.out.println("El Embotellador "+Thread.currentThread().getName()+" esta embotellando");
                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

    }

    public void empaquetar(){

        if(caja.availablePermits() == 0){

            System.out.println("El Empaquetador esta empaquetando");

            try {
                Thread.sleep(2000); //Simulacion de empaquetado
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("El Empaquetador termino de empaquetar");

            System.out.println("Habilitando nueva caja");
            //Habilitamos caja nueva pero cambiamos que se embotella
            if(embotellando == 'A'){
                embotellando = 'V';
            }else{
                embotellando = 'A';
            }

            contadorCajas++;

            if(contadorCajas == 10){
                cajasListas = true;
            }else{
                System.out.println("CAJA HABILITADA POR EMPAQUETADOR");
                caja.release(10);
            }
        }

    }

    public void transportar(){

        if(cajasListas){

            System.out.println("El Transportador se esta llevando las cajas");
            contadorCajas = 0;
            cajasListas = false;
            
            System.out.println("CAJA HABILITADA POR TRANSPORTADOR");
            caja.release(10);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("El transportador ah vuelto y ya esta disponible para llevarse más cajas");
        }
        
    }
    
}
