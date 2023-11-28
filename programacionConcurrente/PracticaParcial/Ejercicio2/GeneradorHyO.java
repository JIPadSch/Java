package PracticaParcial.Ejercicio2;

public class GeneradorHyO extends Thread{

    private FabricaDeAgua unaFabricaDeAgua;

    public GeneradorHyO(FabricaDeAgua unaFabricaDeAgua){
        this.unaFabricaDeAgua = unaFabricaDeAgua;
    }

    public void run(){

        int i = 0;

        while(i < 10) {

            Oxigeno unOxigeno = new Oxigeno(unaFabricaDeAgua,i);
            Hidrogeno unHidrogeno = new Hidrogeno(unaFabricaDeAgua,i);
            Hidrogeno otroHidrogeno = new Hidrogeno(unaFabricaDeAgua,i+1);

            i++;
            
            unOxigeno.start();
            unHidrogeno.start();
            otroHidrogeno.start();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            
            
        }

    }
    
    
}
