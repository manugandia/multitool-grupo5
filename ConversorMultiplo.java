import java.util.Scanner;

public class ConversorMultiplo{

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- Submenú de Conversiones ---");
            System.out.println("1. Celsius ↔ Fahrenheit");
            System.out.println("2. Metros ↔ Pies");
            System.out.println("3. Kg ↔ Libras");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    celsiusFahrenheit(sc);
                    break;
                case 2:
                    metrosPies(sc);
                    break;
                case 3:
                    kgLibras(sc);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    public static void celsiusFahrenheit(Scanner sc) {
        System.out.print("Ingrese la temperatura: ");
        double temp = sc.nextDouble();

        System.out.print("¿Convertir a (C)elsius o (F)ahrenheit? ");
        char tipo = sc.next().toUpperCase().charAt(0);

        if (tipo == 'F') {
            double resultado = temp * 9 / 5 + 32;
            System.out.println(temp + " °C = " + resultado + " °F");
        } else if (tipo == 'C') {
            double resultado = (temp - 32) * 5 / 9;
            System.out.println(temp + " °F = " + resultado + " °C");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    public static void metrosPies(Scanner sc) {
        System.out.print("Ingrese la longitud: ");
        double valor = sc.nextDouble();

        System.out.print("¿Convertir a (M)etros o (P)ies? ");
        char tipo = sc.next().toUpperCase().charAt(0);

        if (tipo == 'P') {
            double resultado = valor * 3.28084;
            System.out.println(valor + " m = " + resultado + " ft");
        } else if (tipo == 'M') {
            double resultado = valor / 3.28084;
            System.out.println(valor + " ft = " + resultado + " m");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    public static void kgLibras(Scanner sc) {
        System.out.print("Ingrese el peso: ");
        double valor = sc.nextDouble();

        System.out.print("¿Convertir a (K)g o (L)ibras? ");
        char tipo = sc.next().toUpperCase().charAt(0);

        if (tipo == 'L') {
            double resultado = valor * 2.20462;
            System.out.println(valor + " kg = " + resultado + " lb");
        } else if (tipo == 'K') {
            double resultado = valor / 2.20462;
            System.out.println(valor + " lb = " + resultado + " kg");
        } else {
            System.out.println("Opción no valida.");
        }
    }
}
