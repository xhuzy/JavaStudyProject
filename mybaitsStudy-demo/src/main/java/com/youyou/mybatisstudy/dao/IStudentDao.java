package com.youyou.mybatisstudy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.youyou.mybatisstudy.bo.Student;

public interface IStudentDao {
	/**
	 * @param 插入学生
	 * @return
	 */
	public int insertStudent(Student student);

	/**
	 * @param 根据ID获取学生信息
	 * @return
	 */
	public Student getStudentByID(@Param("id")String id);

	/**
	 * @param 按照班级获取学生
	 * @return
	 */
	public List<Student> getStudentByClassID(String classID);

}
