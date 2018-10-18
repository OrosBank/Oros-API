package org.apache.fineract.controller;


import org.apache.fineract.models.CardManagement;
import org.apache.fineract.models.ChannelUsers;
import org.apache.fineract.models.ChargeMappingValue;
import org.apache.fineract.models.ChargeTransaction;
import org.apache.fineract.models.DebitClientCreditAccountInt;
import org.apache.fineract.models.DebitCreditResponse;
import org.apache.fineract.models.DebitCreditTransaction;
import org.apache.fineract.models.PasswordChange;
import org.apache.fineract.models.PasswordChangeRes;
import org.apache.fineract.models.TransactionResponse;
import org.apache.fineract.models.accounts.ClientAccounts;
import org.apache.fineract.models.clients.Client;
import org.apache.fineract.models.clients.ClientRequest;
import org.apache.fineract.models.clients.ClientResponse;
import org.apache.fineract.models.clients.ClientTransaction;
import org.apache.fineract.models.clients.Page;

import org.apache.fineract.services.IEbankingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value="mifosapi", description="Operations for mifos api")
public class RestApiControllers {
	final static Logger logger = Logger.getLogger(RestApiControllers.class);
	String sessesionUser   = "mifos";
    String sessionPassword = "Unix@123";
	
	@Autowired
	private IEbankingService ebankingService;
	
	@ApiOperation(value = "For API user's authentication",response = Iterable.class)
	 @ApiResponses(value = {
	 @ApiResponse(code = 500, message = "Connection refused to connect"),
	 @ApiResponse(code = 200, message = "Successfully retrieved list"),
	 @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	 @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	 @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	 })
	
