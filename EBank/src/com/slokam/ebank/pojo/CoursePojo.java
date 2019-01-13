package com.slokam.ebank.pojo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="course")
public class CoursePojo {
private Integer id;
private String name;
private Integer duration;
private Integer fee;
private Collection<PersonPojo> person;
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
@Column(name="name")
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Column(name="duration")
public Integer getDuration() {
	return duration;
}
public void setDuration(Integer duration) {
	this.duration = duration;
}
@Column(name="fee")
public Integer getFee() {
	return fee;
}
public void setFee(Integer fee) {
	this.fee = fee;
}
@ManyToMany
@JoinTable(name="person_course",
           joinColumns={@JoinColumn(name="cid")},
           inverseJoinColumns={@JoinColumn(name="pid")})
public Collection<PersonPojo> getPerson() {
	return person;
}
public void setPerson(Collection<PersonPojo> person) {
	this.person = person;
}

}
