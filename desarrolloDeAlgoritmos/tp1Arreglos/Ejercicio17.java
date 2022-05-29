package desarrolloDeAlgoritmos.tp1Arreglos;
import java.util.*;
public class Ejercicio17 {
    /*Este algoritmo, según las notas ingresadas de un alumno, verificara si este aprobo*/
    public static void main(String[] args){
        String[] apellidoAlumno;
        int longitud,i;
        double[] notaAlumno;
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese la cantidad de estudiantes a calcular si aprobaron el cuatrim.");
        longitud = sc.nextInt();
        apellidoAlumno = new String[longitud];
        cargarArregloApellido(apellidoAlumno);
        for(i=0; i<longitud; i++){
            System.out.println(apellidoAlumno[i]+": ");
            notaAlumno = cargarArregloNota();
            if(aproboElEstudiante(notaAlumno)){
                System.out.println("El/La estudiante "+apellidoAlumno[i]+" aprobó el cuatrimestre");
            } else{
                System.out.println("El/La estudiante "+apellidoAlumno[i]+" no aprobo el cuatrim.");
            }
        }
        scan.close();
    }
    //Este módulo, según un arreglo del tipo texto, cargará un apellido en cada posición
    public static void cargarArregloApellido(String[] apellido){
        Scanner entrada = new Scanner(System.in);
        int i, limite= apellido.length;
        for(i=0; i<limite; i++){
            System.out.println("Por favor ingrese el apellido del estudiante: "+(i+1));
            apellido[i] = entrada.next();
        }
        scan.close();
    }    
    //Este módulo, según un arreglo del tipo real, cargará una nota en cada posición
    public static double[] cargarArregloNota(){
        int i;
        double[] notAlumno = new double[10];
        Scanner ent= new Scanner(System.in);
        for(i=0; i<10; i++){
            System.out.println("Por favor ingrese la "+(i+1)+" nota");
            notAlumno[i] = ent.nextDouble();
        }
        return notAlumno;
    }
    //Este módulo, según las notas del cuatrimestre, podremos decir si el estudiante aprobo o no
    public static boolean aproboElEstudiante(double[] notAlumn){
        int i=0;
        boolean aprobo=true;
        do{
            if(notAlumn[i]<6){
                aprobo = false;
            } else{
                i++;
            } 
        }
        while(aprobo && i<10);
        return aprobo;
    }    
}