package com.mongodb;

import java.net.UnknownHostException;

public class MongoDBTest {
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		try {
			MongoDBManager.getInstance().insert("mydb", "{\"s\":\"sdf\"}");
			System.out.println(MongoDBManager.getInstance().findAll("mydb"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
