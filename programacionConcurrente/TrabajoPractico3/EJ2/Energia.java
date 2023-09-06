package programacionConcurrente.TrabajoPractico3.EJ2;

public class Energia {

    int cantEnergia;

    public Energia(){
        cantEnergia = 10;
    }

    public synchronized int getCantEnergia(){
        return cantEnergia;
    }

    public synchronized void modificarEnergia(Thread hilo){
        
        if(hilo.getName().equals("Criatura Oscura")){
            cantEnergia -= 3;
            System.out.println("La Criatura Oscura accedio a la Energia, le quito 3 de vida y ahora tiene "+cantEnergia);
        }else if(hilo.getName().equals("Sanador")){
            cantEnergia += 3;
            System.out.println("El Sanador accedio a la Energia, le sumo 3 de vida y ahora tiene "+cantEnergia);
        }
        
        
    }
}
