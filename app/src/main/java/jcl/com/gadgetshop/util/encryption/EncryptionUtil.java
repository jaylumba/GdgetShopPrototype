package jcl.com.gadgetshop.util.encryption;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import jcl.com.gadgetshop.App;

public class EncryptionUtil {

    private static boolean isEncrypt = true;

    public static String encrypt(String str) {
        if (isEncrypt) {
            AesCbcWithIntegrity.CipherTextIvMac cipherTextIvMac = null;
            try {
                cipherTextIvMac = AesCbcWithIntegrity.encrypt(str, App.getKeys());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            return cipherTextIvMac.toString();
        } else {
            return str;
        }
    }

    public static String decrypt(String cipherTextString) {
        String plainText = cipherTextString;
        if (isEncrypt) {
            //Use the constructor to re-create the CipherTextIvMac class from the string:
            try {
                AesCbcWithIntegrity.CipherTextIvMac cipherTextIvMac = new AesCbcWithIntegrity.CipherTextIvMac(cipherTextString);
                plainText = AesCbcWithIntegrity.decryptString(cipherTextIvMac, App.getKeys());
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            return plainText;
        } else {
            return cipherTextString;
        }
    }
}
