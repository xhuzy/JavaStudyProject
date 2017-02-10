package com.youyou.mybatisstudy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.youyou.mybatisstudy.bo.Teacher;

public interface IClassDao {

	public int insertClass(Class clss, Teacher teacher);

	public List<Class> getAllClass();

	public com.youyou.mybatisstudy.bo.Class getClassByID(String classID);
}
