package com.slokam.ebank.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="phone")
public class PhonePojo {
private Integer id;
private String num;
private String network;
private Integer plan;
private PersonPojo person;
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
@Column(name="num")
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
@Column(name="network")
public String getNetwork() {
	return network;
}
public void setNetwork(String network) {
	this.network = network;
}
@Column(name="plan")
public Integer getPlan() {
	return plan;
}

public void setPlan(Integer plan) {
	this.plan = plan;
}
@ManyToOne
@JoinColumn(name="pid")
public PersonPojo getPerson() {
	return person;
}
public void setPerson(PersonPojo person) {
	this.person = person;
}

}
