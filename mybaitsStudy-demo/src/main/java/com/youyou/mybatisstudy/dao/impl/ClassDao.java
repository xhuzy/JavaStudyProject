package com.youyou.mybatisstudy.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.youyou.mybatisstudy.bo.Teacher;
import com.youyou.mybatisstudy.dao.IClassDao;

@Repository(value = "classDao")
public class ClassDao implements IClassDao {

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertClass(Class clss, Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Class> getAllClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.youyou.mybatisstudy.bo.Class getClassByID(String classID) {

		return this.sqlSession.selectOne("com.youyou.mybatisstudy.dao.IClassDao.getClassByID",classID);
	}

}
