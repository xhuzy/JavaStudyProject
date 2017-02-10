package com.youyou.mybatisStudy.daoTest;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.youyou.mybatisStudyTest.BaseTest;
import com.youyou.mybatisstudy.bo.Student;
import com.youyou.mybatisstudy.dao.IStudentDao;

public class StudentDaoTest extends BaseTest {

	@Resource(name = "studentDao")
	private IStudentDao studentDao;

	@Test
	public void getStuentTest() {
		Student student = this.studentDao.getStudentByID("1");
		System.out.println(student);

	}
}
