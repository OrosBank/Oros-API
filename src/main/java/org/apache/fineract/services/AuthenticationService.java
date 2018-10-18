package org.apache.fineract.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.codec.binary.Base64;
import org.apache.fineract.exception.ConnectException;
import org.apache.fineract.exception.ResourceException;
import org.apache.fineract.utils.BaseURL;
import org.apache.fineract.utils.ErrorCode;
import org.apache.fineract.utils.ErrorHolder;
import org.apache.log4j.Logger;
import org.apache.fineract.models.User;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.*;

import java.nio.charset.Charset;
import java.util.Arrays;

public class AuthenticationService {
	User user;
	BaseURL burl = new BaseURL();
	private boolean loggedIn = false;
	User responseUser = null;
	final static Logger logger = Logger.getLogger(AuthenticationService.class);
	public User loginUser(String username, String password) throws Exception {
		try{
		final String USER_NAME = username;
	    final String PASSWORD = password;
	    
	    //String URL = "https://www.orosbank.com/fineract-provider/api/v1/authentication?username=@user&password=@pwd";
	    String URL = burl.getUrl();
	    URL = URL + "authentication?username=@user&password=@pwd";
	    //String URL = "https://www.orosbank.com/fineract-provider/api/v1/authentication";
	    URL = URL.replace("@user", USER_NAME).replace("@pwd", PASSWORD);
		// HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        
        // Authentication
        String auth = USER_NAME + ":" + PASSWORD;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Fineract-Platform-TenantId", "default");
        
     // HttpEntity<String>: To get result as String.
        //HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity<User> requestBody = new HttpEntity<User>(headers);
       
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Send request with PUT method, and Headers.
        //ResponseEntity<User> resp = restTemplate.exchange(URL,HttpMethod.POST, entity, User.class);
        //ResponseEntity<String> response = restTemplate.exchange(URL,HttpMethod.POST, entity, String.class);
        responseUser = restTemplate.postForObject(URL, requestBody, User.class);
        //String result = response.getBody();
        //responseUser = resp.getBody();
        //System.out.println(result);
        
        //if(result != null) {
        if (responseUser != null && responseUser.isAuthenticated() != false) {
        	System.out.println("UserName is: " + responseUser.getUsername());
            this.loggedIn = true;
        }
		}
		catch (HttpClientErrorException e)
        {
        /**
         *
         * If we get a HTTP Exception display the error message
         */
	    logger.error("error:  " + e.getResponseBodyAsString());
        ObjectMapper mapper = new ObjectMapper();
        ErrorHolder eh = mapper.readValue(e.getResponseBodyAsString(), ErrorHolder.class);
        logger.error("error:  " + eh.getErrorMessage());
      }  

		catch (Exception ex) { 
			System.out.println(ex.getMessage());
			//Logging.log(exception);
			ex.printStackTrace();
			throw new Exception("Connection refused to connect");
		} 

		
		//return result;
		return responseUser;
	}
	
	public void logout() {
        this.loggedIn = false;
    }
	public boolean isLoggedIn() {
        return this.responseUser.isAuthenticated();
    }

}
