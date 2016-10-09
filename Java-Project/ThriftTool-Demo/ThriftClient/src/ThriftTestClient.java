import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftTestClient {
	public static void main(String[] args) {
		try {

			// ���õ��õķ����ַΪ���أ��˿�Ϊ6789
			TTransport transport = new TSocket("localhost", 6789);
			transport.open();
			// ���ݴ���Э���У�������Э�顢ѹ��Э�顢JSON��ʽЭ��
			// ����ʹ�õ��Ƕ�����Э��
			// Э��Ҫ�ͷ����һ��
			TBinaryProtocol protocol = new TBinaryProtocol(transport);
			IThriftTestInterfaceThriftService.Client client = new IThriftTestInterfaceThriftService.Client(protocol);
			// ���÷������˵ķ��񷽷�
			System.out.println(client.serviceInvoke("ziang"));
			int i = client.string2Int("223");
			System.out.println(i);
			// �ر�
			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
	}
}
