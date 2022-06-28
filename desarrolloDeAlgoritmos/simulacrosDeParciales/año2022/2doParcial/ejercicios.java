//package desarrolloDeAlgoritmos.simulacrosDeParciales.año2022.2doParcial;
public class ejercicios {
    public static void main(String[] args) {
        System.out.println("EJERCICIO 1:");
        System.out.println("Binario de 13: "+decimalABinarioRecursivo(13));
        System.out.println("Binario de 8: "+decimalABinarioRecursivo(8));

        System.out.println("EJERCICIO 2:");
        int[] arrInt = {30,26,23,22,20,18,14,11,10,7,5,2};
        System.out.println("Si es -1, entonces no se encuentra, de otra forma, muestra la posicion");
        System.out.println("Valor buscado 23:"+encontrarNumRecursivo(arrInt, 0, 23));
        System.out.println("Valor buscado 4:"+encontrarNumRecursivo(arrInt, 0, 4));

        System.out.println("EJERCICIO 3:");
        int[] arrInt1 = {1,2,8,10,20};
        int[] arrInt2 = {5,7,11,12};
        int[] arrIntOrdenado = ordenarDosArrInts(arrInt1, arrInt2);
        for (int index = 0; index < arrIntOrdenado.length; index++) {
            System.out.print(arrIntOrdenado[index]+"|");
        }
    }
    /* Ejercicio 1 */
    /* Dado un numero entero decimal, pasa dicho valor a binario (recursivo) */
    public static String decimalABinarioRecursivo(int numeroDec){
        String binario = "";
        if (numeroDec<=1){ //Caso base
            binario = ""+numeroDec;
        } else{ //Caso general
            binario = decimalABinarioRecursivo(numeroDec/2) + (numeroDec%2);
        }
        return binario;
    }
    /* Ejercicio 2 */
    /* Dado un arreglo de ints ordenado, encontrar X (recursivo) */
    public static int encontrarNumRecursivo (int[] arrInt, int pos, int numBuscado){
        int posNumBus = -1;
        if(pos<arrInt.length){
            if(arrInt[pos] == numBuscado){ //Caso base
                posNumBus = pos;
            }else{ //Caso base 1            
                posNumBus = encontrarNumRecursivo(arrInt, (pos+1), numBuscado);
            }
        }
        return posNumBus;
    }
    /* Ejercicio 3 */
    /* Dado dos arreglos de orden N, ordenados de mayor a menor, ordenar todo en un solo arreglo */
    public static int[] ordenarDosArrInts(int[] arrInt1, int[] arrInt2){
        int[] arrIntOrdenado = new int [(arrInt1.length + arrInt2.length)];
        int posArr1 = 0, posArr2 = 0, posArrOrd = 0;
        while (posArr1<arrInt1.length && posArr2<arrInt2.length){
            //Si el elemento del primer arreglo es menor o igual al elemento del segundo
            if(arrInt1[posArr1]<=arrInt2[posArr2]){ //Lo guardamos
                arrIntOrdenado[posArrOrd] = arrInt1[posArr1];
                posArr1++;
                posArrOrd++;
            }else{ //Sino, guardamos el elemento del segundo arreglo
                arrIntOrdenado[posArrOrd] = arrInt2[posArr2];
                posArr2++;
                posArrOrd++;
            }
            //Si nos pasamos de la longitud del primer arreglo
            if(posArr1 >= arrInt1.length){
                while (posArr2<arrInt2.length){ //Guardamos los elementos faltantes del segundo arreglo
                    arrIntOrdenado[posArrOrd] = arrInt2[posArr2];
                    posArr2++;
                    posArrOrd++;
                }
            }else if(posArr2 >= arrInt2.length){ // Si nos pasamos de la longitud del segundo arreglo
                while (posArr1<arrInt1.length){ //Guardamos los elementos faltantes del primer arreglo
                    arrIntOrdenado[posArrOrd] = arrInt1[posArr1];
                    posArr1++;
                    posArrOrd++;
                }
            }
        }
        //Una vez guardados todos los elementos, devolvemos el nuevo arreglo
        return arrIntOrdenado;
    }
    /* Ejercicio 4 */
    /* Método de ordenamiento a elección (insercion, burbuja, seleccion o burbuja mejorada) */
    public static void metodoDeOrdenamiento(int[] arrInt){ //Elejimos insercion
        int i, j, aux;
        for (i = 1; i < arrInt.length; i++) {
            aux = arrInt[i];
            j = i;
            while(j > 0 && arrInt[j-1] > aux){
                arrInt[j] = arrInt[j-1];
                j--;
            }
            arrInt[j] = aux;
        }
    }
}