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
			// ���崫���socket�����÷���˿�Ϊ6789
			TServerSocket serverTransport = new TServerSocket(6789);

			// ����Э�鹤��Ϊ TBinaryProtocol.Factory
			Factory proFactory = new Factory(true, true);

			// ������������ Hello�����ʵ��
			IThriftTestInterfaceThriftService.Processor processor = new Processor(new ThriftTestServerImpl());

			// �������˵Ĳ���ֵ
			Args args = new Args(serverTransport);
			args.processor(processor);
			args.protocolFactory(proFactory);
			TServer server = new TThreadPoolServer(args);
			System.out.println("��������");
			// ����˿�������s
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
