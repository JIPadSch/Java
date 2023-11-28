package PracticaParcial.Ejercicio2;

public class Hidrogeno extends Thread{
    
    private FabricaDeAgua unaFabricaDeAgua;

    public Hidrogeno(FabricaDeAgua unaFabricaDeAgua, int nro){
        super("Hidrogeno: "+nro);
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

            if(this.unaFabricaDeAgua.Hlisto()){
                esAgua = true;
                System.out.println(Thread.currentThread().getName()+" LISTO");
            }

        }

    }



}