package br.com.fernandes.HashCode;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordEncodeAndMatches {
	
	 static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	 
	public static String encodePassword(String senha) {
		String passwordHash = passwordEncoder.encode(senha);
		
		return passwordHash;
	}

	public static boolean matchPassword(String hash, String senha) {
		boolean isPasswordMatch  = passwordEncoder.matches(senha, hash);
		
		return isPasswordMatch;
	}
}
