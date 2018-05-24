package fr.eservices.drive.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
@Qualifier("HmacChecker")
public class HmacChecker implements PasswordChecker {

    @Override
    public String encode(String login, String password) {
        byte[] bytes = null;
        Base64.Encoder encoder = Base64.getEncoder();
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(login.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            bytes = mac.doFinal(password.getBytes());
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        } catch (InvalidKeyException ike) {
            ike.printStackTrace();
        }
        return encoder.encodeToString(bytes);
    }

}
