package com.youyou.mybatisstudy.bo;

import java.util.Date;


public class Student {
	private String id;
	private String name;
	private Date birthday;
	private Class studayClass;
	private Teacher headMaster;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Class getStudayClass() {
		return studayClass;
	}

	public void setStudayClass(Class studayClass) {
		this.studayClass = studayClass;
	}

	public Teacher getHeadMaster() {
		return headMaster;
	}

	public void setHeadMaster(Teacher headMaster) {
		this.headMaster = headMaster;
	}
}
