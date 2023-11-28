package PracticaParcial.Ejercicio2;

public class Main {

    public static void main(String[] args) {

        FabricaDeAgua unaFabricaDeAgua = new FabricaDeAgua(5);
        GeneradorHyO unGeneradorHyO = new GeneradorHyO(unaFabricaDeAgua);

        unGeneradorHyO.start();

    }
    
}
