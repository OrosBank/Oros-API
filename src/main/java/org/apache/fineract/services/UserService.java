package org.apache.fineract.services;

import java.io.IOException;

import org.apache.fineract.models.PasswordChange;
import org.apache.fineract.models.PasswordChangeRes;
import org.apache.fineract.utils.BaseURL;
import org.apache.fineract.utils.ErrorHolder;
import org.apache.fineract.utils.HeaderAuth;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {
	BaseURL burl = new BaseURL();
	HeaderAuth urlheader = new HeaderAuth();
	final static Logger logger = Logger.getLogger(UserService.class);
	
	public PasswordChangeRes updateclientpwd (Long userId,PasswordChange pwdreq,String username,String password) throws Exception {
		ResponseEntity<PasswordChangeRes> clientpwd = null;
		PasswordChangeRes pwdclient = null;
		String jsonInString = null;
		String sessionUsername = username;
		String sessionPassword = password;
		try {
			String URL = burl.getUrl();
		    URL = URL + "users/" + userId;
	        HttpHeaders headers = urlheader.getHeader(sessionUsername, sessionPassword);		        
	        ObjectMapper mapper = new ObjectMapper();
	        try {
				// Convert object to JSON string
				jsonInString = mapper.writeValueAsString(pwdreq);
				System.out.println(jsonInString);

				// Convert object to JSON string and pretty print
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pwdreq);
				System.out.println(jsonInString);

			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        HttpEntity<String> requestBody = new HttpEntity<>(jsonInString, headers);
	        RestTemplate restTemplate = new RestTemplate();
	   
	        // Send request with POST method.
	        //clientpwd = restTemplate.postForObject(URL, requestBody,PasswordChangeRes.class); 
	        clientpwd = restTemplate.exchange(URL, HttpMethod.PUT, requestBody, PasswordChangeRes.class);
	        pwdclient = clientpwd.getBody();
	        //String name = clientpwd.getBody().getChanges().getFirstname();
	        //System.out.println(name);
		   }catch (HttpClientErrorException e)
	        {
	            /**
	             *
	             * If we get a HTTP Exception display the error message
	             */
			   logger.error("error:  " + e.getResponseBodyAsString());
	            ObjectMapper mapper = new ObjectMapper();
	            ErrorHolder eh = mapper.readValue(e.getResponseBodyAsString(), ErrorHolder.class);
	            logger.error("error:  " + eh.getErrorMessage());
	            throw new Exception(eh.getErrorMessage());
	        }  
			
		    catch (Exception ex) { 
			System.out.println(ex.getMessage());
			logger.error("error:  " + ex.getMessage());
			//Logging.log(exception);
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		
		return pwdclient;
	}

}
