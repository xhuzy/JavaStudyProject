package httpstestDemo;

public class test {
	private String url = "https://open.517la.com/api/hand";
	//private String url = "http://192.168.1.115:5432/api/hand";

	private String charset = "utf-8";
	private HttpClientUtil httpClientUtil = null;

	public test() {
		httpClientUtil = new HttpClientUtil();
	}

	public void test1() {
		String param = "{\"version\": \"1.0\",\"requestid\": \"requestID\",\"method\": \"token.gettoken\",\"data\": {\"appid\": \"201605251157262871086969\",\"appsecret\": \"2016120618430069876\"}}";

		String httpOrgCreateTestRtn = httpClientUtil.doPost(url, param, charset);

		System.out.println(httpOrgCreateTestRtn);
	}

	public static void main(String[] args) {
		test main = new test();
		main.test1();
	}

}
