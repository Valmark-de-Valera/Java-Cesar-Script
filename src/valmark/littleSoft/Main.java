package valmark.littleSoft;

public class Main {
    public static void main(String[] args) {
        String data = "Привіт світе";
        System.out.println("Message: " + data);

        // Set key //
        CesarScript.setKey("-15");

        // Encryption process //
        data = CesarScript.encryptCesar(data);
        System.out.println( "Encrypted message: " + data);

        // Decryption process //
        data = CesarScript.decryptCesar(data);
        System.out.println("Decrypted message: " + data);
    }
}
