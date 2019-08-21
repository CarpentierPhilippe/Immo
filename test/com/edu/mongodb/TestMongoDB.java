package com.edu.mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class TestMongoDB {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB database = mongoClient.getDB("myMongoDb");
		mongoClient.getDatabaseNames().forEach(System.out::println);
		
		database.createCollection("customers", null);
		database.getCollectionNames().forEach(System.out::println);
		
		mongoClient.close();
	}

}
