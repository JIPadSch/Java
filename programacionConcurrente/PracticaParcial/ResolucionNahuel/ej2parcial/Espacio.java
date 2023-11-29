package ej2parcial;

import java.util.concurrent.Semaphore;

public class Espacio {
    private Semaphore oxi, hidro;
    private int i, k;

    public Espacio() {
        this.oxi = new Semaphore(2);
        this.hidro = new Semaphore(1);
        k = 0;
        i = 0;
    }

    public void Olisto() throws InterruptedException {
        oxi.acquire();
        hacerAgua();
    }

    public void Hlisto() throws InterruptedException {
        hidro.acquire();
        hacerAgua();
    }

    public void hacerAgua() throws InterruptedException {
        i++;
        if (i  == 3) {
            i = 0;
            k++;
            System.out.println("El agua fue hecha: " + k + " veces.");
            hidro.release(1);
            oxi.release(2);
        }
    }
}
