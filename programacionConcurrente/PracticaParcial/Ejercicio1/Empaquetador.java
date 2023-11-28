package PracticaParcial.Ejercicio1;

public class Empaquetador extends Thread{

    private Almacen unAlmacen;

    public Empaquetador (Almacen unAlmacen){
        this.unAlmacen = unAlmacen;
    }

    public void run(){
        while (true) {
            this.unAlmacen.empaquetar();
        }
    }
    
}