	@PostMapping("authentication")
	public ResponseEntity<ChannelUsers> userAuthentication(@RequestParam("username") String username,@RequestParam("password") String password) {
		ChannelUsers echannel = ebankingService.getAauthUser(username,password);
		return new ResponseEntity<ChannelUsers>(echannel, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Obtain Client Retrieve details with clientId")
	@GetMapping("clients/{clientId}")
	public ResponseEntity<Client> getClientById(@PathVariable("clientId") int clientId) {
		ResponseEntity<Client> client = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("User Login: " + authentication.getName());
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println("UserLogin User: " + userDetails.getUsername());
		if(authentication.isAuthenticated() == true && userDetails.getUsername() != null) {
		    client = ebankingService.findClientById(clientId,sessesionUser,sessionPassword);
			return client;
		}else {
			throw new UsernameNotFoundException("User authentication failed");
		}
	}
	
	@ApiOperation(value = "Retrieve all clients list")
	@GetMapping("clients")
	public ResponseEntity<Page<Client>> getAllClients() {
		Page<Client> clients = ebankingService.getAllClients(sessesionUser,sessionPassword);
		return new ResponseEntity<Page<Client>>(clients, HttpStatus.OK);
	}
	
	@ApiOperation(value = "To create a client or customer in mifos")
	@PostMapping("clients")
	public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest clientreq) {
		ClientResponse client = null;
		client = ebankingService.clientCreation(clientreq,sessesionUser,sessionPassword);
		return new ResponseEntity<ClientResponse>(client, HttpStatus.OK);
	}
	@ApiOperation(value = "Retrieve Client Accounts(savings,current,loan and so on) in mifos")
	@GetMapping("clients/{clientId}/accounts")
	public ResponseEntity<ClientAccounts> getClientAccounts(@PathVariable("clientId") int clientId) {		
		ResponseEntity<ClientAccounts> account = null;
		account = ebankingService.getAllClientAccounts(clientId,sessesionUser,sessionPassword);
		return account;
	}
	@ApiOperation(value = "List Client Transactions")
	@GetMapping("clients/{clientId}/transactions")
	public ResponseEntity<Page<ClientTransaction>> getAllClientTransactions(@PathVariable("clientId") int clientId) {
		Page<ClientTransaction> trans = ebankingService.getAllClientTransactions(clientId,sessesionUser,sessionPassword);
		return new ResponseEntity<Page<ClientTransaction>>(trans, HttpStatus.OK);		
	}
	@ApiOperation(value = "Retrieve a Client Transaction")
	@GetMapping("clients/{clientId}/transactions/{transactionId}")
	public ResponseEntity<ClientTransaction> getClientTransactionById(@PathVariable("clientId") int clientId,
			@PathVariable("transactionId") int transactionId) {
		ResponseEntity<ClientTransaction> trans = ebankingService.getClientTransactionById(clientId,transactionId,sessesionUser,sessionPassword);
		return trans;		
	}
	@ApiOperation(value = "Updating a client password")
	@PutMapping("users/{userId}")
	public ResponseEntity<PasswordChangeRes> updateClientPassword(@PathVariable("userId") Long userId,@RequestBody PasswordChange clientpwd) {
		PasswordChangeRes pwd = ebankingService.updateClientPassword(userId,clientpwd,sessesionUser,sessionPassword);
		return new ResponseEntity<PasswordChangeRes>(pwd, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Fetch Customer Primary Card Account information")
	@GetMapping("customer/{accountId}")
	public ResponseEntity<CardManagement> getCardInfo(@PathVariable("accountId") String accountId) {
		CardManagement manCard = ebankingService.getCustId(accountId);		
		return new ResponseEntity<CardManagement>(manCard,HttpStatus.OK);
	}
	@ApiOperation(value = "Direct account Debit and Internal Credit using account Id")
	@PostMapping("accountDebitCredit/{accountId}")
	public ResponseEntity<TransactionResponse> createDebitCredit(@PathVariable("accountId") Long accountId,@RequestBody DebitClientCreditAccountInt tranreq) throws Exception {
		DebitCreditResponse tranResp = null;
		TransactionResponse vtranResp = new TransactionResponse("99", null, null, "N", "");
		//Date time = new Date();
		//vtranResp.setPostedFlag("N");
		//vtranResp.setResponseCode("99");
		//vtranResp.setTranId("");
		//vtranResp.setPostedDate(time);
		//vtranResp.setTranDate(time);
		try {
		tranResp = ebankingService.debitCreditCreation(tranreq,accountId,sessesionUser,sessionPassword);
		vtranResp = ebankingService.getTranDebitCredit(tranResp.getSavingsId(), tranResp.getResourceId());
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<TransactionResponse>(vtranResp, HttpStatus.OK);
	}
	@ApiOperation(value = "Direct client Debit and Internal Credit using customer Id")
	@PostMapping("clientDebitCredit/{clientId}")
	public ResponseEntity<DebitCreditResponse> internalDebitCredit(@PathVariable("clientId") Long clientId,
			@RequestBody DebitClientCreditAccountInt tranreq) {
		DebitCreditResponse tranResp = null;
		tranResp = ebankingService.internalDebitCreditCreation(tranreq,clientId,sessesionUser,sessionPassword);
		return new ResponseEntity<DebitCreditResponse>(tranResp, HttpStatus.OK);
	}
	//ChargeTransaction
	@ApiOperation(value = "Direct Debit of Customer account and Office Internal account Credit")
	@PostMapping("accountDebitCredit")
	public ResponseEntity<TransactionResponse> createDebitCredit(@RequestBody ChargeTransaction chrgreq) throws Exception {
		ChargeMappingValue vmap = null;
		//DebitClientCreditAccountInt acctReq = null;
		DebitClientCreditAccountInt acctReq = new DebitClientCreditAccountInt();
		DebitCreditResponse tranResp = null;
		TransactionResponse vtranResp = new TransactionResponse("99", null, null, "N", "");
		//Date time = new Date();
		//vtranResp.setPostedFlag("N");
		//vtranResp.setResponseCode("99");
		//vtranResp.setTranId("");
		//vtranResp.setPostedDate(time);
		//vtranResp.setTranDate(time);
		try {
			vmap   = ebankingService.getAcctMapping(chrgreq);
			Long accountId = vmap.getAccountId();
			acctReq.setAmount(vmap.getAmount());
			acctReq.setAmt(vmap.getAmt());
			acctReq.setChargeId(vmap.getChargeId());
			acctReq.setDateFormat(vmap.getDateFormat());
			acctReq.setDueDate(vmap.getDueDate());
			acctReq.setLocale(vmap.getLocale());
			acctReq.setTransactionDate(vmap.getTransactionDate());
			
		    tranResp  = ebankingService.debitCreditCreation(acctReq,accountId,sessesionUser,sessionPassword);
		    vtranResp = ebankingService.getTranDebitCredit(tranResp.getSavingsId(), tranResp.getResourceId());
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<TransactionResponse>(vtranResp, HttpStatus.OK);
	}
}
