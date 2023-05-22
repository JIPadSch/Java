package conjuntistas.conjuntistasEstaticas;

public class HeapMin {

    /* ATRIBUTOS */
    private static final int TAMANIO = 20;
    private Comparable[] heap = new Comparable[TAMANIO-1];
    private int ultimo = 0;

    /* CONSTRUCTOR */
    public HeapMin(){

    }

    /* METODOS DE CLASE */
    public boolean insertar(Object elemento){
        boolean exito;

        if(this.ultimo == 0){
            //estructura vacia
            exito = false;
        }else{
            //saca la raiz y pone la ultima hoja en su lugar
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            //reestablece la propiedad de heap minimo
            hacerBajar(1);
            exito = true;
        }

        return exito;
    }

    private void hacerBajar(int posPadre){
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;

        while(!salir){
            posH = posPadre * 2;

            if(posH <= this.ultimo){
                //temp tiene al menos un hijo (izq) y lo considera menor

                if(posH < this.ultimo){
                    //hijoMenor tiene hermano derecho

                    if(this.heap[posH + 1].compareTo(this.heap[posH]) < 0){
                        //el hijo derecho es el menor de los dos
                        posH++;
                    }
                }

                //compara al hijo menor con el padre
                if(this.heap[posH].compareTo(temp) < 0){
                    //el hijo es menor que el padre, los intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                }else{
                    //el padre es menor que sus hijos, está bien ubicado
                    salir = true;
                }
            }
        }

    }

    public boolean eliminarCima(){
        boolean exito = false;

        return exito;
    }

    public Object recuperarCima(){
        return this.heap[1];
    }
    
}