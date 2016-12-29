package com.youyou.service;

import java.util.Date;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "serviceDao")
public class ServiceRouteDao {
	@Resource(name = "jdbcTemplete")
	private JdbcTemplate template;

	/////Ĭ��ֻ���RunTimeException����rollBack�����������rollbackFor=Exception.class���������쳣�Խ��лع�����
	@Transactional(rollbackFor=Exception.class)
	public int addServiceroute() throws Exception {
		String sqlStr = "INSERT INTO `zyServiceRouteDB`.`ServiceRoute` (`RouteID`, `ContractName`, `ServiceType`, `CallSystem`, `MachineNO`, `DataCenter`, `UniqueSign`, `BindingType`, `ServiceIP`, `ServicePort`, `SvcPath`, `IsValid`, `ModifyTime`, `IsDelete`, `IsVirtualAddress`, `ProgramName`, `RouteStatus`, `RequestIP`, `ResponseServiceSetID`, `Remark`, `RequestServiceSetID`, `IsValidReason`, `RouteAddType`) VALUES (?, 'com.better517na.hotelGeographyDataService.service.IHotelGeographyDataThriftService', 'java', '�Ƶ������Ϣ���ݷ���', '001', 'NW', '888888', 'thrift', '192.168.6.34', '1004', '', '1', '2016-08-05 18:50:08', '0', '0', '', '1', '', '', '', '', '', ?);";
		int i = this.template.update(sqlStr, new Date().toString().substring(1, 20), 5);
		throw new RuntimeException("�׳�����");
	}
}
