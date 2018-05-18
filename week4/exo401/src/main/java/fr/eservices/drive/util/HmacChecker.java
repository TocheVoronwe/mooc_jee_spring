package fr.eservices.drive.util;

import com.sun.crypto.provider.HmacSHA1;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import java.security.Key;
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
			Mac mac = Mac.getInstance("HmacSHA1");
			//mac.init(login);
			mac.doFinal(bytes);
		}
		catch (NoSuchAlgorithmException nsae)
		{
			nsae.printStackTrace();
		}
		return encoder.encodeToString(bytes);
	}

}
