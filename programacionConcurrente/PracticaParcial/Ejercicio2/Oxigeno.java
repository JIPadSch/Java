package PracticaParcial.Ejercicio2;

public class Oxigeno extends Thread{

    private FabricaDeAgua unaFabricaDeAgua;

    public Oxigeno(FabricaDeAgua unaFabricaDeAgua, int nro){
        super("Oxigeno: "+nro);
        this.unaFabricaDeAgua = unaFabricaDeAgua;
    }
    
    public void run(){

        boolean esAgua = false;

        while(!esAgua){

            System.out.println(Thread.currentThread().getName()+" vagando por el espacio");

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if(this.unaFabricaDeAgua.Olisto()){
                esAgua = true;
                System.out.println(Thread.currentThread().getName()+" LISTO");
            }

        }
        
    }


}
