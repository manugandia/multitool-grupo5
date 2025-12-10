import java.util.Scanner;

public class gestor_tareas {
    static int count = 0;
    static int Max = 15;
    static String[]tareas = new String[Max];
    static Scanner leer = new Scanner(System.in);
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
                    Buscar_Palabra(null);();
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
        if (count >= Max) {
            System.out.println("No se pueden añadir mas contactos");
        }
        do{
        System.out.println("Escribe la tarea: ");
        String añadir = leer.next();
        tareas[count] = añadir;
        count ++;
        }
        while(count >= Max);
    }
    
    public static void Listar_tareas(){
        for(int i = 0; i < count; i++ ){
            System.out.println(tareas[i]);
        }
    }
        public static void Buscar_Palabra(String patron){
        for(int i =0; i < count; i++){
            if (tareas[i].contains(patron)) {
                System.out.println(tareas[i]); 
            }
        }
    }

}
