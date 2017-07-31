package com.bingo.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import junit.framework.TestCase;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;


public class ClientCallTest extends TestCase{
	
    public void testJsonResponse() throws IOException, URISyntaxException {  
        String url = "http://localhost:8080/clothshopserver/api/order/16777215";  
//    	String url = "http://localhost:8080/clothshopserver/api/goodsCategory/list";  
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.GET); 
        request.getHeaders().set("Accept", "application/json");  
        ClientHttpResponse response = request.execute();  
        InputStream is = response.getBody();  
        byte bytes[] = new byte[(int) response.getHeaders().getContentLength()];  
        is.read(bytes);  
  
        String jsonData = new String(bytes);  
        System.out.println(jsonData);  
    }  
    
    public void testCreateOrder() throws IOException, URISyntaxException {  
        String url = "http://localhost:8080/clothshopserver/api/order/16777215";  
//    	String url = "http://localhost:8080/clothshopserver/api/goodsCategory/list";  
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.POST); 
        request.getHeaders().set("Accept", "application/json");  
        request.getHeaders().set("Content-Type", "application/json;UTF-8"); 
        String requestJson = "{\"totalAmount\":0.00,\"address\":\"福建省厦门市瑞景商业广场\",\"mobile\":\"1885054234567\",\"consignee\":\"lxh\",\"goodsVO\":[{\"goodsId\":2,\"goodsPrice\":0.00,\"goodsNum\":1},{\"goodsId\":1,\"goodsPrice\":0.00,\"goodsNum\":2}]}";
        request.getBody().write(requestJson.getBytes());
        ClientHttpResponse response = request.execute();  
        InputStream is = response.getBody();  
        byte bytes[] = new byte[(int) response.getHeaders().getContentLength()];  
        is.read(bytes);  
        String jsonData = new String(bytes);  
        System.out.println(jsonData);  
        
    }  
}
