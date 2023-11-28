package PracticaParcial.Ejercicio2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FabricaDeAgua {

    private int recipienteDeAgua, cantMaxima;
    private ReentrantLock lock;
    private Condition condicionOlisto, condicionHlisto;

    public FabricaDeAgua(int cantMaxima) {
        this.recipienteDeAgua = 0;
        this.cantMaxima = cantMaxima;
        this.lock = new ReentrantLock();
        this.condicionHlisto = lock.newCondition();
        this.condicionOlisto = lock.newCondition();
    }

    // Metodo que hacer agua y si se llena el recipiente envasa, despacha y vacia
    private void HacerAgua() {

        if (lock.tryLock()) {

            try {

                try {

                    System.out.println("HACIENDO AGUA");
                    Thread.sleep(2000);
                    System.out.println("LISTO");

                    System.out.println("Agregando AGUA al RECIPIENTE");
                    Thread.sleep(1000);
                    System.out.println("AGUA EN EL RECIPIENTE");
                    recipienteDeAgua++;

                    if (recipienteDeAgua == cantMaxima) {

                        System.out.println("SE LLENO EL RECIPIENTE. DISTRIBUYENDO");
                        Thread.sleep(5000);
                        System.out.println("DISTRIBUIDO. VACIANDO RECIPIENTE");
                        recipienteDeAgua = 0;
                        System.out.println("VACIADO");

                    }

                } catch (Exception e) {
                    // TODO: handle exception
                }

            } finally {
                lock.unlock();
            }

        }

    }

    //Metodo que pone en estado de LISTO a un Oxigeno, devuelve true/false segun si lo logro o no
    public boolean Olisto() {

        boolean listo = false;

        if (lock.tryLock()) { // Intenta tomar el lock

            if (lock.getWaitQueueLength(condicionOlisto) < 1) { // Si no hay Oxigenos esperando entra

                listo = true; // Al finalizar devolvera true

                if (lock.getWaitQueueLength(condicionHlisto) == 2) { // Si hay 2 Hidrogenos esperando
                    condicionHlisto.notifyAll(); // Los despierta para que terminen su proceso
                    HacerAgua(); // Y llama a HacerAgua
                } else { // Si no hay 2 Hidrogenos esperando
                    try {
                        condicionOlisto.await(); // Espera a que lo despierten
                        HacerAgua(); // Y luego llama a HacerAgua
                    } catch (Exception e) {
                        // Excepcion
                    }
                }

            }

        } // Si falla devuelve false

        return listo;

    }

    //Metodo que pone en estado de LISTO a un Hidrogeno, devuelve true/false segun si lo logro o no
    public boolean Hlisto() {

        boolean listo = false;

        if (lock.tryLock()) { // Intenta tomar el lock

            if (lock.getWaitQueueLength(condicionHlisto) < 2) { // Verifica que no haya 2 Hidrogenos ya esperando

                listo = true;

                if (lock.getWaitQueueLength(condicionHlisto) == 1) {// Si ya hay 1 Hidrogeno
                    if(lock.getWaitQueueLength(condicionOlisto) == 1){ //Si ya hay Oxigeno esperando
                        condicionOlisto.notify(); //Despertamos el Oxigeno
                    }else{
                        try {
                            condicionHlisto.await();
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                } else { //Si no hay un Hidrogeno
                    try {
                        condicionHlisto.await(); //Espera a que lo despierten
                    } catch (Exception e) {
                        // Excepcion
                    }
                }

            }

        } // Si falla, devuelve false

        return listo;

    }

}