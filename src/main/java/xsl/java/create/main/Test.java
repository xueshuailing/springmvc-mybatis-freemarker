package xsl.java.create.main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sendMessageInfo();
	}

	public static void getRemoteId(){
		  
		String add_url = "http://192.168.1.115:8080/weixin/my/tbtype/update.html";
		String query = "{\"type\":\""+0+"\",\"name\":\""+1231+"\",\"userId\":\""+2+"\",\"birthDateAccurate\":\""+12+"\",\"addrId\":\""+123+"\"}";
		try {
			URL url = new URL(add_url);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
		connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			JSONObject obj = new JSONObject();
			String token = "d5f224c9f83874da5b5025794c773e8e";
		obj.put("query", query);
			obj.put("token", token);
			out.writeBytes(query);
			out.flush();
			out.close();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sbf = new StringBuffer();
			while ((lines = reader.readLine()) != null) {
			lines = new String(lines.getBytes(), "utf-8");
			sbf.append(lines);
			}
			System.out.println(sbf);
			reader.close();
			// 断开连接
			connection.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		 
   }
	public static   String sendMessageInfo(){
		 
		String output = "error";
		String s;
		 try {
			 String add_url = "http://192.168.1.115:8080/weixin/my/tbtype/update.html";
			//接口URL
				URL url = new URL(add_url);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			//将短信内容转换为JSON字符串进行转码
				String jsonString =  "{\"type\":\""+0+"\",\"name\":\""+1231+"\",\"userId\":\""+2+"\",\"birthDateAccurate\":\""+12+"\",\"addrId\":\""+123+"\"}";
				//
				OutputStream os = conn.getOutputStream();
				os.write(jsonString.getBytes("utf-8"));
				os.flush();
			
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream()),"utf-8"));
		 
				
				System.out.println("Output from Server .... \n");
			
				while (( s= br.readLine()) != null) {
					 	output= s;
				}
		 
				conn.disconnect();
		 
			  } catch (MalformedURLException e) {
		 
				e.printStackTrace();
		 
			  } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return output;  
	 }
}
