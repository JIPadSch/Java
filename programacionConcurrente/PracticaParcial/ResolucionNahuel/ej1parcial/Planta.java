package ej1parcial;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Planta {
    private int almacen, vinos, aguas;
    private ReentrantLock empaquetador, repartidor;
    private Condition empaquetar, repartir;
    public Planta() {
        this.almacen = 0;
        this.vinos = 0;
        this.aguas = 0;

        this.empaquetador = new ReentrantLock();
        this.repartidor = new ReentrantLock();

        this.empaquetar = empaquetador.newCondition();
        this.repartir = repartidor.newCondition();
    }

    public void empezarVino(){}

    public void terminarVino(){
        empaquetador.lock();
        vinos++;
        System.out.println("Un vino mas");
        empaquetar.signal();
        empaquetador.unlock();
    }

    public void empezarAgua(){}

    public void terminarAgua(){
        empaquetador.lock();
        aguas++;
        System.out.println("Un agua mas");
        empaquetar.signal();
        empaquetador.unlock();
    }

    public void empezarEmpaquetado() throws InterruptedException{
        empaquetador.lock();
        while (vinos < 10 || aguas < 10) {
            empaquetar.await();
            System.out.println("Empaquetador: Vinos:" + vinos + " y Aguas: " + aguas);
        }
        System.out.println("Alguna caja se lleno");
        if(vinos == 10) {
            System.out.println("La caja de vinos se lleno");
            vinos = 0;
            almacen++;
        } 
        if (aguas == 10) {
            System.out.println("La caja de agua se lleno");
            aguas = 0;
            almacen++;
        }
    }
    
    public void terminarEmpaquetado(){
        empaquetador.lock();
        repartidor.lock();
        repartir.signal();
        repartidor.unlock();
        empaquetador.unlock();
    }

    public void transportar() throws InterruptedException{
        repartidor.lock();
        while (almacen != 10) {
            System.out.println("Transportador: Almacen " + almacen);
            repartir.await();
        }
        System.out.println("EL ALMACEN SE LLENO");
        System.out.println("El repartidor vacia el almacen");
        almacen = 0;
    }
}
