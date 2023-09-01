import java.util.Scanner;

public class CifradorCaesar {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el mensaje cifrado");
        String mensajeCifrado = lector.next();
        System.out.println("Cuántas veces se movió la letra para cifrar");
        int veces = lector.nextInt();

        String mensajeOriginal = "";

        for(int i = 0; i < mensajeCifrado.length(); i++) {
            char letra = mensajeCifrado.charAt(i);
            boolean minuscula = (letra >= 'a' && letra <='z');
            boolean mayuscula = (letra >= 'A' && letra <='Z');

            if(!(minuscula || mayuscula))
                mensajeOriginal += letra;  // Mantener caracteres que no son letras.
            else {
                int ascii = (int)letra;
                int baseAscii = (int)'a';
                if(mayuscula)
                    baseAscii = (int)'A';

                // Decodificar: Restar la cantidad de veces y ajustar para no ser negativo.
                int nuevoAscii = (ascii - baseAscii - veces + 26) % 26 + baseAscii;
                char nuevaLetra = (char)nuevoAscii;
                mensajeOriginal += nuevaLetra;
            }
        }

        System.out.println("Mensaje original: " + mensajeOriginal);
    }
}
