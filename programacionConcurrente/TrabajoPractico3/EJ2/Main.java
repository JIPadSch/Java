package programacionConcurrente.TrabajoPractico3.EJ2;

public class Main {

    public static void main(String[] args) {

        Thread h1, h2;
        h1 = new Thread("Criatura Oscura");
        h2 = new Thread("Sanador");
        Energia energia = new Energia();

        h1.start();
        h2.start();
        
        int aleatorio = 0;
        
        for (int i = 0; i < 10; i++) {

            aleatorio = (int)(Math.random() * 10) + 1;

            if(aleatorio <= 5){
                energia.modificarEnergia(h1);
            }else if(aleatorio > 5){
                energia.modificarEnergia(h2);
            }           
            
        }

        System.out.println("La Energia termino en: "+energia.getCantEnergia());

    }
    
}
