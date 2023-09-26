package programacionConcurrente.TrabajoPractico4.EJ1;

public class SynchronizedObjectCounter {
    
    private int c = 0;

    public void increment() {
        synchronized (this) {
            c++; // Este elemento debe ser casteado a Integer
        } 
    }

    public void decrement() {
        synchronized (this) {
            c--;
        }
    }

    public int value() {
        return c;
    }
}
