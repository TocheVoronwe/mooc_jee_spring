package fr.eservices.drive.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
@Qualifier("MD5Checker")
public class MD5Checker implements PasswordChecker {

    @Override
    public String encode(String login, String password) {
        byte [] digest = null;
        Base64.Encoder encoder = Base64.getEncoder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            digest = md5.digest((login + password).getBytes());
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return encoder.encodeToString(digest);
    }

}
