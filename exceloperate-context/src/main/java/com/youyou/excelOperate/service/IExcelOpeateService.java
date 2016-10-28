package com.youyou.excelOperate.service;

import java.io.File;
import java.util.List;

import com.youyou.excelOperate.model.PersonInfo;

public interface IExcelOpeateService {
	public List<PersonInfo> readExcelDate(String path);

	public boolean write2Excel(List<PersonInfo> lstParam);
}
