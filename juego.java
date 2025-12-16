import java.util.Scanner;

public class juego {
    static Scanner r = new Scanner(System.in);
    static int intentosUltimoJuego = 0;

    public static void main(String[] args) {
        iniciar_aplicacion();



      
    }
      static void iniciar_aplicacion(){
        int opcion;
        do{
            opcion = mostrarMenuYLeerOpcion();

            switch (opcion) {
                case 1:
                    juegodenumeros();
                    break;
                case 2:
                    mostrarnumerodeintentos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println("\nPulsa ENTER para continuar...");
            r.nextLine();
        }
          while (opcion != 0);

           
                

      }

      static int mostrarMenuYLeerOpcion() {
    int opcion;

    System.out.println("=== Submenú ===");
    System.out.println("1. Jugar (número entre 1 y 50)");
    System.out.println("2. Mostrar intentos del último juego");
    System.out.println("0. Volver");
    System.out.print("Elige una opción: ");

    while (!r.hasNextInt()) {   
        System.out.println("Error: Escribe solo numeros, espabila.");
        r.next();                 
        System.out.print("Elige una opción: ");
    }

    opcion = r.nextInt();
    r.nextLine();

    return opcion;
}



      public static int numerorandom(){
       int numero = (int)(Math.random() * 50) + 1;
       return numero;
        }

        
      public static int pedirnumeroausuario(){
        System.out.println("Escriba un número entre 1-50 y aciertalo:");
        int numusu = r.nextInt();
        return numusu;
      }

      public static void juegodenumeros() {
    int numeroSecreto = numerorandom(); // SOLO UNA VEZ
    int numUsuario;
    intentosUltimoJuego = 0;

    do {
        numUsuario = pedirnumeroausuario();
        intentosUltimoJuego++;
    } while (numUsuario != numeroSecreto);

    System.out.println("Has acertado el numero correcto");
}


      public static void mostrarnumerodeintentos() {
    if (intentosUltimoJuego == 0) {
        System.out.println(" ");
        System.out.println("========================================");
        System.out.println("Todavía no se ha jugado ninguna partida.");
        System.out.println("========================================");
        System.out.println(" ");
    } else {
        System.out.println(" ");
        System.out.println("==========================");
        System.out.println("Intentos del último juego: " + intentosUltimoJuego);
        System.out.println("==========================");
        System.out.println(" ");
    }
}


      


}

