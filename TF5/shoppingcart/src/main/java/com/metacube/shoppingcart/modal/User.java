package com.metacube.shoppingcart.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;






@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.AUTO)
		private int userId;
	
	
	@Column(name = "mail")
	private String mail;
		
		public int getUserId() {
			return userId;
		}
		
		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		public String getMail() {
			return mail;
		}
		
		public void setMail(String mail) {
			this.mail = mail;
		}
}
