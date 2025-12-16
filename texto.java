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
            switch (opcion) {
                case 1:
                    
                    int contadorVocales = 0;
                    String textoMin = texto.toLowerCase(); 
                    for (int i = 0; i < textoMin.length(); i++) {
                        char c = textoMin.charAt(i);
                        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
                            c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú') {
                            contadorVocales++;
                        }
                    }
                    System.out.println(">> Total de vocales: " + contadorVocales);
                    break;

                case 2:
                    
                    if (texto == null || texto.trim().isEmpty()) {
                        System.out.println(">> Total de palabras: 0");
                    } else {
                        
                        String[] palabras = texto.trim().split("\\s+");
                        System.out.println(">> Total de palabras: " + palabras.length);
                    }
                    break;

                case 3:
                    
                    if (texto == null || texto.trim().isEmpty()) {
                        System.out.println(">> No hay texto para analizar.");
                    } else {
                        String[] palabrasArr = texto.trim().split("\\s+");
                        String palabraMasLarga = "";
                        
                        for (String palabra : palabrasArr) {
                            
                            String palabraLimpia = palabra.replace(",", "").replace(".", "");
                            
                            if (palabraLimpia.length() > palabraMasLarga.length()) {
                                palabraMasLarga = palabraLimpia;
                            }
                        }
                        System.out.println(">> La palabra más larga es: \"" + palabraMasLarga);
                    }
                    break;
                
                case 4:
                    System.out.print("Ingresa el nuevo texto: ");
                    texto = sc.nextLine();
                    System.out.println(">> Texto actualizado.");
                    break;

                case 0:
                    System.out.println("Saliendo del analizador...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
        }
    }
}    
