package EncryptionDecryptionServices;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.*;


public class EncryptionService implements IEncryptionService {



    public  String encrypt(String encryptedText,String key) throws Exception{
        if (encryptedText == null || encryptedText.isEmpty()) {
            System.out.println("No data to encrypt!");
            return encryptedText;
        }
        Cipher cipher = null;
        String encryptedString = "";
        try {
            // Creating a Cipher object
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Creating a secret key from KEY byte array
            final SecretKeySpec secretKey = new SecretKeySpec(AlgorithmKey.KEY, "AES");

            // Initializing a Cipher object
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypting the plain text string
            byte[] encryptedTextByte = cipher.doFinal(key.concat(encryptedText).getBytes());

            // Encoding the encrypted text to Base64
            encryptedString = Base64.getEncoder().encodeToString(encryptedTextByte);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println("Exception caught while encrypting : " + ex);
        }
        return encryptedString;
    }


}
