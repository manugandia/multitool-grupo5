
import java.util.Scanner;

public class GestorNumeros {

   
    static int[] numeros = new int[20]; 
    static int contador = 0;
    static Scanner t = new Scanner(System.in);

    public static void mostrarMenuGestor() { 
        int opcion;
        do {
            System.out.println("1. Añadir número");
            System.out.println("2. Listar números");
            System.out.println("3. Mostrar numero mínimo y numero máximo");
            System.out.println("4. Busca un número");
            System.out.println("0. Salir");
            opcion = t.nextInt();
            
            switch(opcion) {
                case 1: anadirNumero(); break; 
                case 2: listarNumeros(); break;
                case 3: mostrarMinMax(); break;
                case 4: buscarNumero(); break;
                case 0: break;
            }
        } while (opcion != 0);
    }

    private static void anadirNumero() {
        if (contador<numeros.length){
        System.out.println("Introduce un nuevo numero");
        int nuevoNumero = t.nextInt();
        numeros[contador]=nuevoNumero;
        contador++;
        System.out.println("Numero guardado correctamente");
        }else{
            System.out.println("No caben mas numeros");
        }
    }

    private static void listarNumeros() {
        if (contador==0){
            System.out.println("La lista esta vacia, añade numeros primero");
            return;
        }
        System.out.print("Numeros: ");
        for (int i = 0; i < contador; i++) {
            System.out.print(numeros[i]);
            if (i<contador -1){
                System.out.print(", " );
            }
        }
        System.out.println();

    }

    private static void mostrarMinMax() {
        if (contador == 0){
            System.out.println("La lista está vacía, primero añade numeros");
            return;
        }

        int menor = numeros[0];
        int mayor = numeros[0];

        for (int i = 0; i < contador; i++) {
            if(numeros[i]<menor){
                menor = numeros[i];
            }
            if (numeros[i]>mayor){
                mayor = numeros[i];
            }
        }
        System.out.println("Valor mínimo: "+menor);
        System.out.println("Valor máximo: "+ mayor);
    }

    private static void buscarNumero() {
    
        System.out.println("Introduce un número y lo buscare");
        int numeroNuevo = t.nextInt();
        for (int i = 0; i < contador; i++) {
            if (numeroNuevo==numeros[i]) {
                System.out.println("Ese número si que esta registrado");
                return;
            }
        }
        System.out.println("Ese número no esta registrado");
        
    
    }
}

