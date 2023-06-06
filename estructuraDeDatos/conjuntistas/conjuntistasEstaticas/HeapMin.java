package conjuntistas.conjuntistasEstaticas;

public class HeapMin {

    private Comparable[] heap;
    private int ultimo;
    private int TAMANIO = 20;

    public HeapMin() {
        this.heap = new Comparable[TAMANIO];
        this.ultimo = 0; // la posicion 0 nunca es utilizado
    }

    public boolean insertar(Object elem) {
        boolean exito = false;

        if (this.ultimo < TAMANIO) {
            if (this.ultimo == 0) {
                this.heap[1] = (Comparable) elem;
                this.ultimo++;
            } else {
                this.ultimo++;
                this.heap[ultimo] = (Comparable) elem;
                hacerSubir(this.ultimo);
            }
            exito = true;
        }

        return exito;
    }

    private void hacerSubir(int posActual) {
        int posPadre;
        Comparable temp = this.heap[posActual];
        boolean salir = false;

        while (!salir) {
            posPadre = posActual / 2;
            if (posPadre > 0) { // Verificar que el padre tenga una posición válida en el heap
                if (this.heap[posPadre].compareTo(temp) > 0) {
                    this.heap[posActual] = this.heap[posPadre];
                    this.heap[posPadre] = temp;
                    posActual = posPadre; // Actualizar la posición actual al padre
                } else {
                    salir = true;
                }
            } else {
                salir = true;
            }
        }
    }

    public boolean eliminarCima() {
        boolean exito = false;

        if (this.ultimo != 0) {
            // saca la raiz y pone la ultima hoja en su lugar
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            // restablece la propiedad de heap minimo
            hacerBajar(1);
            exito = true;
        }

        return exito;
    }

    private void hacerBajar(int posPadre) {
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;

        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                //temp tiene al menos un hijo interno y lo considera menor

                if (posH < this.ultimo) {
                    //hijo menor tiene hermano derecho

                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        // el hijo derecho es el menor de los dos
                        posH++;
                    }
                }

                //compara al hijo menor con el padre
                if (this.heap[posH].compareTo(temp) < 0) {
                    //el hijo es menor que el padre, los intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    //el padre es menor que sus hijos, esta bien ubicado
                    salir = true;
                }
            } else {
                //el temp es hoja, esta bien ubicado
                salir = true;
            }
        }
    }

    public Object recuperarCima() {
        return (Object) this.heap[1];
    }

    public boolean modificarElemento(Object elem, Object nuevoValor) {
        boolean exito = false;
        int posicion = buscarElemento(elem);

        if (posicion != -1) {
            this.heap[posicion] = (Comparable) nuevoValor;
            reorganizarElemento(posicion);
            exito = true;
        }

        return exito;
    }

    private void reorganizarElemento(int posicion) {
        hacerSubir(posicion);
        hacerBajar(posicion);
    }

    private int buscarElemento(Object elem) {
        for (int i = 1; i <= ultimo; i++) {
            if (this.heap[i].equals(elem)) {
                return i;
            }
        }
        return -1; // El elemento no se encontró en el heap
    }

    public boolean esVacio() {
        return this.heap[1] != null;
    }

    public void vaciar() {
        int i;
        for (i = 1; i <= this.ultimo; i++) {
            this.heap[i] = null;
        }
        this.ultimo = 0;
    }

    public HeapMin clone() {
        HeapMin clon = new HeapMin();
        clon.ultimo = this.ultimo;
        clon.TAMANIO = this.TAMANIO;
        clon.heap = this.heap.clone();
        return clon;
    }

    public String toString() {
        String result = "[";

        for (int i = 1; i <= ultimo; i++) {
            result += this.heap[i];
            if (i != ultimo) {
                result += ", ";
            }
        }

        result += "]";

        return result;
    }
}
