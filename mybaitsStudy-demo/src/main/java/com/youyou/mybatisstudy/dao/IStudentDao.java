package com.youyou.mybatisstudy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.youyou.mybatisstudy.bo.Student;

public interface IStudentDao {
	/**
	 * @param ����ѧ��
	 * @return
	 */
	public int insertStudent(Student student);

	/**
	 * @param ����ID��ȡѧ����Ϣ
	 * @return
	 */
	public Student getStudentByID(@Param("id")String id);

	/**
	 * @param ���հ༶��ȡѧ��
	 * @return
	 */
	public List<Student> getStudentByClassID(String classID);

}
