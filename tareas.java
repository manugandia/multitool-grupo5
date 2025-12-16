import java.util.Scanner;

public class tareas {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        String[] tareas = new String[15];
        int contador = 0;
        int opcion;

        do {
            System.out.println("GESTIÓN DE TAREAS");
            System.out.println("1. Añadir tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Buscar palabra");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();
            
            switch (opcion) {
                case 1:
                    if (contador < tareas.length) {
                        System.out.println("Introduce la tarea: ");
                        tareas[contador] = leer.next();
                        contador ++;
                        System.out.println("La tarea se añadio");
                    }else{
                        System.out.println("Ya has llenado el maximo de tareas");
                    }
                    break;
            
                default:
                    break;
            }
    }
}