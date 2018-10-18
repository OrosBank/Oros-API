package org.apache.fineract.controller;
/*
import java.util.Map;

import org.apache.fineract.models.clients.ActivatePayload;
import org.apache.fineract.models.clients.Client;
import org.apache.fineract.models.clients.ClientAddressRequest;
import org.apache.fineract.models.clients.ClientAddressResponse;
import org.apache.fineract.models.clients.ClientImage;
import org.apache.fineract.models.clients.ClientRequest;
import org.apache.fineract.models.clients.ClientResponse;
import org.apache.fineract.models.templates.clients.ClientsTemplate;
import org.apache.fineract.services.ClientsService;
import org.apache.fineract.services.SavingsService;
import org.apache.fineract.models.GenericResponse;
import org.apache.fineract.models.LoginUser;
import org.apache.fineract.models.accounts.ClientAccounts;
import org.apache.fineract.models.clients.PageableClients;
import org.apache.fineract.models.noncore.Identifier;
import org.apache.fineract.models.noncore.IdentifierPayload;
import org.apache.fineract.models.noncore.IdentifierTemplate;
import org.apache.fineract.exception.ConnectException;
import org.apache.fineract.exception.ResourceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;


@RestController
@RequestMapping("/api")
@Api(value="mifosapi", description="Operations for mifos api")
public class RestClientController {
	ClientsService clientsev = new ClientsService();
	
	 @ApiOperation(value = "View a list of available api",response = Iterable.class)
	 @ApiResponses(value = {
	 @ApiResponse(code = 500, message = "Connection refused to connect"),
	 @ApiResponse(code = 200, message = "Successfully retrieved list"),
	 @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	 @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	 @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	 })
	 
	 @RequestMapping(value = "/clients}", method= RequestMethod.GET)
	 PageableClients getAllClients(final Map<String, Object> queryMap) {
		 PageableClients pageclient = null; 
		return pageclient;
		 
	 }

	 @RequestMapping(value = "/clients/{clientId}", method= RequestMethod.GET)
	 Client getClient(@PathVariable("clientId") int clientId) {
	     Client client = null;
		return client;
	    	
	}

	    @RequestMapping(value = "/clients/{clientId}/images", method= RequestMethod.POST)
	    ClientImage uploadClientImage(@PathVariable("clientId") int clientId,@RequestParam("file") MultipartFile file) {
	    	ClientImage imageclient = null;
			return imageclient;
	    	
	    }

	    @RequestMapping(value = "/clients/{clientId}/images", method= RequestMethod.DELETE)
	    ClientImage deleteClientImage(@PathVariable("clientId") int clientId) {
	    	ClientImage delimageclient = null;
			return delimageclient;
	    	
	    }

	    @RequestMapping(value = "/clients", method= RequestMethod.POST)
	    ClientResponse createClient(@RequestBody ClientRequest clientreq,Authentication authentication) throws Exception {
	    	ClientResponse client = null;
	    	LoginUser userlog = getLoginUser(authentication);
		    System.out.println("Login User's is : " + userlog.toString());
		    String sessesionUser = userlog.getUsername();
		    String sessionPassword = userlog.getPassword();
		    try {
		    	System.out.println("Fetched Client request : " + clientreq.toString());
		    	client = clientsev.clientCreation(clientreq,sessesionUser,sessionPassword);
	        	System.out.println("Fetched Client info : " + client.toString());
	        	
	        } catch (ConnectException mcex) {
		        mcex.printStackTrace();
		    } catch (ResourceException mrex) {
		        mrex.printStackTrace();
		    }
			return client;
	    	
	    }

	    @RequestMapping(value = "/clients/template", method= RequestMethod.GET)
	    ClientsTemplate getClientTemplate() {
	    	ClientsTemplate clientstemp = null;
			return clientstemp;
	    	
	    }

	    @RequestMapping(value = "/clients/{clientId}/accounts", method= RequestMethod.GET)
	    ClientAccounts getClientAccounts(@PathVariable("clientId") int clientId) {
	    	ClientAccounts clientacct = null;
			return clientacct;
	    	
	    }

	    @RequestMapping(value = "/clients/{clientId}/identifiers", method= RequestMethod.GET)
	    List<Identifier> getClientIdentifiers(@PathVariable("clientId") int clientId){
			return null;
	    	
	    }

	    @RequestMapping(value = "/clients/{clientId}/identifiers", method= RequestMethod.POST)
	    GenericResponse createClientIdentifier(@PathVariable("clientId") int clientId,
	                                                       @RequestBody IdentifierPayload identifierPayload) {
															return null;
	    	
	    }

	    @RequestMapping(value = "/clients/{clientId}/identifiers/template", method= RequestMethod.GET)
	    IdentifierTemplate getClientIdentifierTemplate(@PathVariable("clientId") int clientId) {
			return null;
	    	
	    }

	    @RequestMapping(value = "/clients/{clientId}/identifiers/{identifierId}", method= RequestMethod.DELETE)
	    GenericResponse deleteClientIdentifier(@PathVariable("clientId") int clientId,
	                                                       @PathVariable("identifierId") int identifierId) {
															return null;
	    	
	    }

	    @RequestMapping(value = "/datatables/client_pinpoint_location/{clientId}", method= RequestMethod.GET)
	    List<ClientAddressResponse> getClientPinpointLocations(@PathVariable("clientId") int clientId){
			return null;
	    	
	    }

	    @RequestMapping(value = "/datatables/client_pinpoint_location/{clientId}", method= RequestMethod.POST)
	    GenericResponse addClientPinpointLocation(@PathVariable("clientId") int clientId,
	                                                             @RequestBody ClientAddressRequest clientAddressRequest){
																	return null;
	    	
	    }

	    @RequestMapping(value = "/datatables/client_pinpoint_location/{apptableId}/{datatableId}", method= RequestMethod.DELETE)
	    GenericResponse deleteClientPinpointLocation(@PathVariable("apptableId") int apptableId,
	                                                             @PathVariable("datatableId") int datatableId) {
																	return null;
	    	
	    }

	    @RequestMapping(value = "/datatables/client_pinpoint_location/{apptableId}/{datatableId}", method= RequestMethod.PUT)
	    GenericResponse updateClientPinpointLocation(@PathVariable("apptableId") int apptableId,
	                                                             @PathVariable("datatableId") int datatableId,
	                                                             @RequestBody ClientAddressRequest address) {
																	
	    	GenericResponse response = null;
	    	return response;
	    	
	    }

	    @RequestMapping(value = "/clients/{clientId}?command=activate", method= RequestMethod.POST)
	    GenericResponse activateClient(@PathVariable("clientId") int clientId,
	                                               @RequestBody ActivatePayload clientActivate) {
													return null;
	    	
	    }
	    
	    public LoginUser getLoginUser(Authentication authentication) {
			//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			System.out.println("User has authorities: " + userDetails.getAuthorities());
			System.out.println("UserLogin User: " + userDetails.getUsername());
			System.out.println("UserLogin Password: " + userDetails.getPassword());
			LoginUser loginuser = new LoginUser();
			  String userId = null;
			  String password = null;
			  if (userDetails.getUsername() != "") {
				 userId = authentication.getName();
				 System.out.println("UserLogin UserId: " + userId);
				 if(userId == "telcoil") {
					userId = "telcoil";
					password = "Unix@123"; 
					loginuser.setUsername("telcoil");
					loginuser.setPassword("Unix@123");
				 }else {
					 LoginUser u = new LoginUser();
					 userId = u.getUsername();
					 password = u.getPassword();
					 
					 loginuser.setUsername(userId);
				     loginuser.setPassword(password);
				 }
			  }
			  return loginuser;
		  }

}
*/