package com.edu.realestate.dao;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class EsClientProvider {

	private RestHighLevelClient client;
	
	//TEMP
	public EsClientProvider(){
		this.init();
	}
	
	public void init() {
		client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
	}
	
	public void destroy() throws IOException {
		if (client != null)
			client.close();
	}
	
	public RestHighLevelClient getClient() {
		return client;
	}
}
