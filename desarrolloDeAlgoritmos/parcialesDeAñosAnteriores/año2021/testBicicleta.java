package desarrolloDeAlgoritmos.parcialesDeAñosAnteriores.año2021;
import java.util.*;
public class testBicicleta {
    /*
    Implementar en Java la clase TestBicicleta en la que se defina un
    metodo main que haga uso de la clase Bicicleta. Se debe definir un arreglo de
    bicletas, el método que realiza la carga del arreglo y métodos para:
    a) Un método que permita recuperar la bicicleta con mayor precio de venta.
    b) Un método que muestre por pantalla los datos de las bicicleta de montaña
    cuyas marcas tengan más de dos vocales.
    */
    public static void main(String[] args) {
        int longitud=verificarLongitud();
        Bicicleta[] arrBicis = new Bicicleta [longitud];
        for (int i = 0; i < arrBicis.length; i++) {
            System.out.println("Ingrese los datos de la bici "+(i+1));
            arrBicis[i]=cargarBicicleta(arrBicis);
        }
        System.out.println("La bicicleta con mayor precio es: \n"+arrBicis[bicicletaMayorPrecio(arrBicis)].toString());
        System.out.println("Las bicicletas de montaña con dos vocales o más en su marca es/son: ");
        mostrarDatosBiciMontañaConMasDosVocales(arrBicis);
    }
    /* Modulo para verificar la longitud */
    public static int verificarLongitud(){
        Scanner scan = new Scanner(System.in);
        int longitud;
        do{
            System.out.println("Ingrese la cantidad de bicicletas: ");
            longitud=scan.nextInt();
            if(longitud<=0){
                System.out.println("ERROR: La longitud no puede ser menor o igual a 0");
            }
        }while(longitud<=0);
        return longitud;
    }
    /* Metodo de carga de Bicicleta */
    public static Bicicleta cargarBicicleta(Bicicleta[] arrBicis){
        Scanner scan = new Scanner (System.in);
        Bicicleta otraBici = new Bicicleta(0);
        int numeroSerie, cantCambios;
        String marca,letrasTipoBici="mcuoMCUO", letrasCharSeguro="snSN";
        char tipoBici, charSeguro;
        double precio;
        boolean seguroFabrica=false;
        do{
            System.out.println("Ingrese el numero de serie: ");
            numeroSerie = scan.nextInt();
            scan.nextLine();
            otraBici = new Bicicleta(numeroSerie);
            if(!verificarLlaveBicicleta(arrBicis,otraBici)){
                System.out.println("ERROR: El numero de serie ya existe"); 
            }
        }while(!verificarLlaveBicicleta(arrBicis,otraBici));
        System.out.println("Ingrese la marca: ");
        marca=scan.nextLine();
        scan.nextLine();
        do{
            System.out.println("Ingrese la cantidad de cambios: ");
            cantCambios=scan.nextInt();
            scan.nextLine();
            if(cantCambios<=0){
                System.out.println("ERROR: Los cambios no pueden ser menores a 0");
            }
        }while(cantCambios<0);
        do{
            System.out.println("Ingrese el tipo de bici: ");
            System.out.println("Tipos de bici: 'M' Montaña, 'C' Carrera, 'U' Urbano, 'O' Otros");
            tipoBici=scan.next().charAt(0);
            scan.nextLine();
            if(letrasTipoBici.indexOf(tipoBici)<0){ 
                /*
                *  Index of cuando devuelve -1, no encontro ese char en el Str, entonces,
                *  si es menor a 0, no existe
                */
                System.out.println("ERROR: El tipo de bici no existe");
            }
        }while(letrasTipoBici.indexOf(tipoBici)<0);
        do{
            System.out.println("Ingrese el precio de la bici: ");
            precio=scan.nextDouble();
            scan.nextLine();
            if(precio<0){
                System.out.println("ERROR: El precio no puede ser menor a 0");
            }
        }while(precio<0);
        do{
            System.out.println("La bici ¿tiene seguro de fábrica?: (S/N)");
            charSeguro = scan.next().charAt(0);
            scan.nextLine();
            if(letrasCharSeguro.indexOf(charSeguro)<0){
                System.out.println("ERROR: La opcion debe ser S o N");
            }
        }while(letrasCharSeguro.indexOf(charSeguro)<0);
        if(Character.toUpperCase(charSeguro)=='S'){
            seguroFabrica=true;
        }
        Bicicleta nuevaBici = new Bicicleta(numeroSerie,marca,cantCambios,tipoBici,precio,seguroFabrica);
        return nuevaBici;
    }
    /* Equals en arreglo de Bicis */
    public static boolean verificarLlaveBicicleta(Bicicleta[] arrBicis, Bicicleta otraBici){
        boolean esUnico=false, continuar=true;
        int i=0;
        while(continuar && i<arrBicis.length){
            if(arrBicis[i] == null){
                esUnico=true;
                continuar=false;
            } else if(arrBicis[i].equals(otraBici)){
                continuar=false;
            }
            i++;
        }
        return esUnico;
    }
    /* Metodo que permita recuperar la bicicleta con mayor precio de venta */
    public static int bicicletaMayorPrecio(Bicicleta[] arrBicis){
        int pos=0;
        double precioMayor=0;
        for (int i = 0; i < arrBicis.length; i++) {
            if(arrBicis[i].getPrecio()>precioMayor){
                precioMayor=arrBicis[i].getPrecio();
                pos=i;
            }
        }
        return pos;
    }
    /* Metodo que muestra por pantalla los datos de las bicicletas de montaña cuyas marcas tengan más de dos vocales */
    public static void mostrarDatosBiciMontañaConMasDosVocales(Bicicleta[] arrBicis){
        for (int i = 0; i < arrBicis.length; i++) {
            if(arrBicis[i].getTipoBici()=='M'){
                if(verificarVocales(arrBicis[i].getMarca())){
                    System.out.println(arrBicis[i].toString());
                }
            }
        }
    }
    /* Modulo para verificar si una marca tiene mas de dos vocales */
    public static boolean verificarVocales(String marca){
        int contador=0, i=0;
        String letrasVocales="aeiouAEIOU";
        boolean masDeDosVocales=false;
        while (contador<3 && i<marca.length()){
            if (letrasVocales.indexOf(marca.charAt(i))>-1){ 
                /*
                *  indexOf cuando devuelve -1, no encontro ese char en el Str,
                *  por ende, si es mayor, lo encontro y sumamos 1
                */
                contador+=1;
            }
            i++;
        }
        if (contador>=3){
            masDeDosVocales=true;
        }
        return masDeDosVocales;
    }
}