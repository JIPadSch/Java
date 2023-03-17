package estructuraDeDatos;

public class Pila {
    
    private Object[] pila;
    private int tope;
    private static final int tamanio = 20; //ejemplo

    /* CONSTRUCTOR */
    public Pila(){
        this.pila = new Object[tamanio];
        this.tope = -1;
    }

    public boolean apilar(Object unObjeto){
        boolean sePudoApilar = true;

        if(this.tope+1 >= this.tamanio){
            sePudoApilar = false;
        }else{
            this.pila[this.tope+1] = unObjeto;
        }

        return sePudoApilar;
    }

    public boolean desapilar(){
        boolean sePuedeDesapilar = true;

        if(this.tope > -1){
            this.pila[this.tope] = null;  
            this.tope--;          
        }else{
            sePuedeDesapilar = false;
        }

        return sePuedeDesapilar;
    }

    public Object obtenerElementoTope(){
        Object elementoTope = new Object();

        if(this.tope != -1){
            elementoTope = this.pila[this.tope];
        }else{
            elementoTope = null;
        }

        return elementoTope;
    }

    public boolean esVacio(){
        boolean estaVacio = false;

        if(this.tope == -1){
            estaVacio = true;
        }

        return estaVacio;
    }

    public void vaciar(){

        for (int i = this.tope; i > -1; i--) {
            this.pila[i] = null;
        }
        tope = -1;

    }

    public Pila clone(){
        Pila pilaClonada = new Pila();

        pilaClonada = this.pila.clone();

        return pilaClonada;
    }

    public String toString(){
        String mensaje = "";
        if(this.tope > -1){

        }else{
            mensaje = "La Pila está vacia";
        }

        return mensaje;
    }

}
