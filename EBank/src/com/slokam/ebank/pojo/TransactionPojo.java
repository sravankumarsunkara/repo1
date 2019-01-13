package com.slokam.ebank.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class TransactionPojo {
private Integer id;
private String BankName;
private Integer BankAccNo;
private Float Amount;
private String Date;
private String type;
//private Integer userId;
private UserPojo pojo;
@ManyToOne
@JoinColumn(name="userid")
public UserPojo getPojo() {
	return pojo;
}
public void setPojo(UserPojo pojo) {
	this.pojo = pojo;
}
//@Column(name="userid")
/*public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}*/
@Id
@GeneratedValue
@Column(name="id")
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Column(name="amount")
public Float getAmount() {
	return Amount;
}
public void setAmount(Float amount) {
	Amount = amount;
}
@Column(name="bankname")
public String getBankName() {
	return BankName;
}
public void setBankName(String bankName) {
	
	BankName = bankName;
}
@Column(name="bankaccno")
public Integer getBankAccNo() {
	return BankAccNo;
}
public void setBankAccNo(Integer bankAccNo) {
	BankAccNo = bankAccNo;
}
@Column(name="tdate")
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
@Column(name="type")
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
