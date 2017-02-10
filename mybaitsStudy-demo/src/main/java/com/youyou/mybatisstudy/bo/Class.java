package com.youyou.mybatisstudy.bo;

import java.util.List;

/**
 * @author ziang 班级实体类
 */
public class Class {
	private String id;
	private String name;
	private Teacher headMaster;
	private List<Student> lstStudent;

	public List<Student> getLstStudent() {
		return lstStudent;
	}

	public void setLstStudent(List<Student> lstStudent) {
		this.lstStudent = lstStudent;
	}

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

	public Teacher getHeadMaster() {
		return headMaster;
	}

	public void setHeadMaster(Teacher headMaster) {
		this.headMaster = headMaster;
	}
}
