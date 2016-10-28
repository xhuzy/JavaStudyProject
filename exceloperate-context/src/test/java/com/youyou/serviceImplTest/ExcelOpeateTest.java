package com.youyou.serviceImplTest;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.youyou.excelOperate.model.PersonInfo;
import com.youyou.excelOperate.service.IExcelOpeateService;
import com.youyou.excelOperate.serviceImpl.ExcelOperateServiceImplcsv;
import com.youyou.excelOperate.serviceImpl.ExcelOperateServiceImplxls;
import com.youyou.excelOperate.serviceImpl.ExcelOperateServiceImplxlsx;

import junit.framework.TestCase;

public class ExcelOpeateTest extends TestCase {

	
	@Test
	public void testReadDataFomrxls() {
		IExcelOpeateService sevice = new ExcelOperateServiceImplxls();
		String path = this.getClass().getClassLoader().getResource("personExcel/Person1.xls").getPath();
		List<PersonInfo> lstPerson = sevice.readExcelDate(path);

		assertEquals(3, lstPerson.size());
	}

	@Test
	public void testWriteDataFomrxls() {
		IExcelOpeateService sevice = new ExcelOperateServiceImplxls();
		List<PersonInfo> lstPerson = new ArrayList<PersonInfo>();
		PersonInfo p1 = new PersonInfo();
		p1.setAge(20);
		p1.setName("yong");
		p1.setIdCard("ID:521268");

		PersonInfo p2 = new PersonInfo();
		p2.setAge(19);
		p2.setName("yuping");
		p2.setIdCard("ID:521296");

		lstPerson.add(p1);
		lstPerson.add(p2);

		boolean result = sevice.write2Excel(lstPerson);
		assertEquals(true, result);
	}
	
	
	
	
	
	@Test
	public void testReadDataFomrxlsx() {
		IExcelOpeateService sevice = new ExcelOperateServiceImplxlsx();
		String path = this.getClass().getClassLoader().getResource("personExcel/Person2.xlsx").getPath();
		List<PersonInfo> lstPerson = sevice.readExcelDate(path);

		assertEquals(2, lstPerson.size());
	}

	@Test
	public void testWriteDataFomrxlsx() {
		IExcelOpeateService sevice = new ExcelOperateServiceImplxlsx();
		List<PersonInfo> lstPerson = new ArrayList<PersonInfo>();
		PersonInfo p1 = new PersonInfo();
		p1.setAge(20);
		p1.setName("zhao");
		p1.setIdCard("ID:521268");

		PersonInfo p2 = new PersonInfo();
		p2.setAge(19);
		p2.setName("zeng");
		p2.setIdCard("ID:521296");

		lstPerson.add(p1);
		lstPerson.add(p2);

		boolean result = sevice.write2Excel(lstPerson);
		assertEquals(true, result);
	}
	
	@Test
	public void testReadDataFomrcsv() {
		IExcelOpeateService sevice = new ExcelOperateServiceImplcsv();
		String path = this.getClass().getClassLoader().getResource("personExcel/Person3.csv").getPath();
		List<PersonInfo> lstPerson = sevice.readExcelDate(path);

		assertEquals(2, lstPerson.size());
	}

	@Test
	public void testWriteDataFomrcsv() {
		IExcelOpeateService sevice = new ExcelOperateServiceImplcsv();
		List<PersonInfo> lstPerson = new ArrayList<PersonInfo>();
		PersonInfo p1 = new PersonInfo();
		p1.setAge(20);
		p1.setName("zhaocsv");
		p1.setIdCard("ID:521268csv");

		PersonInfo p2 = new PersonInfo();
		p2.setAge(19);
		p2.setName("zengcsv");
		p2.setIdCard("ID:521296csv");

		lstPerson.add(p1);
		lstPerson.add(p2);

		boolean result = sevice.write2Excel(lstPerson);
		assertEquals(true, result);
	}
}
