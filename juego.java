import java.util.Scanner;

public class juego {
    public static void main(String[] args) {
        int NR = numerorandom();
        int NU = pedirnumeroausuario();


      
    }

      public static int numerorandom(){
       int numero = (int)(Math.random() * 50) + 1;
       return numero;
        }

        
      public static int pedirnumeroausuario(){
        Scanner r = new Scanner(System.in);
        System.out.println("Escriba un número:");
        int numusu = r.nextInt();
        return numusu;
      }


}

