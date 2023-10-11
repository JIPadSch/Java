package programacionConcurrente.TrabajoPractico3.EJ3;

public class Main {

    public static void main(String[] args) {
        Comedero c = new Comedero();
        Descansar d = new Descansar();
        Rodar r = new Rodar();
        Jaula jaula = new Jaula(c, d, r);

        Hamster h1 = new Hamster(jaula,"Hamster 1");
        Hamster h2 = new Hamster(jaula,"Hamster 2");
        Hamster h3 = new Hamster(jaula,"Hamster 3");

        h1.start();
        h2.start();
        h3.start();
    }
    
    
}
