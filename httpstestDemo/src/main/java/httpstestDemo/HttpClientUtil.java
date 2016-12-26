package httpstestDemo;

import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;  
import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.NameValuePair;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.util.EntityUtils;  
/* 
 * ����HttpClient����post����Ĺ����� 
 */  
public class HttpClientUtil {  
    public String doPost(String url,String param,String charset){  
        HttpClient httpClient = null;  
        HttpPost httpPost = null;  
        String result = null;  
        try{
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");
            //���ò��� 
            StringEntity stringEntity = new StringEntity(param);  
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost);  
            if(response != null){
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);  
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }  
}  