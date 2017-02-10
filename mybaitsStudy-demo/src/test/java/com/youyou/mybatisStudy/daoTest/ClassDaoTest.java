package com.youyou.mybatisStudy.daoTest;

import javax.annotation.Resource;

import org.junit.Test;

import com.youyou.mybatisStudyTest.BaseTest;
import com.youyou.mybatisstudy.bo.Class;
import com.youyou.mybatisstudy.dao.IClassDao;

public class ClassDaoTest extends BaseTest {

	@Resource(name = "classDao")
	private IClassDao classDao;

	@Test
	public void getClassByIDTest() {
		Class class1 = this.classDao.getClassByID("1");
		System.out.println(class1);
	}
}
