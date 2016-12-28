package com.youyou.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "serviceDao")
public class ServiceRouteDao {
	@Resource(name = "jdbcTemplete")
	private JdbcTemplate template;

	public int addServiceroute() {
		String sqlStr = "INSERT INTO `zyServiceRouteDB`.`ServiceRoute` (`RouteID`, `ContractName`, `ServiceType`, `CallSystem`, `MachineNO`, `DataCenter`, `UniqueSign`, `BindingType`, `ServiceIP`, `ServicePort`, `SvcPath`, `IsValid`, `ModifyTime`, `IsDelete`, `IsVirtualAddress`, `ProgramName`, `RouteStatus`, `RequestIP`, `ResponseServiceSetID`, `Remark`, `RequestServiceSetID`, `IsValidReason`, `RouteAddType`) VALUES (?, 'com.better517na.hotelGeographyDataService.service.IHotelGeographyDataThriftService', 'java', '酒店基础信息数据服务', '001', 'NW', '888888', 'thrift', '192.168.6.34', '1004', '', '1', '2016-08-05 18:50:08', '0', '0', '', '1', '', '', '', '', '', ?);";
		return this.template.update(sqlStr, "springjdbcTest", 5);
	}
}
