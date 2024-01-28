package com.ExamGuruOnline.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String email;
	private String name;
	private String userRole;
	private String password;
	private Long organizationId;
	private Long securityQuestionId;
	private String securityAnswer;
	
	
	public User() {
	
	}
	public User(String name, String userRole, String email, String password, Long organizationId,
			Long securityQuestionId, String securityAnswer) {
		super();
		this.name = name;
		this.userRole = userRole;
		this.email = email;
		this.password = password;
		this.organizationId = organizationId;
		this.securityQuestionId = securityQuestionId;
		this.securityAnswer = securityAnswer;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getSecurityQuestionId() {
		return securityQuestionId;
	}

	public void setSecurityQuestionId(Long securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", userRole=" + userRole + ", email=" + email
				+ ", password=" + password + ", organizationId=" + organizationId + ", securityQuestionId="
				+ securityQuestionId + ", securityAnswer=" + securityAnswer + "]";
	}
	
	
}
