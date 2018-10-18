package org.apache.fineract.services;


import java.io.IOException;

import org.apache.fineract.models.DebitClientCreditAccountInt;
import org.apache.fineract.models.DebitCreditAccount;
import org.apache.fineract.models.DebitCreditResponse;
import org.apache.fineract.models.DebitCreditTrans;
import org.apache.fineract.models.DebitCreditTransaction;
import org.apache.fineract.models.Savingsaccount;
import org.apache.fineract.models.User;
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
import com.fasterxml.jackson.core.JsonParser.Feature;

public class SavingsService {
	BaseURL burl = new BaseURL();
	HeaderAuth urlheader = new HeaderAuth();
	AuthenticationService auth = new AuthenticationService();
	User user;
	String sessionUsername;
	String sessionPassword;
	final static Logger logger = Logger.getLogger(SavingsService.class);
	
	
	public ResponseEntity<Savingsaccount> getSavingsTranBalance(final Long accountId,String username,String password)throws Exception {
		ResponseEntity<Savingsaccount> saveAcctDetails = null;
		sessionUsername = username;
		sessionPassword = password;		
		user = auth.loginUser(sessionUsername, sessionPassword);
		if(user.isAuthenticated()!= false) {
		try {
			String URL = burl.getUrl();
		    URL = URL + "savingsaccounts/" + accountId;
		 // HttpHeaders
	        //HttpHeaders headers = new HttpHeaders();
	        HttpHeaders headers = urlheader.getHeader(sessionUsername, sessionPassword);
	        // Authentication
	        //String auth = USER_NAME + ":" + PASSWORD;
	        //byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
	        //String authHeader = "Basic " + new String(encodedAuth);
	        //headers.set("Authorization", authHeader);
	        
	        //headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
	        // Request to return JSON format
	        //headers.setContentType(MediaType.APPLICATION_JSON);
	        //headers.set("Fineract-Platform-TenantId", "default");
	        
	        HttpEntity<Savingsaccount> requestBody = new HttpEntity<>(headers);
	        
	        // RestTemplate
	        RestTemplate restTemplate = new RestTemplate();
	        //saveAcctDetails = restTemplate.getForObject(URL, requestBody, Savingsaccount.class);
	         saveAcctDetails = restTemplate.exchange(URL,HttpMethod.GET, requestBody, Savingsaccount.class);
			
		}catch (Exception ex) { 
			System.out.println(ex.getMessage());
			//Logging.log(exception);
			ex.printStackTrace();
			throw new Exception("Connection refused to connect");
		}
		}else {
			throw new Exception("Authentication for connection required");
		}
	    return saveAcctDetails;
	}
	
	public Double getSavingsValBalance(final Long accountId,String username,String password)throws Exception {
		ResponseEntity<Savingsaccount> result = null;
		Double val = null;
		sessionUsername = username;
		sessionPassword = password;		
		user = auth.loginUser(sessionUsername, sessionPassword);
		if(user.isAuthenticated()!= false) {
		try {
			
			String URL = burl.getUrl();
		    URL = URL + "savingsaccounts/" + accountId;
		    HttpHeaders headers = urlheader.getHeader(sessionUsername, sessionPassword);
	        
	        HttpEntity<Savingsaccount> entity = new HttpEntity<Savingsaccount>(headers);
	        
	        // RestTemplate
	        RestTemplate restTemplate = new RestTemplate();
	        //saveAcctDetails = restTemplate.getForObject(URL, requestBody, Savingsaccount.class);
	         //saveAcctDetails = restTemplate.exchange(URL,HttpMethod.GET, requestBody, Savingsaccount.class);
	        result = restTemplate.exchange(URL,HttpMethod.GET, entity, Savingsaccount.class);
	        val = result.getBody().getSummary().getAvailableBalance();
			
		}catch (Exception ex) { 
			System.out.println(ex.getMessage());
			//Logging.log(exception);
			ex.printStackTrace();
			throw new Exception("Connection refused to connect");
		}
		}else {
			throw new Exception("Authentication for connection required");
		}
	    return val;
	}
	
