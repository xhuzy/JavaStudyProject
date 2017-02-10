package com.youyou.mybatisstudy.bo;

import java.util.Date;

import javax.management.loading.PrivateClassLoader;

/**
 * @author ziang
 *  teacher entity
 */
public class Teacher {
	private String id;
	private String name;
	private Date birthday;

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
}
