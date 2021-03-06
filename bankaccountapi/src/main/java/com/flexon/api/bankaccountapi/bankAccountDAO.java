package com.flexon.api.bankaccountapi;
import java.sql.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;



@Component
public class bankAccountDAO {

		
		
		String DELETE = "DELETE FROM usertable WHERE name = ?";
		String SELECTALL = "SELECT * FROM usertable";
	    String FINDUSER = "SELECT * FROM usertable WHERE accountnumber = ?";
		String INSERT = "INSERT INTO usertable(accountnumber,name, phone, email,ssn) VALUES(?, ?, ?,?,?)";
		String UPDATE = "UPDATE usertable SET name = ?, phone = ?, email = ? WHERE accountnumber = ?";
		
		Connection con = connectingDB.getConnection();
 
        
        
       
        
	    // create method: add one new customer to the user table
	    public void insertUser(BankAccount user) {
        	
	        try{
	        	
	        	PreparedStatement st = con.prepareStatement(INSERT);
	        	st.setString(1, user.getAccountNumber());
	        	st.setString(2, user.getName());
	        	st.setString(3, user.getPhone());
	        	st.setString(4, user.getEmail());
	        	st.setString(5, user.getSsn());
	        	
	        	st.executeUpdate();
	        	
	        }catch(SQLException e) { 
	            e.printStackTrace(); 
	        } 	    
	    }
	    
	    
	    
	    
	    
	    
	    
	    // read method: read all users using select * query
	    public ArrayList<BankAccount> readAllUsers(){
	    	
	       ArrayList<BankAccount> users = new ArrayList<BankAccount>();
	       
           try{
	        	
	        	PreparedStatement st = con.prepareStatement(SELECTALL);
	        	ResultSet result = st.executeQuery();
	        	
	        	while (result.next()) {
					BankAccount user = new BankAccount();
					String accountNumber = result.getString("accountnumber");
					String Name = result.getString("name");				
					String Email = result.getString("email");
					String phoneNumber = result.getString("phone");
					String Ssn = result.getString("ssn");
					users.add(new BankAccount(accountNumber,Name,Email,phoneNumber,Ssn));
	 
	        	}
	        }catch(SQLException e) { 
	            e.printStackTrace(); 
	        } 	    
	        
	    
	    return users;
	    }
	    
	    
	    
	    
	    
	    
	    
	    // read method: read user with user's account number
	    public void findUser(BankAccount user) {
	    	try {
	    		PreparedStatement st = con.prepareStatement(FINDUSER);
				st.setString(1, user.getAccountNumber());
				st.executeQuery();
				
	            System.out.println("Successfully find a user, User's account is  " + user.getAccountNumber());
				System.out.println("User's name is: " + user.getName());
				System.out.println("User's email is: " + user.getEmail());
				System.out.println("User's phone is: " + user.getPhone());
				System.out.println("User's SSN is: " + user.getSsn());
				    
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			 
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    //update method: update
	    public boolean updateUser(BankAccount user) {
	    	 try{
	    		 
	    		 PreparedStatement st = con.prepareStatement(UPDATE);
		        	st.setString(1, user.getAccountNumber());
		        	st.setString(2, user.getName());
		        	st.setString(3, user.getPhone());
		        	st.setString(4, user.getEmail());
		        	st.setString(5, user.getSsn());
		        	int success = st.executeUpdate();
		        	if(success == 1) {
		        		System.out.println("Successfully update user's information!");
		        		return true;
		        	}
		        	
		        }catch(SQLException e) { 
		            e.printStackTrace(); 
		        } 	    
		         return false;
		}
		
	    
	    
	    
	    
	    
	    
		//Delete Method  --> Delete a user from user table
		public void deleteUser(BankAccount account) {
			try {
				
				PreparedStatement st = con.prepareStatement(DELETE);
				st.setString(1, account.getAccountNumber());
				st.executeUpdate();
				System.out.println("Successfully delete user : " + account.getName());
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
}		
		