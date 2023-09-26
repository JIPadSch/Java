package programacionConcurrente.TrabajoPractico4.EJ3;

import java.util.concurrent.Semaphore;

public class test {

    public static void main(String[] args) {

        Proceso p1, p2, p3;
        Semaphore SEMp0p1, SEMp1p3, SEMp3p2, SEMp2p1;

        SEMp0p1 = new Semaphore(1);
        SEMp1p3 = new Semaphore(0);
        SEMp3p2 = new Semaphore(0);
        SEMp2p1 = new Semaphore(0);

        p1 = new Proceso("P1", SEMp0p1, SEMp1p3);
        p2 = new Proceso("P3", SEMp1p3, SEMp3p2);
        p3 = new Proceso("P2", SEMp3p2, SEMp2p1);
        
        p1.start();
        p2.start();
        p3.start();

    }

}
