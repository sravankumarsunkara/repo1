package com.slokam.ebank.pojo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="person")
public class PersonPojo {
	private Integer id;
	private String name;
	private Integer age;
	private String qual;
	private String gender;
	private PassportPojo passport;
	private Collection<PhonePojo> phone;
	private Collection<CoursePojo> course;
	@ManyToMany
	@JoinTable(name="person_course",
	           joinColumns={@JoinColumn(name="pid")},
	           inverseJoinColumns={@JoinColumn(name="cid")})
	public Collection<CoursePojo> getCourse() {
		return course;
	}
	public void setCourse(Collection<CoursePojo> course) {
		this.course = course;
	}
	@OneToMany(mappedBy="person")
	public Collection<PhonePojo> getPhone() {
		return phone;
	}
	public void setPhone(Collection<PhonePojo> phone) {
		this.phone = phone;
	}
	@OneToOne(mappedBy="person")
	
	public PassportPojo getPassport() {
		return passport;
	}
	public void setPassport(PassportPojo passport) {
		this.passport = passport;
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
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name="qual")
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	@Column(name="gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
