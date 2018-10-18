package org.apache.fineract;

import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
public class Main {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("Unix@123"));
		
		String password = "password";
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println(hashedPassword );
		//$2a$10$Tsa73gSGxlx0Ym4eezuUC.Ws5keLF3HCY/jPM3hkHNdWdyUVqG5TO
		
		//$2a$10$1li7CeF1.xT8lfzWZRzNeeSOF61VZiXYdZ/BoSaeYaYoHwWVNdeGC
		//$2a$10$B8kHnj1Z4Lf6Hjl62agT8.wqSeclYlaWYZfFrBdCKbKxYGQ/5ZAK2
		String originalInput = "test input";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		System.out.println(encodedString);
		
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);
		System.out.println(decodedString);
		
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		//String pwd = encoder.matches(password, user.getPassword()); 
		//$2a$10$PSho5ibgvd0e1VUNvsy9B.IxJ3tE0BqF1.1FvnkUSOwcBzdHc3eJ2--Unix@123
		//$2a$10$njjSEChxvF9GH9wjFetZKOmJN66rcLUylGJ58SdBdmByQQOycxA/.---password
		//dGVzdCBpbnB1dA==
		//test input
	}
}  
