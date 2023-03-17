package estructuraDeDatos;

public class Pila {
    
    private Object[] arreglo;
    private int tope;
    private static final int tamanio = 20; //ejemplo

    /* CONSTRUCTOR */
    public Pila(){
        this.arreglo = new Object[tamanio];
        this.tope = -1;
    }

    public boolean apilar(Object unObjeto){
        boolean sePudoApilar = true;

        if(this.tope+1 >= this.tamanio){
            sePudoApilar = false;
        }else{
            this.arreglo[this.tope+1] = unObjeto;
        }

        return sePudoApilar;
    }

    public boolean desapilar(){
        boolean sePuedeDesapilar = true;

        if(this.tope > -1){
            this.arreglo[this.tope] = null;  
            this.tope--;          
        }else{
            sePuedeDesapilar = false;
        }

        return sePuedeDesapilar;
    }

    public Object obtenerElementoTope(){
        Object elementoTope = new Object();

        if(this.tope != -1){
            elementoTope = this.arreglo[this.tope];
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
            this.arreglo[i] = null;
        }
        tope = -1;

    }

    public Pila clone(){
        Pila copiaArreglo = new Pila();

        copiaArreglo.arreglo = this.arreglo.clone();
        copiaArreglo.tope = this.tope;

        return copiaArreglo;
    }

    public String toString(){
        String mensaje = "";

        if(this.tope > -1){
            for (int i = 0; i < this.tope; i++) {
                mensaje += "Posición "+i+": "+this.arreglo[i].toString()+"\n";
            }
        }else{
            mensaje = "La Pila está vacia";
        }

        return mensaje;
    }

}
