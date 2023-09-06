package programacionConcurrente.TrabajoPractico3.EJ2;

public class Main {

    public static void main(String[] args) {

        CriaturaOscura h1 = new CriaturaOscura();
        Sanador h2 = new Sanador();
        Energia energia = new Energia();

        h1.start();
        h2.start();
        
        for (int i = 0; i < 10; i++) {
            
            
        }

        System.out.println("La Energia termino en: "+energia.getCantEnergia());

    }
    
}
