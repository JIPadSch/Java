package PracticaParcial.Ejercicio1.Semaforos;

public class Transportador extends Thread{

    private Almacen unAlmacen;

    public Transportador (Almacen unAlmacen){
        this.unAlmacen = unAlmacen;
    }

    public void run(){
        while (true) {
            this.unAlmacen.transportar();
        }
    }
    
}
