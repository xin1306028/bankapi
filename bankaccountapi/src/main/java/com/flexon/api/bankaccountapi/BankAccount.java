package com.flexon.api.bankaccountapi;


public class BankAccount {

		
		private String accountNumber;
		private String name;
		private String email;
		private String phone;
		private String ssn;
		
		public BankAccount() {
			
		}
		
		public BankAccount(String accountnumber, String name, String email, String phone, String ssn) {
		
			this.accountNumber = accountnumber;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.ssn = ssn;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getSsn() {
			return ssn;
		}

		public void setSsn(String ssn) {
			this.ssn = ssn;
		} 
	}


