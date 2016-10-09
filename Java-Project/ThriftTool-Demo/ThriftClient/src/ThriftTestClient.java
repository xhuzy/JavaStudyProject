import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftTestClient {
	public static void main(String[] args) {
		try {

			// 设置调用的服务地址为本地，端口为6789
			TTransport transport = new TSocket("localhost", 6789);
			transport.open();
			// 数据传输协议有：二进制协议、压缩协议、JSON格式协议
			// 这里使用的是二进制协议
			// 协议要和服务端一致
			TBinaryProtocol protocol = new TBinaryProtocol(transport);
			IThriftTestInterfaceThriftService.Client client = new IThriftTestInterfaceThriftService.Client(protocol);
			// 调用服务器端的服务方法
			System.out.println(client.serviceInvoke("ziang"));
			int i = client.string2Int("223");
			System.out.println(i);
			// 关闭
			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
	}
}
