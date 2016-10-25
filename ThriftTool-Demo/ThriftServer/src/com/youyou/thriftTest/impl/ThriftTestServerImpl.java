package com.youyou.thriftTest.impl;

import org.apache.thrift.TException;

import com.youyou.thriftTest.IThriftTestInterfaceThriftService.Iface;

public class ThriftTestServerImpl implements Iface {

	@Override
	public String serviceInvoke(String json) throws TException {
		return "hello" + json;
	}

	@Override
	public int string2Int(String param) throws TException {
		int result = Integer.parseInt(param);
		return result;
	}

}
