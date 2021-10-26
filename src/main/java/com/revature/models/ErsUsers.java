package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ers_users")
public class ErsUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ers_users_id", nullable=false)
    private int ersUsersId;
    
    @Column(name = "ers_username", length=50, nullable=false)
    private String ersUsername;
    
    @Column(name = "ers_password", length=50, nullable=false)
    private String ersPassword;
    
    @Column(name = "ers_first_name", length=100, nullable=false)
    private String ersFirstName;
    
    @Column(name = "ers_last_name", length=100, nullable=false)
    private String ersLastName;
    
    @Column(name = "ers_email", length=150, nullable=false)
    private String ersEmail;
    
    private int ersRoleId;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "userRoleId")
    private ErsUserRoles ersRoles;

	public ErsUsers(int ersUsersId, String ersUsername, String ersPassword, String ersFirstName, String ersLastName,
			String ersEmail, int ersRoleId, ErsUserRoles ersRoles) {
		super();
		this.ersUsersId = ersUsersId;
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.ersFirstName = ersFirstName;
		this.ersLastName = ersLastName;
		this.ersEmail = ersEmail;
		this.ersRoleId = ersRoleId;
		this.ersRoles = ersRoles;
	}

	public ErsUsers(String ersUsername, String ersPassword, String ersFirstName, String ersLastName, String ersEmail,
			int ersRoleId, ErsUserRoles ersRoles) {
		super();
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.ersFirstName = ersFirstName;
		this.ersLastName = ersLastName;
		this.ersEmail = ersEmail;
		this.ersRoleId = ersRoleId;
		this.ersRoles = ersRoles;
	}

	public ErsUsers() {
		super();
	}

	public int getErsUsersId() {
		return ersUsersId;
	}

	public void setErsUsersId(int ersUsersId) {
		this.ersUsersId = ersUsersId;
	}

	public String getErsUsername() {
		return ersUsername;
	}

	public void setErsUsername(String ersUsername) {
		this.ersUsername = ersUsername;
	}

	public String getErsPassword() {
		return ersPassword;
	}

	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}

	public String getErsFirstName() {
		return ersFirstName;
	}

	public void setErsFirstName(String ersFirstName) {
		this.ersFirstName = ersFirstName;
	}

	public String getErsLastName() {
		return ersLastName;
	}

	public void setErsLastName(String ersLastName) {
		this.ersLastName = ersLastName;
	}

	public String getErsEmail() {
		return ersEmail;
	}

	public void setErsEmail(String ersEmail) {
		this.ersEmail = ersEmail;
	}

	public int getErsRoleId() {
		return ersRoleId;
	}

	public void setErsRoleId(int ersRoleId) {
		this.ersRoleId = ersRoleId;
	}

	public ErsUserRoles getErsRoles() {
		return ersRoles;
	}

	public void setErsRoles(ErsUserRoles ersRoles) {
		this.ersRoles = ersRoles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersEmail == null) ? 0 : ersEmail.hashCode());
		result = prime * result + ((ersFirstName == null) ? 0 : ersFirstName.hashCode());
		result = prime * result + ((ersLastName == null) ? 0 : ersLastName.hashCode());
		result = prime * result + ((ersPassword == null) ? 0 : ersPassword.hashCode());
		result = prime * result + ersRoleId;
		result = prime * result + ((ersUsername == null) ? 0 : ersUsername.hashCode());
		result = prime * result + ersUsersId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsUsers other = (ErsUsers) obj;
		if (ersEmail == null) {
			if (other.ersEmail != null)
				return false;
		} else if (!ersEmail.equals(other.ersEmail))
			return false;
		if (ersFirstName == null) {
			if (other.ersFirstName != null)
				return false;
		} else if (!ersFirstName.equals(other.ersFirstName))
			return false;
		if (ersLastName == null) {
			if (other.ersLastName != null)
				return false;
		} else if (!ersLastName.equals(other.ersLastName))
			return false;
		if (ersPassword == null) {
			if (other.ersPassword != null)
				return false;
		} else if (!ersPassword.equals(other.ersPassword))
			return false;
		if (ersRoleId != other.ersRoleId)
			return false;
		if (ersUsername == null) {
			if (other.ersUsername != null)
				return false;
		} else if (!ersUsername.equals(other.ersUsername))
			return false;
		if (ersUsersId != other.ersUsersId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsUsers [ersUsersId=" + ersUsersId + ", ersUsername=" + ersUsername + ", ersPassword=" + ersPassword
				+ ", ersFirstName=" + ersFirstName + ", ersLastName=" + ersLastName + ", ersEmail=" + ersEmail
				+ ", ersRoleId=" + ersRoleId + ", ersRoles=" + ersRoles + "]";
	}
    
    

	

}
