package org.apache.fineract.controller;

/*
import java.util.List;
import org.apache.fineract.exception.ConnectException;
import org.apache.fineract.exception.ResourceException;
import org.apache.fineract.models.LoginUser;
import org.apache.fineract.models.Role;
import org.apache.fineract.models.Savingsaccount;
import org.apache.fineract.models.User;
import org.apache.fineract.services.AuthenticationService;
import org.apache.fineract.services.SavingsService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;




@RestController
@RequestMapping("/api")
@Api(value="mifosapi", description="Operations for mifos api")
public class RestApiController {
	final static Logger logger = Logger.getLogger(RestApiController.class);
	AuthenticationService authsev = new AuthenticationService(); 
	SavingsService savesev = new SavingsService();
	//private LoginUser loginuser;
	

	 @ApiOperation(value = "View a list of available api",response = Iterable.class)
	 @ApiResponses(value = {
	 @ApiResponse(code = 500, message = "Connection refused to connect"),
	 @ApiResponse(code = 200, message = "Successfully retrieved list"),
	 @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	 @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	 @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	 })
	
	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	User userAuthentication(@RequestParam("username") String username,
			@RequestParam("password") String password,Authentication authentication) throws Exception {  
		 
		final String USER_NAME = username;
	    final String PASSWORD = password;
	    //String auth1 = authentication.toString();
	    //System.out.println("Authentication Value: " + auth1);
	    //UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	    //System.out.println("User has authorities: " + userDetails.getAuthorities());
	    //System.out.println("User has authorities: " + userDetails.getPassword());
	    //System.out.println("User name: " + authentication.getName());
	    //System.out.println("User name: " + authentication.getPrincipal());
	    //System.out.println("UserPassword detail: " + authentication.getDetails().toString());

	    User authuser = null;
	    //LoginUser userlog = getLoginUser(authentication);
	    //System.out.println("Login User's is : " + userlog.toString());
	    try {  
	        authuser = authsev.loginUser(USER_NAME, PASSWORD);
	        List<Role> rol = authuser.getRoles();
	        boolean isLogged = authsev.isLoggedIn();
	        if(isLogged == true) {
	        System.out.println("Is User authenticated: " + authuser.isAuthenticated());
	        System.out.println("Fetched User Role : " + authuser.getRoles());
	        System.out.println("Fetched List Role : " + rol.get(0));
	        System.out.println("Fetched User Role Name : " + rol.get(0).getName());
	        }
	        
		} catch (ConnectException mcex) {
	        mcex.printStackTrace();
	    } catch (ResourceException mrex) {
	        mrex.printStackTrace();
	    }
	        
	        return authuser;
	    }
	 
	 @ApiOperation(value = "Account transactions for savings with accountId")
	  @RequestMapping(value = "/savingstransactions/{accountId}", method= RequestMethod.GET)
	  ResponseEntity<Savingsaccount> getSavingsTranBalance(@PathVariable("accountId") long accountId,
			  Authentication authentication) throws Exception {
	        System.out.println("Fetching Savings Account Balance with accountId " + accountId);
	        ResponseEntity<Savingsaccount> sTran = null;
	        LoginUser userlog = getLoginUser(authentication);
		    //System.out.println("Login User's is : " + userlog.toString());
		    String sessesionUser = userlog.getUsername();
		    String sessionPassword = userlog.getPassword();
	        try {
	        	sTran = savesev.getSavingsTranBalance(accountId,sessesionUser,sessionPassword);
	        	//System.out.println("Fetched Customer account balance : " + sTran.getAvailableBalance());
	        	
	        } catch (ConnectException mcex) {
		        mcex.printStackTrace();
		    } catch (ResourceException mrex) {
		        mrex.printStackTrace();
		    }
	       
	        return sTran;
	    }
	  @ApiOperation(value = "Account available balance for savings with accountId")
	  @RequestMapping(value = "/savingsaccounts/{accountId}", method= RequestMethod.GET)
	  Double getSavingsBalance(@PathVariable("accountId") long accountId,Authentication authentication) throws Exception {
	        System.out.println("Fetching Savings Account Balance with accountId " + accountId);
	        Double sTran = null;
	        LoginUser userlog = getLoginUser(authentication);
		    //System.out.println("Login User's is : " + userlog.toString());
		    String sessesionUser = userlog.getUsername();
		    String sessionPassword = userlog.getPassword();
	        try {
	        	sTran = savesev.getSavingsValBalance(accountId,sessesionUser,sessionPassword);
	        	System.out.println("Fetched Customer account balance : " + sTran);
	        	
	        } catch (ConnectException mcex) {
		        mcex.printStackTrace();
		    } catch (ResourceException mrex) {
		        mrex.printStackTrace();
		    }
	       
	        return sTran;
	    }
    //--
	//public static void main(String[] args) throws IOException, ConnectException, ResourceException{
		//final String USER_NAME = "mifos";
	    //final String PASSWORD = "password";
	    //AuthenticationService authsev = new AuthenticationService();
      //try {  
        //final String authuser = authsev.loginUser(USER_NAME, PASSWORD);
        //final User authuser = authsev.loginUser(USER_NAME, PASSWORD);
        //boolean isLogged = authsev.isLoggedIn();
        //if(isLogged == true) {
        //System.out.println("Fetched User : " + authuser);
        //System.out.println("Fetched User : " + authuser.getRoles());
        //}
        
	//} catch (ConnectException mcex) {
        //mcex.printStackTrace();
    //} catch (ResourceException mrex) {
        //mrex.printStackTrace();
    //}
      //authsev.logout();
	//}//---
	  
	public LoginUser getLoginUser(Authentication authentication) {
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println("User has authorities: " + userDetails.getAuthorities());
		System.out.println("UserLogin User: " + userDetails.getUsername());
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