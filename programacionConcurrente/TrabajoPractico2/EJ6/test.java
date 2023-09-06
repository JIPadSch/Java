package programacionConcurrente.TrabajoPractico2.EJ6;

public class test {

    public static void main(String[] args) {
        
        Corredor arrCorr[] = new Corredor[2];
        arrCorr[0] = new Corredor("Juan");
        arrCorr[1] = new Corredor("Emi");

        Thread h1, h2;
        h1 = new Thread(arrCorr[0]);
        h2 = new Thread(arrCorr[1]);

        h1.start();
        h2.start();

        System.out.println(arrCorr[0].toString());
        System.out.println(arrCorr[1].toString());
        
    }
    
}
