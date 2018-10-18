package org.apache.fineract.utils;

import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HeaderAuth {
	private HttpHeaders headers;
	
	public HttpHeaders getHeader(String username,String password){
	
	// HttpHeaders
	final String USER_NAME = username;
	final String PASSWORD = password;
    headers = new HttpHeaders();
    
    // Authentication
    String auth = USER_NAME + ":" + PASSWORD;
    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
    String authHeader = "Basic " + new String(encodedAuth);
    headers.set("Authorization", authHeader);
    
    //headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    // Request to return JSON format
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Fineract-Platform-TenantId", "default");
    headers.set("Content-Type", "application/json");
    headers.set("Cache-Control", "no-cache");
    //headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    
    return headers;
	}

}
