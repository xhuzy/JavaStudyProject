package com.youyou.thriftTest.main;

import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.youyou.thriftTest.IThriftTestInterfaceThriftService;
import com.youyou.thriftTest.IThriftTestInterfaceThriftService.Processor;
import com.youyou.thriftTest.impl.ThriftTestServerImpl;

public class MainClass {
	public static void main(String[] argss) {
		try {
			// 定义传输的socket，设置服务端口为6789
			TServerSocket serverTransport = new TServerSocket(6789);

			// 设置协议工厂为 TBinaryProtocol.Factory
			Factory proFactory = new Factory(true, true);

			// 关联处理器与 Hello服务的实现
			IThriftTestInterfaceThriftService.Processor processor = new Processor(new ThriftTestServerImpl());

			// 定义服务端的参数值
			Args args = new Args(serverTransport);
			args.processor(processor);
			args.protocolFactory(proFactory);
			TServer server = new TThreadPoolServer(args);
			System.out.println("开启服务");
			// 服务端开启服务s
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
