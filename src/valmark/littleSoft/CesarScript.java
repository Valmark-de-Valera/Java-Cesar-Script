package valmark.littleSoft;

public class CesarScript {
    // Character data that can be encrypt / decrypt //
    private static final char[] charArr = new char[]{'а', 'А', 'б', 'Б', 'в', 'В', 'г', 'Г', 'Ґ', 'ґ', 'д', 'Д', 'е', 'Е', 'є', 'Є', 'ж', 'Ж',
            'з', 'З', 'и', 'И', 'і', 'І', 'ї', 'Ї', 'й', 'Й', 'к', 'К', 'л', 'Л', 'м', 'М', 'н', 'Н', 'о', 'О',
            'п', 'П', 'р', 'Р', 'с', 'С', 'т', 'Т', 'у', 'У', 'ф', 'Ф', 'х', 'Х', 'ц', 'Ц', 'ч', 'Ч', 'ш', 'Ш',
            'щ', 'Щ', 'ь', 'Ь', 'ю', 'Ю', 'я', 'Я', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', ',', ':',
            ';'
    };

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
            System.out.println("Error wrong data, please check your input data");
            CesarScript.key = 3;
        }
        else if (CesarScript.key <= 0 || CesarScript.key >= charArr.length){
            System.out.println("Please enter key from 0 to " + charArr.length);
            CesarScript.key = 3;
        }
    }

    // Encrypt function //
    public static String encryptCesar(String data) {
        // Prepare data and characters //
        String charStr = new String(charArr); // TODO: Need a better decision
        char[] dataArr = data.toCharArray();

        // Encryption process //
        for (int i = 0; i < dataArr.length; i++) {
            int index = charStr.indexOf(dataArr[i]);
            if (index != -1) {
                if (index >= charArr.length - key) {
                    index -= charArr.length;
                } // OutOfRangeException
                dataArr[i] = charArr[index + key];
            }
        }

        // Return encrypted data //
        return new String(dataArr);
    }

    // Decrypt function //
    public static String decryptCesar(String data) {
        // Prepare data and characters //
        String charStr = new String(charArr); // TODO: Need a better decision
        char[] dataArr = data.toCharArray();
        // Encryption process //
        for (int i = 0; i < dataArr.length; i++) {
            int index = charStr.indexOf(dataArr[i]);
            if (index != -1) {
                if (index < key) {
                    index += charArr.length;
                } // OutOfRangeException
                dataArr[i] = charArr[index - key];
            }
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
