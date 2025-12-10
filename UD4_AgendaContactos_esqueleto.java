package practicaarrays;

import java.util.Scanner;

public class UD4_AgendaContactos_esqueleto {
    // ========================
    // 1. DATOS GLOBALES (accesibles por todos los métodos)
    // ========================
    static final int MAX_CONTACTOS = 100; // constante
    static String[] nombres = new String[MAX_CONTACTOS];
    static String[] telefonos = new String[MAX_CONTACTOS];
    // static String[] emails = new String[MAX_CONTACTOS]; // opcional
    static int count = 0; // número real de contactos almacenados
    static Scanner sc = new Scanner(System.in);

    // ========================
    // 2. MAIN Y MÉTODO PRINCIPAL DE LA APLICACIÓN
    // ========================
    public static void main(String[] args) {
        iniciar_aplicacion();
        // Código para pruebas
        // Ejecutar el programa
        // iniciar_aplicacion();
    }

    static void iniciar_aplicacion() {
        int opcion;

        do {
            opcion = mostrarMenuYLeerOpcion();

            switch (opcion) {
                case 1:
                    listarContactosUI();
                    break;
                case 2:
                    buscarPorNombreUI();
                    break;
                case 3:
                    anadirContactoUI();
                    break;
                case 4:
                    modificarContactoUI();
                    break;
                case 5:
                    eliminarContactoUI();
                    break;
                 case 6:
                   // ordenarPorNombre();
                     break;
                case 0:
                    System.out.println("Saliendo de la agenda...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println("\nPulsa ENTER para continuar...");
            sc.nextLine();

        } while (opcion != 0);
    }

    // ========================
    // 3. MÉTODOS DE MENÚ / USER INTERFACE (UI)
    // Interacción con el usuario + llaman a métodos de lógica
    // ========================

    /** Muestra el menú y devuelve la opción elegida por el usuario. */
    static int mostrarMenuYLeerOpcion() {
        System.out.println("\n=== AGENDA DE CONTACTOS ===");
        System.out.println("1. Listar contactos");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Añadir contacto");
        System.out.println("4. Modificar contacto");
        System.out.println("5. Eliminar contacto");
        // System.out.println("6. Ordenar por nombre (A-Z)"); // AMPLIACIÓN OPCIONAL
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");

        int opcion = sc.nextInt();
        if (opcion < 0) {
            System.out.println("Introduzca una opcion valida");
        }
        sc.nextLine(); // limpiar buffer
        return opcion;
    }

    // ------------------------------
    // Métodos UI para cada operación CRUD
    // ------------------------------

    /** Lista todos los contactos almacenados (0..count-1). */
    static void listarContactosUI() {
        System.out.println("\n--- Lista de contactos ---");
        printContactos();
    }

    /** Interfaz para buscar por nombre: pide patrón y muestra resultados. */
    static void buscarPorNombreUI() {
        System.out.println("\n--- Buscar contacto ---");
        String patron = pedirCadenaNoVacia("Introduce parte del nombre: ");

        // Llamará a métodos de búsqueda (lógica)
        printContactos(patron);
    }

    /** Interfaz para añadir un contacto: recoge datos y llama a la lógica. */
    static void anadirContactoUI() {
        System.out.println("\n--- Añadir contacto ---");
        String nombre = pedirCadenaNoVacia( "Nombre: ");
        int tel = pedirTelefonoValido("Teléfono: ");
        String email = pedirCadenaNoVacia("Email (opcional): ");
        anadirContacto(nombre, nombre, email);
        if (anadirContacto(nombre, nombre, email)) {
            System.out.println("Añadido exitosamente");
        }else{
            System.out.println("Accion no completada");
        }
    }

    /** Interfaz para modificar un contacto existente. */
    static void modificarContactoUI() {
        System.out.println("\n--- Modificar contacto ---");
        System.out.println("Escribe el indice del contacto que quieres modificar;");
        int id = sc.nextInt();
        System.out.println("Escribe el nuevo nombre del contacto: ");
        String nuevoNombre = sc.nextLine();
        System.out.println("Escribe el nuevo telefono del contacto: ");
        String nuevoTel = sc.nextLine();
        for(int i = 0; i < count; i++){
            if (id < 1 || id > count) {
                System.out.println("Lo sentimos no se ha encontrado el contacto que buscabas");
            }
        }
        modificarContacto(id, nuevoNombre, nuevoTel, nuevoTel);
        System.out.println("El contacto a sido modificado con exito");
    }

    /** Interfaz para eliminar un contacto (pide confirmación). */
    static void eliminarContactoUI() {
        System.out.println("\n--- Eliminar contacto ---");

        // TODO pedir nombre o índice, localizar contacto y llamar a
        // eliminarContacto(...)
    }

    // ------------------------------
    // Métodos UI helper
    // ------------------------------

    static String pedirCadenaNoVacia(String mensaje) {
        do{
            System.out.println("Escribe...");
            mensaje = sc.nextLine();
            System.out.print(mensaje);
            return mensaje;
        }
        while(mensaje.equals("") );
    }

    /** TODO Pide un teléfono válido (9 dígitos). Repite hasta que sea válido */
    static int pedirTelefonoValido(String mensaje) {
        do{
            System.out.println("Escribe un telefono");
            mensaje = sc.next();
            System.out.print(mensaje);
            int telefono = Integer.parseInt(mensaje);
            return telefono;
        }
        while(mensaje.length() !=9);
    }

    // ===================================
    // 4. MÉTODOS DE LÓGICA Y ARRAYS
    // Son los que controlan la lógica y los datos (arrays)
    // ===================================

    /** Imprime todos los contactos almacenados (0..count-1). */
    static void printContactos() {
        for(int i =1; i < count; i++){
            System.out.println(nombres[i]);
        }
    }

    /** Imprime solo los contactos cuyo nombre contiene el patron */
    static void printContactos(String patron) {
        for(int i =0; i < count; i++){
            if (nombres[i].contains(patron)) {
                System.out.println(nombres[i]); 
            }
        }
    }

    /** Imprime el contacto que ocupa la posición id (en una sola línea) */
    static void printContacto(int id) {
        // TODO
        System.out.println(nombres[id] + "#" + telefonos[id]);
    }

    /** Devuelve el índice del contacto cuyo teléfono coincide, -1 si no existe */
    static int buscarIndicePorTelefono(String tel) {
        for(int i =0; i < count; i++){
            if (tel.equals(telefonos[i])) {
                return i;
            }   
        }
        return -1;
    }

    /**
     * Añade un nuevo contacto si hay espacio y no hay teléfono duplicado.
     * Devuelve true/false indicando si pudo hacerlo.
     */
    static boolean anadirContacto(String nombre, String tel, String email) {
        // TODO añadir
        //Comprobar agenda llena
        if (count >= MAX_CONTACTOS) {
            return false;
        }
        //Comprobar duplicado
        for(int i = 0; i < count; i++){
            if (tel.equals(telefonos[i])) {
                return false;
            }
        }
        //Añadir
        nombres[count +1] = nombre;
        telefonos[count +1] = tel;
        count++;

        return true;
    }

    /**
     * Modifica el contacto existente en el índice id.
     * Devuelve true/false indicando si pudo hacerlo.
     */
    static boolean modificarContacto(int id, String nuevoNombre, String nuevoTel, String nuevoEmail) {
        // TODO validar índice, comprobar duplicado de teléfono y actualizar datos
        if (id > count) {
            return false;
        }
        for(int i =0; i < count; i++){
            if (nuevoTel.equals(telefonos[i])) {
                return false;
            }
        }
        nombres[id] = nuevoNombre;
        telefonos[id] = nuevoTel;
        return false;
    }

    /**
     * Elimina un contacto y compacta el array (para que no haya 'huecos').
     * Devuelve true/false indicando si pudo hacerlo.
     */
    static boolean eliminarContacto(int idx) {
        // TODO validar y desplazar elementos hacia arriba

        return false;
    }

    /**
     * (MEJORA OPCIONAL) Ordena los contactos alfabéticamente por nombre,
     * manteniendo alineados los
     * arrays.
     */
    static void ordenarPorNombre() {
        // TODO implementar algoritmo de ordenación simple (burbuja, selección...)
        // Importante: intercambiar posiciones en TODOS los arrays paralelos
    }

    /** Intercambia elementos i y j en todos los arrays paralelos. */
    static void swap(int i, int j) {
        // TODO intercambiar nombres[i] ↔ nombres[j], telefonos[i] ↔ telefonos[j], etc.
    }

}
