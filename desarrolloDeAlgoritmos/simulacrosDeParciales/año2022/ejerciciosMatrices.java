package desarrolloDeAlgoritmos.simulacrosDeParciales.año2022;
import java.util.*;
import libreriaJuanIPadSch.arreglosBidi;
/**
 *
 * @author JuanPadSch
 */
public class ejerciciosMatrices {
    /* 
    *  Dada una matriz de mediciones mensuales (matriz de 4x12) de lluvias por 4 años determinar expresada en ml:
    *  a.Generar un arreglo de promedios anuales de lluvias
    *  b.Identificar si existe algún mes de algún año cuya medición sea 0
    *  c.Sumar las mediciones de Marzo de los últimos 3 años
    *  d.Generar una arreglo con la suma de las lluvias de los meses impares
    */
   public static void main(String[] args) {
       Double[][] medicionesLluvia = new Double[4][12]; //4 años x 12 meses
       System.out.println("Trabajaremos con estas mediciones: ");
       libreriaJuanIPadSch.arreglosBidi.cargarAutoMatrizCuadradaDoubles(medicionesLluvia);
       Double[] promedioAnualesLluvia = promedioLluviaAnual(medicionesLluvia);
       System.out.println("Promedios anuales de lluvias: "+promedioAnualesLluvia.toString());
   }
   /* Módulo que genera un arreglo de promedios anuales de lluvias */
   public static Double[] promedioLluviaAnual(Double[][] medicionesLluvia){
       Double[] promedioAnual = new Double[4];
       for (int i = 0; i < medicionesLluvia.length; i++) {
           for (int j = 0; j < medicionesLluvia[0].length; j++) {
               promedioAnual[i] += medicionesLluvia[i][j];
           }
       }
       return promedioAnual;
   }
   /* Módulo que identifica si existe algún mes de algún año cuya medición sea 0 */
   public static boolean existeMedicionCero(Double[][] medicionesLluvias){
       boolean hayConCero=false;
       int i=0, j=0;
       while(!hayConCero && i<medicionesLluvias.length){
           j=0;
           while(!hayConCero && j<medicionesLluvias[0].length){
               if(medicionesLluvias[i][j] == 0) hayConCero=true;
               j++;
           }
           i++;
       }
       return hayConCero;
   }
   /* Módulo que suma las mediciones de Marzo de los últimos 3 años */
   public static double medicionesMarzoUltimos3Años(Double[][] medicionesLluvias){
       double totalMedicionesMarzoUltimos3Años=0;
       for (int i = 1; i < medicionesLluvias.length; i++) {
           totalMedicionesMarzoUltimos3Años += medicionesLluvias[i][3];
       }
       return totalMedicionesMarzoUltimos3Años;
   }
   /* Módulo que genera un arreglo con las suma de las lluvias de los meses impares */
   public static Double[] sumaLluviaMesesImpares(Double[][] medicionesLluvias){
       Double[] lluviaMesesImpares = new Double [(medicionesLluvias.length)/2];
       for (int i = 0; i < lluviaMesesImpares.length; i=i+2) {
           for (int j = 0; j < lluviaMesesImpares.length; j=j+2) {
               lluviaMesesImpares[(i-1)] += medicionesLluvias[i][j];
           }
       }
       return lluviaMesesImpares;
   }
}