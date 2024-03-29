package ej1parcial;

public class Empaquetador extends Thread {
    Planta planta;

    public Empaquetador(Planta planta) {
        this.planta = planta;
    }

    public void run() {
        try {
            while (true) {
                planta.empezarEmpaquetado();
                Thread.sleep(2000);
                planta.terminarEmpaquetado();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
