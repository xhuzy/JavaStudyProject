package com.youyou.excelOperate.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.youyou.excelOperate.model.PersonInfo;
import com.youyou.excelOperate.service.IExcelOpeateService;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class ExcelOperateServiceImplcsv implements IExcelOpeateService {
	@SuppressWarnings("resource")
	@Override
	public List<PersonInfo> readExcelDate(String paths) {
		List<PersonInfo> result = new ArrayList<PersonInfo>();

		try {
			CSVReader reader = null;
			FileReader fileReader = new FileReader(new File(paths));
			reader = new CSVReader(fileReader);
			result=this.getPersonInfoFromSheet(reader);

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean write2Excel(List<PersonInfo> lstParam) {
		try {

			String filePath = "D:" + File.separator + "excelExport" + File.separator;
			String fullFileName = filePath + "test3.csv";
			File dir = new File(filePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			FileWriter fileWriter = new FileWriter(new File(fullFileName));

			CSVWriter writer = new CSVWriter(fileWriter);

			for (PersonInfo personInfo : lstParam) {
				String[] personStr = new String[3];
				personStr[0] = personInfo.getIdCard();
				personStr[1] = personInfo.getName();
				personStr[2] = "" + personInfo.getAge();
				writer.writeNext(personStr);
			}
			writer.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * @param sheet
	 * @return
	 * @throws IOException
	 */
	private List<PersonInfo> getPersonInfoFromSheet(CSVReader reader) throws IOException {

		List<PersonInfo> result = new ArrayList<PersonInfo>();
		String[] context;
		while ((context = reader.readNext()) != null && context.length > 0) {
			PersonInfo personInfo = new PersonInfo();
			personInfo.setIdCard(context[0]);
			personInfo.setName(context[1]);
			personInfo.setAge(Integer.parseInt(context[2]));

			result.add(personInfo);
		}
		return result;
	}
}
