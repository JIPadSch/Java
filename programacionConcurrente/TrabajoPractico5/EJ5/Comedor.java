package programacionConcurrente.TrabajoPractico5.EJ5;

import java.util.concurrent.Semaphore;

public class Comedor {

    private int cantComederos;
    private int contador; //Nos manejan el orden para que no coman especies distintas juntas
    private Semaphore comenPerros, comenGatos; //Semaforos genericos que nos dice cuantos comederos tenemos disponibles
    
    public Comedor(int cantComederos){
        this.cantComederos = cantComederos;

        contador = 0; //false es perros, true es gatos

        comenPerros = new Semaphore(cantComederos);
        comenGatos = new Semaphore(0);
    }

    public void comer() throws Exception{

        if(Thread.currentThread().getName().charAt(0) == 'P'){ //Si es perro

            comenPerros.acquire();
            System.out.println("El "+Thread.currentThread().getName()+" está comiendo");
            //Thread.sleep(2000); //Simulamos que come
            contador++;
            
            if(contador == cantComederos && comenGatos.availablePermits() == 0){
                comenGatos.release(cantComederos);
            }
            

        }else{ //Si es gato

            comenGatos.acquire();
            System.out.println("El "+Thread.currentThread().getName()+" está comiendo");
            //Thread.sleep(2000); //Simulamos que come
            contador--;
            
            if(contador == 0 && comenPerros.availablePermits() == 0){
                comenPerros.release(cantComederos);
            }

        }

    }

}
