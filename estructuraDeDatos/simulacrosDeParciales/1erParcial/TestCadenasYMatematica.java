
public class TestCadenasYMatematica {

    //EJERCICIO TIPO 2: Usar TDA lineales

    public static void main(String[] args) {
        Cola c1 = new Cola();
        c1.poner('A');
        c1.poner('B');
        c1.poner('A');
        c1.poner('#');
        c1.poner('C');
        c1.poner('#');
        c1.poner('D');
        c1.poner('E');
        c1.poner('F');
        System.out.println(c1.toString());
        Cola colaNueva = generar(c1);
        System.out.println(colaNueva.toString());
    }

    /*
     * c) En una clase TestCadenas, que utilice los TDA Lista, Pila y Cola vistos en la materia, para guardar elementos
     * de tipo CHAR, implementar el método generar (Cola c1) que recibe por parámetro una estructura cola c1
     * que tiene el siguiente formato: a1#a2#a3#….#an, donde cada ai en una sucesión de letras mayúsculas y a
     * partir de c1 debe generar como salida otra Cola de la forma: a1a1´a1#a2a2´a2#….#anan´an donde cada ai´ es la
     * secuencia de letras mayúsculas ai pero invertida. Ejemplo.: Si c1 es : AB#C#DEF , entonces la operación
     * generar devolverá una Cola con el siguiente formato: ABBAAB#CCC#DEFFEDDEF.
     */
    public static Cola generar(Cola c1){
        Cola colaNueva = new Cola(); //Cola a devolver
        Pila pilaAux = new Pila(); //Pila que me dará mis ai´
        Lista listaAux = new Lista(); //Lista que usaré para poner los ai 2 veces
        int i = 0;

        while(!c1.esVacio()){ //Mientras c1 (la Cola original) tenga elementos 
            //Mientras el elemento en frente sea distinto de #
            while(!c1.obtenerFrente().equals('#')){
                //Apilo en una Pila y lo inserto en una Lista
                pilaAux.apilar(c1.obtenerFrente());
                listaAux.insertar(c1.obtenerFrente(), i);
                c1.sacar();
                i++;
            }
            //Pongo en la Cola nueva los elementos en el orden original con la Lista
            ponerListaEnCola(listaAux, colaNueva);
            //Mientras la Pila tenga elementos
            while(!pilaAux.esVacia()){
                //Los apilo en la Cola a devolver, quedando el reverso, o sea, ai´
                colaNueva.poner(pilaAux.obtenerTope());
                pilaAux.desapilar();
            }
            //Pongo en la Cola nueva los elementos en el orden original con la Lista, DENUEVO
            ponerListaEnCola(listaAux, colaNueva);
            //Pongo el #
            colaNueva.poner(c1.obtenerFrente());
            c1.sacar();
            listaAux.vaciar();
            i = 0;
            //Y vuelvo a empezar hasta vaciar c1 (la Cola original)
        }

        return colaNueva;
    }

    private static void ponerListaEnCola(Lista listaAux, Cola colaNueva){
        for (int i = 0; i < listaAux.longitud(); i++) {
            colaNueva.poner(listaAux.recuperar(i));
        }
    }

    /*
     * d) En la clase Matematica, que utiliza a los TDA Lista, Pila y Cola vistos en la materia para guardar elementos
     * tipo CHAR que representan una expresión matemática, desarrollar el método verificarBalanceo (Cola q)
     * que recibe por parámetro una cola con una expresión matemática y verifique que los paréntesis, corchetes y
     * llaves estén correctamente balanceados. Debe usar como estructura auxiliar alguno de los TDA lineales
     * vistos, el que considere más apropiado
     * Ejemplos: Si q es ← { 5 + [ 8 * 9 -( 4 / 2 ) + 7 ] -1 } ← el método debe devolver TRUE
     *           Si q es ← { 5 + 8 * 9 -( 4 / 2 ) + 7 ] -1 } ← el método debe devolver FALSE
     */

     public static boolean verificarBalanceo(Cola c1){
        boolean balanceado = true;
        char caracter = ' ';
        int tipoCaracter = 0;
        Cola colaAux = c1.clone();
        Cola c2 = new Cola();
        Pila p1 = new Pila();
        //Recorro la cola para obtener todos los caracteres especiales
        while(!colaAux.esVacio()){
            //Obtengo el caracter en frente
            caracter = (char) colaAux.obtenerFrente();
            //Verifico que sea un caracter especial y cual es (si abre o cierra)
            tipoCaracter = esCaracterEspecial(caracter);
            //Si abre, lo pongo en la cola
            if(tipoCaracter == -1){
                c2.poner(caracter);
            }else if(tipoCaracter == 1){ //Si cierra lo pongo en la pila
                p1.apilar(caracter);
            }
            
            colaAux.sacar();            
        }
        //Verificamos si esta balanceado
        balanceado = balanceo(c2,p1);

        return balanceado;
     }
    

     private static int esCaracterEspecial(char caracter){
        int charEspecial;

        switch(caracter){
            case '[':
            charEspecial = -1;
            break;
            case ']':
            charEspecial = 1;
            break;
            case '(':
            charEspecial = -1;
            break;
            case ')':
            charEspecial = 1;
            break;
            case '{':
            charEspecial = -1;
            break;
            case '}':
            charEspecial = 1;
            break;
            default:
            charEspecial = 0;
            break;
        }

        return charEspecial;
     }

     private static boolean balanceo(Cola c2, Pila p1){
        boolean balanceado = false, corte = false;
        char charCola, charPila;

        while(balanceado && !corte){

            charCola = (char) c2.obtenerFrente();
            charPila = (char) p1.obtenerTope();

            if(charCola == '('){
                if(charPila != ')'){
                    balanceado = false;
                }
            }else if(charCola == '['){
                if(charPila != ']'){
                    balanceado = false;
                }
            }else if(charCola == '{'){
                if(charPila != '}'){
                    balanceado = false;
                }
            }

            c2.sacar();
            p1.desapilar();

            if(p1.esVacia() && !c2.esVacio()){
                balanceado = false;
            }else if(c2.esVacio() && !p1.esVacia()){
                balanceado = false;
            }else if(p1.esVacia() && c2.esVacio()){
                corte = true;
            }

        }

        return balanceado;
     }

}
