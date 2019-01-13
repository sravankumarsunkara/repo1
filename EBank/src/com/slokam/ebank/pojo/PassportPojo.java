package com.slokam.ebank.pojo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="passport")
public class PassportPojo {
	private Integer id;
	private String no;
	private String expDate;
	private String issueDate;
	private PersonPojo person;
	
	@OneToOne
	@JoinColumn(name="pid")
	public PersonPojo getPerson() {
		return person;
	}
	public void setPerson(PersonPojo person) {
		this.person = person;
	}
	@Id
	@GeneratedValue(generator="auto_increment")
	@GenericGenerator(name="auto_increment",strategy="increment")
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="no")
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	@Column(name="expdate")
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	@Column(name="issuedate")
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	

}
