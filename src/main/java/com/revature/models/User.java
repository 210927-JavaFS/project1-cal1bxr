package com.revature.models;

public class User {

		@SuppressWarnings("unused")
		private String username;
		private int password;
		@SuppressWarnings("unused")
		private String role;
		
		public User(String username, int password, String role) {
			super();
			this.username = username;
			this.password = password;
			this.role = role;
		}
		public int getPassword() {
			return password;
		}		
}
