package org.apache.fineract.services;

import java.io.IOException;

import org.apache.fineract.models.User;
import org.apache.fineract.models.accounts.ClientAccounts;
import org.apache.fineract.models.clients.Client;
import org.apache.fineract.models.clients.ClientRequest;
import org.apache.fineract.models.clients.ClientResponse;
import org.apache.fineract.models.clients.ClientTransaction;
import org.apache.fineract.models.clients.Page;
import org.apache.fineract.utils.BaseURL;
import org.apache.fineract.utils.ErrorHolder;
import org.apache.fineract.utils.HeaderAuth;
import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import org.codehaus.jackson.map.ObjectMapper;

public class ClientsService {
	BaseURL burl = new BaseURL();
	HeaderAuth urlheader = new HeaderAuth();
	AuthenticationService auth = new AuthenticationService();
	User user;
	String sessionUsername;
	String sessionPassword;
	final static Logger logger = Logger.getLogger(ClientsService.class);
	
	public ClientResponse clientCreation(ClientRequest clientReq,String username,String password) throws Exception {
		ClientResponse client = null;
		String jsonInString = null;
		sessionUsername = username;
		sessionPassword = password;
		user = auth.loginUser(sessionUsername, sessionPassword);
		if(user.isAuthenticated()!= false) {
			try {
				String URL = burl.getUrl();
			    URL = URL + "clients";
		        HttpHeaders headers = urlheader.getHeader(sessionUsername, sessionPassword);		        
		        ObjectMapper mapper = new ObjectMapper();

				try {
					// Convert object to JSON string
					jsonInString = mapper.writeValueAsString(clientReq);
					System.out.println(jsonInString);

					// Convert object to JSON string and pretty print
					jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientReq);
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
		        client = restTemplate.postForObject(URL, requestBody,ClientResponse.class); 
		        
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
		        }  
				
			    catch (Exception ex) { 
				System.out.println(ex.getMessage());
				logger.error("error:  " + ex.getMessage());
				//Logging.log(exception);
				ex.printStackTrace();
				throw new Exception(ex.getMessage());
			}
		}
		else {
			throw new Exception("Authentication for connection required");
		}
		return client;
		
	}
	public ResponseEntity<Client> getClientId(int clientId,String username,String password) throws Exception {
		ResponseEntity<Client> client = null;
		String URL = burl.getUrl();
	    URL = URL + "clients/" + clientId;
        HttpHeaders headers = urlheader.getHeader(username, password);
        HttpEntity<Client> requestBody = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        client = restTemplate.exchange(URL,HttpMethod.GET, requestBody, Client.class);
		return client;
	}
	public Page<Client> getAllClients(String username,String password) {
		ResponseEntity<Page<Client>> client = null;
		String URL = burl.getUrl();
	    URL = URL + "clients";
        HttpHeaders headers = urlheader.getHeader(username, password);
        HttpEntity<Page<Client>> requestBody = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        client = restTemplate.exchange(URL,HttpMethod.GET, requestBody,new ParameterizedTypeReference <Page<Client>> () {});
        System.out.println(client.getBody().getPageItems());
        System.out.println(client.getBody().getTotalFilteredRecords());
        Page<Client> obj = client.getBody();
		return obj;
		
	}
	public ResponseEntity<ClientAccounts> getAllClientAccounts(int clientId,String username,String password) throws Exception {
		ResponseEntity<ClientAccounts> account = null;
		String URL = burl.getUrl();
	    URL = URL + "clients/" + clientId + "/accounts";
        HttpHeaders headers = urlheader.getHeader(username, password);
        HttpEntity<ClientAccounts> requestBody = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        account = restTemplate.exchange(URL,HttpMethod.GET, requestBody, ClientAccounts.class);
		return account;
	}
	
	public Page<ClientTransaction> getAllClientTransactions (int clientId,String username,String password){
		ResponseEntity<Page<ClientTransaction>> tran = null;
		String URL = burl.getUrl();
	    URL = URL + "clients/" + clientId + "/transactions";
        HttpHeaders headers = urlheader.getHeader(username, password);
        HttpEntity<Page<ClientTransaction>> requestBody = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        tran = restTemplate.exchange(URL,HttpMethod.GET, requestBody,new ParameterizedTypeReference < Page <ClientTransaction>> () {});
        System.out.println(tran.getBody().getPageItems());
        System.out.println(tran.getBody().getTotalFilteredRecords());
        Page<ClientTransaction> obj = tran.getBody();
		return obj;		
	}
	
	public ResponseEntity<ClientTransaction> getClientTransactionById(int clientId,int transactionId,
			String username,String password) throws Exception {
		ResponseEntity<ClientTransaction> trans = null;
		String URL = burl.getUrl();
	    URL = URL + "clients/" + clientId + "/transactions/" + transactionId;
        HttpHeaders headers = urlheader.getHeader(username, password);
        HttpEntity<ClientTransaction> requestBody = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        trans = restTemplate.exchange(URL,HttpMethod.GET, requestBody, ClientTransaction.class);
		return trans;
	}

}
