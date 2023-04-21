public class guia1 {

    public static void main(String[] args) {
        
        int numeroInicio = 5, numeroFin = 14, variableExtra = 0;

        System.out.println("1)a)");
        System.out.println("Mostramos los numeros que van del 5 al 14 (incluidos)");
        while (numeroInicio <= numeroFin){ //Verificamos que numeroInicio sea menor o igual a numeroFin
            System.out.println(numeroFin);
            numeroFin++;
        }
        numeroInicio = 5; //Volvemos la variable al valor inicial

        System.out.println("1)b)");
        System.out.println("Mostramos los numeros que van del 5 al 14, pero solo los pares");
        while (numeroInicio <= numeroFin){ //Verificamos que numeroInicio sea menor o igual a numeroFin
            if(numeroInicio%2 == 0){ //Verificamos que sea par
                System.out.println(numeroFin);
            }
            numeroFin++;
        }
        numeroInicio = 5; //Volvemos la variable al valor inicial

        System.out.println("1)c)");
        System.out.println("Mostramos los numeros que van del 5 al 14, pero solo los pares (utilizando una variable extra)");
        while (numeroInicio <= numeroFin){ //Verificamos que numeroInicio sea menor o igual a numeroFin
            if(numeroInicio%2 != 0){ //Verificamos que sea impar
                variableExtra = numeroInicio;
                System.out.println(variableExtra);
            }
            variableExtra++;
        }
        numeroInicio = 5; //Volvemos la variable al valor inicial

        System.out.println("1)d)");
        System.out.println("Mostramos los numeros que van del 14 al 5, pero solo los pares, con iterador FOR");
        for(int i=numeroFin; i>=numeroInicio;i--){
            if(i%2 == 0){ //Verificamos que sea par
                System.out.println(i);
            }
        }

        System.out.println("2)d)");
        System.out.println("Vemos si una persona pertenece a la categoria 'Ingresos Altos'");
        float ingresosMensuales = 238565;
        int cantVehiculosAntiMen5 = 1, cantInmuebles = 3; 
        boolean capacidadEconPlena = false;
        boolean pertenece = false; //Asigno falso
        if(ingresosMensuales >= 489083 || cantVehiculosAntiMen5 >= 3 || cantInmuebles >= 3 || capacidadEconPlena){
            //Si la persona cumple cualquiera de las condiciones, entra en la categoria
            pertenece = true;
        }
        //De lo contrario ya tiene asignado el valor falso 

    }
    
}
