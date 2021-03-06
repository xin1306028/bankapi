package com.flexon.api.bankaccountapi;

import java.util.ArrayList;
import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition;


@RestController
public class BankAccountController {
	
	@Autowired
	bankAccountDAO userlist = new bankAccountDAO();
    BankAccount newUser = new BankAccount("11111","22222","33333","44444","55555");
	
	@GetMapping(path="/hello")
	public String hello() {
		return "This is Xin and this message is not in JSON format";
	}
	
	
	
    @PostMapping(path="/addUser")
    public String addUser(@RequestBody(required=false) BankAccount newUser) {	
    	userlist.insertUser(newUser);
    	return "new user added";
	      
    }
    
    
   
    @GetMapping(path = "/readUser")
    public ArrayList<BankAccount> allUsers(){
    	return userlist.readAllUsers();
    }
    
    @PutMapping(path="/update")
    public boolean updateUser(@RequestBody BankAccount user){
    	return userlist.updateUser(user);
    }
    	
    
    
    @DeleteMapping(path="/delete")
    public void deleteUser(BankAccount account) {
    	userlist.deleteUser(account);
    }
    
    
}
    

