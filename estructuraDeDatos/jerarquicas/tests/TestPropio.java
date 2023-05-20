package jerarquicas.tests;

import  jerarquicas.jerarquicasDinamicas.*;

public class TestPropio {

    public static void main(String[] args){

        System.out.println("------------------");
        System.out.println("| TEST FRONTERAS |");
        System.out.println("------------------");

        ArbolGen arbol = new ArbolGen();
        Lista lista = new Lista();

        System.out.println("Caso 1: Prueba con árbol vacío y lista vacía ------> Esto deberia devolver false: "+ (arbol.sonFrontera(lista)));

        arbol.insertar(1, null); 
        System.out.println("Caso 2: Prueba con árbol no vacío y lista vacía ------> Esto deberia devolver false: " + (arbol.sonFrontera(lista))); 

        lista.insertar(2, 1); 
        System.out.println("Caso 3: Prueba con árbol no vacío y lista no vacía con elementos distintos a los del árbol ------> Esto deberia devolver false: " + (arbol.sonFrontera(lista)));

        ArbolGen arbol2 = new ArbolGen();
        arbol2.insertar(1, null);
        arbol2.insertar(2, 1);
        arbol2.insertar(3, 1);

        Lista lista2 = new Lista();
        lista2.insertar(3, 1);
        lista2.insertar(2, 2);
        System.out.println("Caso 4: Prueba con árbol no vacío y lista no vacía con elementos iguales a los del árbol, pero en distinto orden ------> Esto deberia devolver true: " + (arbol2.sonFrontera(lista2))); 
  
        ArbolGen arbol3 = new ArbolGen();
        arbol3.insertar(1, null);
        arbol3.insertar(2, 1);
        arbol3.insertar(3, 1);
        Lista lista3 = new Lista();
        lista3.insertar(2, 1);
        lista3.insertar(3, 2);
        System.out.println("Caso 5: Prueba con árbol no vacío y lista no vacía con elementos iguales a los del árbol, en mismo orden ------> Esto deberia devolver true: " + (arbol3.sonFrontera(lista3)));

        System.out.println("-----------------");
        System.out.println("|  TEST EQUALS  |");
        System.out.println("-----------------");

        ArbolGen a1 = new ArbolGen();
        ArbolGen a2 = new ArbolGen();

        System.out.println("Caso 1: Prueba con árboles vacíos ------> Esto deberia devolver true: " + (a1.equals(a2))); 

        a1.insertar(1, null);
        System.out.println("Caso 2: Prueba con un árbol vacío y otro con una raíz ------> Esto deberia devolver false: " + (a1.equals(a2)));
        
        
        a2.insertar(1, null);
        System.out.println("Caso 3: Prueba con dos árboles con la misma raíz ------> Esto deberia devolver true: " + (a1.equals(a2))); 

        a1.insertar(2, 1);
        System.out.println("Caso 4: Prueba con un árbol que tiene un hijo y otro sin hijos ------> Esto deberia devolver false: " + (a1.equals(a2))); 

        a2.insertar(2, 1);
        System.out.println("Caso 5: Prueba con dos árboles que tienen el mismo hijo ------> Esto deberia devolver true: " + (a1.equals(a2))); 

        a2.insertar(3, 2);
        System.out.println("Caso 6: Prueba con dos árboles que tienen distintos hijos ------> Esto deberia devolver false: " + (a1.equals(a2))); 
    }

}