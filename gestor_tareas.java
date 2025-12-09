import java.util.Scanner;

public class gestor_tareas {
    public static void main(String[] args) {
        iniciar_aplicacion();
    }
    public static void iniciar_aplicacion(){
        int opcion;
        do{
            opcion=mostrarMenu();
        

            switch (opcion) {
                case 1:
                    Añadir_Tarea();
                    break;
        
                case 2:
                    Listar_tareas();
                    break;
                case 3:
                    Buscar_Palabra();
                    break;
                case 0:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            System.out.println("Pulsa ENTER para continuar...");
            
        }while (opcion !=0);
        
    }
    public static int mostrarMenu(){
        Scanner leer = new Scanner(System.in);
        System.out.println("GESTOR DE TAREAS");
        System.out.println("Submenu:");
        System.out.println("1.añadir tarea");
        System.out.println("2.Listar tareas");
        System.out.println("3.Buscar palabra");
        System.out.println("0.Volver");
        System.out.println("Elige una opción: ");
        int opcion = leer.nextInt();
        return opcion;
    }
    public static void Añadir_Tarea(){

    }
    public static void Listar_tareas(){

    }
    public static void Buscar_Palabra(){

    }

}
