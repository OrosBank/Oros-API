package org.apache.fineract.controller;
/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.fineract.models.ChannelUsers;
import org.apache.fineract.models.Ebanking;
import org.apache.fineract.models.User;
import org.apache.fineract.services.IEbankingService;

@Controller
@RequestMapping("/api")
public class RestEbankingController {
	
	@Autowired
	private IEbankingService ebankingService;
	
	//@GetMapping("authentication")
	//public ResponseEntity<Ebanking> userAuthentication(@RequestParam("username") String username,@RequestParam("password") String password) {
		//Ebanking ebanking = ebankingService.getEbankingLogin(username,password);
		//return new ResponseEntity<Ebanking>(ebanking, HttpStatus.OK);
	//}
	@GetMapping("authentication")
	public ResponseEntity<ChannelUsers> userAuthentication(@RequestParam("username") String username,@RequestParam("password") String password) {
		ChannelUsers echannel = ebankingService.getAauthUser(username,password);
		return new ResponseEntity<ChannelUsers>(echannel, HttpStatus.OK);
	}
	@GetMapping("ebanking/{id}")
	public ResponseEntity<Ebanking> getEbankingById(@PathVariable("id") Integer id) {
		Ebanking ebanking = ebankingService.getEbankingById(id);
		return new ResponseEntity<Ebanking>(ebanking, HttpStatus.OK);
	}
	
	@GetMapping("ebankings")
	public ResponseEntity<List<Ebanking>> getAllEbankings() {
		List<Ebanking> list = ebankingService.getAllEbankings();
		return new ResponseEntity<List<Ebanking>>(list, HttpStatus.OK);
	}
	@PostMapping("ebanking")
	public ResponseEntity<Void> addEbanking(@RequestBody Ebanking ebanking, UriComponentsBuilder builder) {
        boolean flag = ebankingService.addEbanking(ebanking);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/ebanking/{id}").buildAndExpand(ebanking.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("ebanking")
	public ResponseEntity<Ebanking> updateEbanking(@RequestBody Ebanking ebanking) {
		ebankingService.updateEbanking(ebanking);
		return new ResponseEntity<Ebanking>(ebanking, HttpStatus.OK);
	}
	@DeleteMapping("ebanking/{id}")
	public ResponseEntity<Void> deleteEbanking(@PathVariable("id") Integer id) {
		ebankingService.deleteEbanking(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}
*/