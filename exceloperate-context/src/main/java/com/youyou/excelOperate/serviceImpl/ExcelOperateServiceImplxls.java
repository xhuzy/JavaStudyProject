package com.youyou.excelOperate.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.youyou.excelOperate.model.PersonInfo;
import com.youyou.excelOperate.service.IExcelOpeateService;

/**
 * @author ziang
 *
 */
public class ExcelOperateServiceImplxls implements IExcelOpeateService {

	@SuppressWarnings("resource")
	@Override
	public List<PersonInfo> readExcelDate(String paths) {
		List<PersonInfo> result = new ArrayList<PersonInfo>();

		try {
			Workbook xssfWorkbook = null;
			FileInputStream fileInputStream = new FileInputStream(new File(paths));
			xssfWorkbook = new HSSFWorkbook(fileInputStream);
			int sheetCount = xssfWorkbook.getNumberOfSheets();
			for (int i = 0; i < sheetCount; i++) {
				// 读取财务上传的excel
				Sheet xssfSheet = xssfWorkbook.getSheetAt(i);
				result.addAll(this.getPersonInfoFromSheet(xssfSheet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean write2Excel(List<PersonInfo> lstParam) {
		try{
		Workbook newWorkbook=new HSSFWorkbook();
		Sheet sheet1=newWorkbook.createSheet("person");
		Sheet sheet2=newWorkbook.createSheet("sheet2");
		for (int i=0;i<lstParam.size();i++) {
			Row row=sheet1.createRow(i);
			row.createCell(0).setCellValue(lstParam.get(i).getIdCard());
			row.createCell(1).setCellValue(lstParam.get(i).getName());
			row.createCell(2).setCellValue(lstParam.get(i).getAge());
		}
		
		sheet2.createRow(0).createCell(0).setCellValue("testxls");
		String filePath="D:"+File.separator+"excelExport"+File.separator;
		String fullFileName=filePath+"test1.xls";
		File dir=new File(filePath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		
	    newWorkbook.write(new FileOutputStream(fullFileName));
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param sheet
	 * @return
	 */
	private List<PersonInfo> getPersonInfoFromSheet(Sheet sheet) {

		List<PersonInfo> result = new ArrayList<PersonInfo>();
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			PersonInfo personInfo = new PersonInfo();
			row.getCell(0).setCellType(1);
			personInfo.setIdCard(row.getCell(0).getStringCellValue());
			row.getCell(1).setCellType(1);
			personInfo.setName(row.getCell(1).getStringCellValue());
			row.getCell(2).setCellType(1);
			personInfo.setAge(Integer.parseInt(row.getCell(2).getStringCellValue()));

			result.add(personInfo);

			// for(int j=0;j<row.getLastCellNum();j++){
			// personInfo.setIdCard(row.getCell(j).getStringCellValue());
			// }
		}
		return result;
	}

}
