package fr.eservices.drive.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("MD5Checker")
public class MD5Checker implements PasswordChecker {

	@Override
	public String encode(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
