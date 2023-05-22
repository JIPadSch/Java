public class Cola {

    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 20; //Ejemplo

    public Cola(){
        this.arreglo = new Object[TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object nuevoElemento){
        boolean exito = false;
       if(((this.fin+1)% TAMANIO) != this.frente){ // si no esta lleno.
        this.arreglo[this.fin] = nuevoElemento;
        this.fin = (this.fin +1)% TAMANIO;
        exito = true;
       } 
        return exito;
    }

    public boolean sacar(){
        boolean exito=true;
        if(this.frente == this.fin){ // si esta vacia.
            exito=false;
        }else{ 
            this.arreglo[this.frente] = null;
            this.frente = (this.frente+1)% TAMANIO;
        }
        return exito;
    }

    public Object obtenerFrente(){
        Object objDevolver = null; //Obheto a devolver
        if(this.frente != this.fin){ //Si NO esta vacio
            objDevolver = this.arreglo[this.frente]; //Guardamos el frente
        }
        return objDevolver;
    }

    public boolean esVacio(){
        return this.frente == this.fin; //Si son iguales, ES vacio
    }

    public void vaciar(){
        if(this.frente != this.fin){ //Si NO esta vacia
            for (-- this.frente; this.frente < this.fin; this.frente = ((this.frente+1) % TAMANIO)){
                this.arreglo[this.frente] = null;
            }
        }
    }

    @Override
    public Cola clone(){
        Cola colaClon = new Cola();
        colaClon.arreglo = this.arreglo.clone();
        colaClon.frente = this.frente;
        colaClon.fin = this.fin;
        return colaClon;
    }

    @Override
    public String toString(){
        String texto = "";
        if(this.frente != this.fin){
            texto = "[\n";
            for (-- this.frente; this.frente < this.fin; this.frente = ((this.frente+1) % TAMANIO)){
                texto += (String)this.arreglo[this.frente]+"\n";
            }
            texto += "]";
        }else{
            texto = "Esta vacio";
        }
        return texto;
    }

}