package PracticaParcial.Ejercicio1;

public class Embotellador extends Thread{

    private Almacen unAlmacen;

    public Embotellador (String nombre, Almacen unAlmacen){
        super(nombre);
        this.unAlmacen = unAlmacen;
    }

    public void run(){
        while (true) {
            this.unAlmacen.embotellar();
        }
    }
    
}
