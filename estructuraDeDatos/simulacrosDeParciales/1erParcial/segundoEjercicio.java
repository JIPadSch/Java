import estructuraDeDatos.jerarquicas.*;
import estructuraDeDatos.lineales.*;

public class segundoEjercicio {
    /* EJERCICIO TIPO 1ER PARCIAL:
     * Ejercicio 2:
     * c)   En una clase TestCadenas, que utilice los TDA Lista, Pila y Cola vistos en la materia, para guardar elementos
     *       de tipo CHAR, implementar el método generar (Cola c1) que recibe por parámetro una estructura cola c1
     *       que tiene el siguiente formato: a1#a2#a3#….#an, donde cada ai en una sucesión de letras mayúsculas y a
     *       partir de c1 debe generar como salida otra Cola de la forma: a1a1´a1#a2a2´a2#….#anan´an donde cada ai´ es la
     *       secuencia de letras mayúsculas ai pero invertida. Ejemplo.: Si c1 es : AB#C#DEF , entonces la operación
     *       generar devolverá una Cola con el siguiente formato: ABBAAB#CCC#DEFFEDDEF
     * • Consideraciones ejercicio 2 c y d:
     *   ◦ Dibujar la cajas UML del TDA Lista, Pila y Cola indicando nombre, parámetros y tipo de salida de su
     *     interfaz (métodos públicos) y sólo las operaciones del TDA sin indicar la implementación.
     */

    public Cola generar(Cola c1){
        Cola colaAux = c1.clone();
        Cola nuevaCola = new Cola();
        String elemento = null;

        while (!colaAux.esVacia()){
            elemento = colaAux.obtenerFrente();
            elemento = elemento+elementoDadoVuelta(elemento)+elemento;
            colaAux.sacar();
        }

        return nuevaCola;
    }

    private String elementoDadoVuelta(String elemento){
        String elemAlReves = "";
        int longitudElem = elemento.length();

        for (int i = longitudElem; i < 0; i--) {
            elemAlReves += elemento.charAt(i);            
        }

        return elemAlReves;
    }

     /* EJERCICIO TIPO 1ER PARCIAL:
     * Ejercicio 2:
     * d)  En la clase Matematica, que utiliza a los TDA Lista, Pila y Cola vistos en la materia para guardar elementos
     *      tipo CHAR que representan una expresión matemática, desarrollar el método verificarBalanceo (Cola q)
     *      que recibe por parámetro una cola con una expresión matemática y verifique que los paréntesis, corchetes y
     *      llaves estén correctamente balanceados. Debe usar como estructura auxiliar alguno de los TDA lineales
     *      vistos, el que considere más apropiado.
     *      Ejemplos: 
     *          Si q es ← { 5 + [ 8 * 9 -( 4 / 2 ) + 7 ] -1 } ← el método debe devolver TRUE
     *          Si q es ← { 5 + 8 * 9 -( 4 / 2 ) + 7 ] -1 } ← el método debe devolver FALSE
     * • Consideraciones ejercicio 2 c y d:
     *   ◦ Dibujar la cajas UML del TDA Lista, Pila y Cola indicando nombre, parámetros y tipo de salida de su
     *     interfaz (métodos públicos) y sólo las operaciones del TDA sin indicar la implementación.
     */

    public boolean verificarBalanceo(Cola q){
        boolean balanceado = true;
    
        if(q != null){

            int con1 = 0, con2 = 0, con3 = 0, con4 = 0, con5 = 0, con6 = 0;
            Cola colaAux = q.clone();
            char charEnPos = null;
            String index = "{}()[]";

            while(!colaAux.esVacia() && balanceado){

                charEnPos = colaAux.obtenerFrente();
                
                if(index.indexOf(charEnPos) > -1){
                    switch (charEnPos) {
                        case '{':
                            con1++;
                            break;
                        case '}':
                            con2++;
                        case '(':
                            con3++;
                        break;
                        case ')':
                            con4++;
                        break;
                        case '[':
                            con5++;
                        break;
                        case ']':
                            con6++;
                        break;
                    }
                }

                colaAux.sacar();
            }

            balanceado = (con1==con2 && con3==con4 && con5==con6);

        }

        return balanceado;
    }

    
    

}