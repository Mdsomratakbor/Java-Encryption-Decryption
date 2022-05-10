package EncryptionDecryptionServices;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DecryptionService implements  IDecryptionService{

    public String Decrypt(String encrypt, String key) throws Exception {
        if (encrypt == null || encrypt.isEmpty()) {
            System.out.println("No data to decrypt!");
            return encrypt;
        }
        String decryptedString = "";
        Cipher cipher = null;
        try {
            // Creating a Cipher object
            cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

            // Creating a secret key from KEY byte array
            final SecretKeySpec secretKey = new SecretKeySpec(AlgorithmKey.KEY, "AES");

            // Initializing a Cipher object
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Decoding from Base64
            byte[] encryptedText = Base64.getDecoder().decode(encrypt.getBytes());

            // Decrypting to plain text
            decryptedString = new String(cipher.doFinal(encryptedText));

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException
                | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println("Exception caught while decrypting : " + ex);
        }
        return decryptedString.replace(key, "");
    }

}
