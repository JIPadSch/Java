package ej2parcial;

public class Hidrogeno extends Thread{
    private Espacio esp;

    public Hidrogeno(Espacio esp) {
        this.esp = esp;
    }

    public void run() {
        try {
            System.out.print("h");
            esp.Hlisto();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
