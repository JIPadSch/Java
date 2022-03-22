/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanipadsch.tp1arreglos;

/**
 *
 * @author JuanPadSch
 */
public class Ejercicio12 {
    //Este algoritmo nos permite cargar dos arreglos de números y verifica si son igual o no
    public static void main(String[] args){
        
    }
    //Este módulo permite cargar un arreglo de enteros
    public static void llenarArreglo(int[] arrayDeInt){
        
    }
    //Este módulo verifica si dos arreglos de enteros son iguales y retorna true o false, según corresponda
    public static boolean sonIguales(int[] array1, int[] array2){
        int i=0;
        boolean sonIguales=true;
        if (array1.length==array2.length){
            while (sonIguales==true || i<array1.length){
                if (array1[i]==array2[i]){
                    i++;
                } else{
                    sonIguales=false;
                }
            }
        } else{
            sonIguales=false;
        }
        return sonIguales;
    }
}
