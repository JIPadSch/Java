package programacionConcurrente.TrabajoPractico1;
import libreriaJuanIPadSch.Entrada;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);
        int opcion = 0;

        do{
            
            System.out.println("-------------------------------");
            System.out.println("Elija una opcion del 0 al x:");
            System.out.println("0: Salir del programa");
            System.out.println("1: Punto 5");
            System.out.println("2: Punto 6");
            System.out.println("3: Punto 6 MODIFICADO");
            System.out.println("-------------------------------");
            opcion = ent.nextInt();
            menu(opcion);
            
        }while(opcion != 0);
        
        
    }

        //Menu
        public static void menu(int opcion){
            switch (opcion) {
                case 1:
                    punto5();
                    break;
                case 2:
                    double [] v = new double [15];
                    acceso_por_indice (v, 16);
                    break;
                case 3:
                    double [] w = new double [15];
                    acceso_por_indiceV2 (w, 16);
                    break;
                default:
                    System.out.println("ERROR: No es una opcion valida");
                    break;
            }
        }

        //Punto 5
        public static void punto5(){
            String aux = "hola";
            int aux2 = Integer.parseInt (aux);
        }
    
        //Punto 6
        public static double acceso_por_indice (double [] v, int j) throws RuntimeException{
            try{
                if ((0 <= j) && (j <= v.length)){
                    return v[j];
                }else {
                    throw new RuntimeException ("El indice " + j + " no existe en el vector");
                }
            } catch (RuntimeException exc){
                throw exc;
            }
        }

        //Punto 6 MODIFICADO
        public static double acceso_por_indiceV2 (double [] v, int j) throws RuntimeException{
            double retorno = 0;

            try{

                retorno = v[j];

            } catch (RuntimeException exc){
                System.out.println("El indice " + j + " no existe en el vector");
                throw exc;
            }
            
            return retorno;
        }
}
