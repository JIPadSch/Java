package ej2parcial;

public class Oxigeno extends Thread {
    private Espacio esp;

    public Oxigeno(Espacio esp) {
        this.esp = esp;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.print("o");
            esp.Olisto();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
