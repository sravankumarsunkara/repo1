package com.slokam.ebank.pojo;

import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="login")
public class UserPojo {
	private Integer id;
	private String userName;
	private String password;
	private String status;
	private Float balance;
	private String role;
	private Collection<TransactionPojo> TxCol;
	
	@Column(name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	//@Transient
	@OneToMany(mappedBy="pojo")
	
	public Collection<TransactionPojo> getTxCol() {
		return TxCol;
	}
	public void setTxCol(Collection<TransactionPojo> txCol) {
		TxCol = txCol;
	}
   @Id
   @GeneratedValue(generator = "auto_increment")
   @GenericGenerator(name="auto_increment",strategy="increment")
   @Column(name="id")
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="balance")
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}

}
