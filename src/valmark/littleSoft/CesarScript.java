package valmark.littleSoft;

public class CesarScript {
    // Key | Default key: 3 //
    private static Byte key = 3;

    // Getter key //
    public static Byte getKey(){
        return key;
    }

    // Setter key //
    public static void setKey(String key){
        CesarScript.key = tryParse(key);
        if (CesarScript.key == -1){
            System.out.println("Error wrong data, Please enter key from 0 to 127");
            CesarScript.key = 3;
        }
    }

    // Encrypt function //
    public static String encryptCesar(String data) {
        // Prepare data and characters //
        char[] dataArr = data.toCharArray();

        // Encryption process //
        for (int i = 0; i < dataArr.length; i++) {
        int index = (int) dataArr[i];
            dataArr[i] = (char) (index + key);
        }

        // Return encrypted data //
        return new String(dataArr);
    }

    // Decrypt function //
    public static String decryptCesar(String data) {
        // Prepare data and characters //
        char[] dataArr = data.toCharArray();
        // Encryption process //
        for (int i = 0; i < dataArr.length; i++) {
            int index = (char)dataArr[i];
            dataArr[i] = (char)(index - key);
        }

        // Return decrypted data //
        return new String(dataArr);
    }

    /// -- Service Block -- ///
    // Check if data can convert to byte //
    private static Byte tryParse(Object obj) {
        byte retVal;
        try {
            retVal = Byte.parseByte((String) obj);
        } catch (NumberFormatException nfe) {
            retVal = -1; // or null if that is your preference
        }
        return retVal;
    }
}
