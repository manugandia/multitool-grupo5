import java.util.Scanner;

public class texto {


    public static void main(String[] args) {
        iniciarAnalizador();
    }


    public static void iniciarAnalizador() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        String texto = "";


        System.out.println("--- ANALIZADOR DE TEXTO ---");
        System.out.print("Por favor, ingresa el texto a analizar: ");
        texto = sc.nextLine();

        do {
            System.out.println("\nSeleccione una operación:");
            System.out.println("1. Contar vocales");
            System.out.println("2. Contar palabras");
            System.out.println("3. Palabra más larga");
            System.out.println("4. Cambiar texto"); 
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            
    
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); 
            } else {
                opcion = -1;
                sc.next(); 
            }
        } while
    }
}    
