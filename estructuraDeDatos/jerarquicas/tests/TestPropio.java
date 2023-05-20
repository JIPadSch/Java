package jerarquicas.tests;

import  jerarquicas.jerarquicasDinamicas.*;;

public class TestPropio {

    public static void main(String[] args){
        ArbolGen arbol = new ArbolGen();
        Lista lista = new Lista();

        // Caso 1: árbol vacío y lista vacía. Debe devolver false.
        System.out.println("Esto deberia devolver falso: " + (arbol.sonFrontera(lista)));

        // Caso 2: árbol no vacío y lista vacía. Debe devolver false. 
        arbol.insertar(1, null); 
        System.out.println("Esto deberia devolver falso: " + (arbol.sonFrontera(lista)));

        // Caso 3: árbol no vacío y lista no vacía con elementos distintos a los del árbol. Debe devolver false. 
        lista.insertar(2, 1); 
        System.out.println("Esto deberia devolver falso: " + (arbol.sonFrontera(lista))); 

        // Caso 4: árbol no vacío y lista no vacía con elementos iguales a los del árbol, pero en distinto orden. Debe devolver true.
        ArbolGen arbol2 = new ArbolGen();
        arbol2.insertar(1, null);
        arbol2.insertar(2, 1);
        arbol2.insertar(3, 1);

        Lista lista2 = new Lista();
        lista2.insertar(3, 1);
        lista2.insertar(2, 2);

        System.out.println("Esto deberia devolver true: " + (arbol2.sonFrontera(lista2)));

        //Caso 5: árbol no vacío y lista no vacía con elementos iguales a los del árbol, en mismo orden. Debe devolver true
        ArbolGen arbol3 = new ArbolGen();
        arbol3.insertar(1, null);
        arbol3.insertar(2, 1);
        arbol3.insertar(3, 1);

        Lista lista3 = new Lista();
        lista3.insertar(2, 1);
        lista3.insertar(3, 1);

        System.out.println("Esto deberia devolver true: " + (arbol3.sonFrontera(lista3)));
    }
    
}