	public Savingsaccount getSavingsTransactions(final Long accountId,String username,String password)throws Exception {
		ResponseEntity<Savingsaccount> result = null;
		Savingsaccount val = null;
		sessionUsername = username;
		sessionPassword = password;
		user = auth.loginUser(sessionUsername, sessionPassword);
		if(user.isAuthenticated()!= false) {
		try {
			String URL = burl.getUrl();
		    URL = URL + "savingsaccounts/" + accountId;
		 // HttpHeaders
		    HttpHeaders headers = urlheader.getHeader(sessionUsername, sessionPassword);
	        
	        // Authentication
	        //String auth = USER_NAME + ":" + PASSWORD;
	        //byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
	        //String authHeader = "Basic " + new String(encodedAuth);
	        //headers.set("Authorization", authHeader);
	        
	        //headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
	        // Request to return JSON format
	        //headers.setContentType(MediaType.APPLICATION_JSON);
	        //headers.set("Fineract-Platform-TenantId", "default");
	        
	        HttpEntity<Savingsaccount> entity = new HttpEntity<Savingsaccount>(headers);
	        
	        // RestTemplate
	        RestTemplate restTemplate = new RestTemplate();
	        //saveAcctDetails = restTemplate.getForObject(URL, requestBody, Savingsaccount.class);
	         //saveAcctDetails = restTemplate.exchange(URL,HttpMethod.GET, requestBody, Savingsaccount.class);
	        result = restTemplate.exchange(URL,HttpMethod.GET, entity, Savingsaccount.class);
	        val = result.getBody();
			
		}catch (Exception ex) { 
			System.out.println(ex.getMessage());
			//Logging.log(exception);
			ex.printStackTrace();
			throw new Exception("Connection refused to connect");
		}
		}else {
			throw new Exception("Authentication for connection required");
		}
		
	    return val;
	}
	public DebitCreditResponse DebitSavingsCreditInternalAccount(DebitClientCreditAccountInt tranReq,Long accountId,
			String username,String password)throws Exception {
       DebitCreditResponse tranResp = null;
		
		DebitCreditTransaction v_tran = new DebitCreditTransaction();
		v_tran.setAmount(tranReq.getAmt());
		v_tran.setChargeId(tranReq.getChargeId());
		v_tran.setDateFormat(tranReq.getDateFormat());
		v_tran.setLocale(tranReq.getLocale());
		v_tran.setDueDate(tranReq.getDueDate());
		
		DebitCreditResponse chargeV = accountCharge(v_tran,accountId,username,password);
		Long savingsAccountChargeId = chargeV.getResourceId();
		System.out.println(savingsAccountChargeId);
		String jsonInString = null;
		try {
			String URL = burl.getUrl();
		    URL = URL + "savingsaccounts/" + accountId + "/charges/" + savingsAccountChargeId + "?command=paycharge";
	        HttpHeaders headers = urlheader.getHeader(username, password);		        
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
	        // Convert object to JSON string
	        try {
	        	DebitCreditAccount v_tranReq = new DebitCreditAccount();
	        	v_tranReq.setAmount(tranReq.getAmt());
	        	v_tranReq.setDateFormat(tranReq.getDateFormat());
	        	v_tranReq.setLocale(tranReq.getLocale());
	        	v_tranReq.setDueDate(tranReq.getDueDate());
	        	
	        	//Method 1
	        	jsonInString = mapper.writeValueAsString(v_tranReq);
				System.out.println(jsonInString);
				//Method 2
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(v_tranReq);
				System.out.println(jsonInString);
				
	        }catch (JsonGenerationException e) {
			   e.printStackTrace();
		    } catch (JsonMappingException e) {
			   e.printStackTrace();
		    } catch (IOException e) {
			   e.printStackTrace();
		    }
	        // Continuation Process
	        HttpEntity<String> requestBody = new HttpEntity<>(jsonInString, headers);
	        RestTemplate restTemplate = new RestTemplate();
	        System.out.println("=========POST Method For Client Transaction===========");
	        // Send request with POST method.
	        tranResp = restTemplate.postForObject(URL, requestBody,DebitCreditResponse.class);
	        System.out.println(tranResp.getClientId());
		}
	    catch (HttpClientErrorException e) {
	    	logger.error("error:  " + e.getResponseBodyAsString());
            ObjectMapper mapper = new ObjectMapper();
            ErrorHolder eh = mapper.readValue(e.getResponseBodyAsString(), ErrorHolder.class);
            logger.error("error:  " + eh.getErrorMessage());
	    }
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			logger.error("error:  " + ex.getMessage());
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		return tranResp;
	}
	public DebitCreditResponse accountCharge(DebitCreditTransaction tranReq,Long accountId,
			String username,String password)throws Exception {
		DebitCreditResponse tranResp = null;
		String jsonInString = null;
		try {
			String URL = burl.getUrl();
		    URL = URL + "savingsaccounts/" + accountId + "/charges";
	        HttpHeaders headers = urlheader.getHeader(username, password);		        
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
	        // Convert object to JSON string
	        try {
	        	//Method 1
	        	jsonInString = mapper.writeValueAsString(tranReq);
				System.out.println(jsonInString);
				//Method 2
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tranReq);
				System.out.println(jsonInString);
				
	        }catch (JsonGenerationException e) {
			   e.printStackTrace();
		    } catch (JsonMappingException e) {
			   e.printStackTrace();
		    } catch (IOException e) {
			   e.printStackTrace();
		    }
	        // Continuation Process
	        HttpEntity<String> requestBody = new HttpEntity<>(jsonInString, headers);
	        RestTemplate restTemplate = new RestTemplate();
	        System.out.println("=========POST Method===========");
	        // Send request with POST method.
	        tranResp = restTemplate.postForObject(URL, requestBody,DebitCreditResponse.class);
	        System.out.println(tranResp.getClientId());
		}
	    catch (HttpClientErrorException e) {
	    	logger.error("error:  " + e.getResponseBodyAsString());
            ObjectMapper mapper = new ObjectMapper();
            ErrorHolder eh = mapper.readValue(e.getResponseBodyAsString(), ErrorHolder.class);
            logger.error("error:  " + eh.getErrorMessage());
	    }
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			logger.error("error:  " + ex.getMessage());
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		return tranResp;
	}
	public DebitCreditResponse DebitClientCreditInternalAccount(DebitClientCreditAccountInt tranReq,Long clientId,
			String username,String password)throws Exception {
		DebitCreditResponse tranResp = null;
		
		DebitCreditTransaction v_tran = new DebitCreditTransaction();
		v_tran.setAmount(tranReq.getAmt());
		v_tran.setChargeId(tranReq.getChargeId());
		v_tran.setDateFormat(tranReq.getDateFormat());
		v_tran.setLocale(tranReq.getLocale());
		v_tran.setDueDate(tranReq.getDueDate());
		
		DebitCreditResponse chargeV = clientCharge(v_tran,clientId,username,password);
		Long clientChargeId = chargeV.getResourceId();
		System.out.println(clientChargeId);
		String jsonInString = null;
		try {
			String URL = burl.getUrl();
		    URL = URL + "clients/" + clientId + "/charges/" + clientChargeId + "?command=paycharge";
	        HttpHeaders headers = urlheader.getHeader(username, password);		        
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
	        // Convert object to JSON string
	        try {
	        	DebitCreditTrans v_tranReq = new DebitCreditTrans();
	        	v_tranReq.setAmount(tranReq.getAmount());
	        	v_tranReq.setDateFormat(tranReq.getDateFormat());
	        	v_tranReq.setLocale(tranReq.getLocale());
	        	v_tranReq.setTransactionDate(tranReq.getTransactionDate());
	        	
	        	//Method 1
	        	jsonInString = mapper.writeValueAsString(v_tranReq);
				System.out.println(jsonInString);
				//Method 2
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(v_tranReq);
				System.out.println(jsonInString);
				
	        }catch (JsonGenerationException e) {
			   e.printStackTrace();
		    } catch (JsonMappingException e) {
			   e.printStackTrace();
		    } catch (IOException e) {
			   e.printStackTrace();
		    }
	        // Continuation Process
	        HttpEntity<String> requestBody = new HttpEntity<>(jsonInString, headers);
	        RestTemplate restTemplate = new RestTemplate();
	        System.out.println("=========POST Method For Client Transaction===========");
	        // Send request with POST method.
	        tranResp = restTemplate.postForObject(URL, requestBody,DebitCreditResponse.class);
	        System.out.println(tranResp.getClientId());
		}
	    catch (HttpClientErrorException e) {
	    	logger.error("error:  " + e.getResponseBodyAsString());
            ObjectMapper mapper = new ObjectMapper();
            ErrorHolder eh = mapper.readValue(e.getResponseBodyAsString(), ErrorHolder.class);
            logger.error("error:  " + eh.getErrorMessage());
	    }
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			logger.error("error:  " + ex.getMessage());
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		return tranResp;
	}
	public DebitCreditResponse clientCharge(DebitCreditTransaction tranReq,Long clientId,
			String username,String password)throws Exception {
		DebitCreditResponse tranResp = null;
		String jsonInString = null;
		try {
			String URL = burl.getUrl();
		    URL = URL + "clients/" + clientId + "/charges";
	        HttpHeaders headers = urlheader.getHeader(username, password);		        
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
	        // Convert object to JSON string
	        try {
	        	//Method 1
	        	jsonInString = mapper.writeValueAsString(tranReq);
				System.out.println(jsonInString);
				//Method 2
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tranReq);
				System.out.println(jsonInString);
				
	        }catch (JsonGenerationException e) {
			   e.printStackTrace();
		    } catch (JsonMappingException e) {
			   e.printStackTrace();
		    } catch (IOException e) {
			   e.printStackTrace();
		    }
	        // Continuation Process
	        HttpEntity<String> requestBody = new HttpEntity<>(jsonInString, headers);
	        RestTemplate restTemplate = new RestTemplate();
	        System.out.println("=========POST Method For Client Charge===========");
	        // Send request with POST method.
	        tranResp = restTemplate.postForObject(URL, requestBody,DebitCreditResponse.class);
	        System.out.println(tranResp.getClientId());
		}
	    catch (HttpClientErrorException e) {
	    	logger.error("error:  " + e.getResponseBodyAsString());
            ObjectMapper mapper = new ObjectMapper();
            ErrorHolder eh = mapper.readValue(e.getResponseBodyAsString(), ErrorHolder.class);
            logger.error("error:  " + eh.getErrorMessage());
	    }
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			logger.error("error:  " + ex.getMessage());
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		return tranResp;
	}

}
