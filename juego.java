import java.util.Scanner;

public class juego {
    static Scanner r = new Scanner(System.in);
    public static void main(String[] args) {
        int NR = numerorandom();
        int NU = pedirnumeroausuario();


      
    }
      static void iniciar_aplicacion(){
        int opcion;
        do{
            opcion = mostrarMenuYLeerOpcion();

            switch (opcion) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        }

      }

      static int mostrarMenuYLeerOpcion(){
        System.out.println("=== Submenú ===");
        System.out.println("1.Jugar (número entre 1 y 50)");
        System.out.println("2. Mostrar intentos del último juego");
        System.out.println("0. Volver");
        System.out.print("Elige una opción: ");
        int opcion = r.nextInt();
        r.nextLine();
        return opcion;

      }


      public static int numerorandom(){
       int numero = (int)(Math.random() * 50) + 1;
       return numero;
        }

        
      public static int pedirnumeroausuario(){
        System.out.println("Escriba un número:");
        int numusu = r.nextInt();
        return numusu;
      }

      


}

