import java.util.Scanner;

public class MainGeneral{

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int opcion;
        // MENU
        do {
            System.out.println("--- MENU ---");
            System.out.println("1. Gestor de Numeros");
            System.out.println("2. Conversor de Multiplos");
            System.out.println("3. Analizador de texto");
            System.out.println("4. Gestion de tareas");
            System.out.println("5. Adivina el numero");
            System.out.println("Presiona 0 para no hacer nada");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    gestor_de_numeros();
                    break;
                case 2:
                    conversor_de_multiplos(sc);
                    break;
                case 3:
                    analizador_de_texto();
                    break;
                case 4:
                    gestor_de_tareas();
                    break;
                case 5:
                    adivinar_juego();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
    
    public static void conversor_de_multiplos(Scanner sc) {
    
        
        int opcion;
        // MENU
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
// METODOS
    //TEMPERATURA 
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
// LONGITUD
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
// PESO
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


    static int[] numeros = new int[20]; 
    static int contador = 0;
    static Scanner t = new Scanner(System.in);

    public static void gestor_de_numeros() {
        mostrarMenuGestor();
    }

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


        public static void analizador_de_texto() {
        
        iniciarAnalizador();
    }

//Introduzco el metodo y las variables
    public static void iniciarAnalizador() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        String texto = "";
        

//Introduzco texto
        System.out.println("ANALIZADOR DE TEXTO");
        System.out.print("Por favor, ingresa el texto a analizar: ");
        texto = sc.nextLine();

//Empieza el bucle dowhile
        do {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Contar vocales");
            System.out.println("2. Contar palabras");
            System.out.println("3. Palabra más larga");
            System.out.println("4. Cambiar texto"); 
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            
//Condicional que hace de conexion entre la interfaz y el switch 
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); 
            } else {
                opcion = -1;
                sc.next(); 
            }
//Comienza el switch con todas las funciones de analisis de palabras
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
                    System.out.println("Total de vocales: " + contadorVocales);
                    break;

                case 2:
                    
                    if (texto == null || texto.trim().isEmpty()) {
                        System.out.println("Total de palabras: 0");
                    } else {
                        
                        String[] palabras = texto.trim().split("\\s+");
                        System.out.println("Total de palabras: " + palabras.length);
                    }
                    break;

                case 3:
                    
                    if (texto == null || texto.trim().isEmpty()) {
                        System.out.println("No hay texto para analizar.");
                    } else {
                        String[] palabrasArr = texto.trim().split("\\s+");
                        String palabraMasLarga = "";
                        
                        for (String palabra : palabrasArr) {
                            
                            String palabraLimpia = palabra.replace(",", "").replace(".", "");
                            
                            if (palabraLimpia.length() > palabraMasLarga.length()) {
                                palabraMasLarga = palabraLimpia;
                            }
                        }
                        System.out.println("La palabra más larga es: " + palabraMasLarga);
                    }
                    break;
                
                case 4:
                    System.out.print("Ingresa el nuevo texto: ");
                    texto = sc.nextLine();
                    System.out.println("Texto actualizado.");
                    break;

                case 0:
                    System.out.println("Saliendo del analizador...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
        }

      static int count = 0;
    static int Max = 15;
    static String[]tareas = new String[Max];
    static Scanner leer = new Scanner(System.in);

    public static void gestor_de_tareas() {
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
        
        System.out.println("GESTOR DE TAREAS");
        System.out.println("Submenu:");
        System.out.println("1.añadir tarea");
        System.out.println("2.Listar tareas");
        System.out.println("3.Buscar palabra");
        System.out.println("0.Volver");
        System.out.println("Elige una opción: ");
        int opcion = leer.nextInt();
        leer.nextLine();
        return opcion;
    }
    public static void Añadir_Tarea(){
        if (count >= Max) {
            System.out.println("No se pueden añadir mas tareas");
            return;
        }
        
        System.out.println("Escribe la tarea: ");
        String añadir = leer.nextLine();
        tareas[count] = añadir;
        count ++;
        
        System.out.println("Tarea añadida correctamente");
    }
    
    public static void Listar_tareas(){
        if (count == 0) {
            System.out.println("No hay tareas registradas");
        }
        for(int i = 0; i < count; i++ ){
            System.out.println((i + 1) + "." + tareas[i]);
        }
    }
        public static void Buscar_Palabra(){
        if (count ==0) {
            System.out.println("No hay tareas para buscar");
            return;
        }

        System.out.println("Introduce la palabra a buscar: ");
        String patron = leer.nextLine();
        boolean esta = false;

        for(int i =0; i<count; i++){
            if (tareas[i].contains(patron)) {
                System.out.println(tareas[i]);
                esta = true;
            }
        }

        if(!esta){
            System.out.println("No se ha encontrado la palabra entre las tareas");
        }
    }

        static Scanner r = new Scanner(System.in);
    static int intentosUltimoJuego = 0;

    public static void adivinar_juego() {
        inicializar_aplicacion();



      
    }
      static void inicializar_aplicacion(){
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


    





