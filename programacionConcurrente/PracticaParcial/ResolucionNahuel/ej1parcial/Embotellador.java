package ej1parcial;

public class Embotellador extends Thread {
    Planta planta;
    boolean vino;

    public Embotellador(Planta planta, boolean vino) {
        this.planta = planta;
        this.vino = vino;
    }
    
    public void run() {
        try {
        while (true) {
                if (vino) {
                    planta.empezarVino();
                    Thread.sleep(1000);
                    planta.terminarVino();
                } else {
                    planta.empezarAgua();
                    Thread.sleep(1000);
                    planta.terminarAgua();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
