package com.apicloud;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apicloud.filters.pre.PreFilter;

@SpringBootApplication
@EnableZuulProxy
@RestController
@EnableDiscoveryClient
public class ApiGatewayApplication<ProducerResponse> {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		
	}
	

 
    
	 @Bean
	     public PreFilter preFilter() {
	        return new PreFilter();
	    }

	 
//	 @Bean
//	    public ZuulFallbackProvider zuulFallbackProvider() {
//	        return new ZuulFallbackProvider() {
//	            @Override
//	            public String getRoute() {
//	                return "greeting";
//	            }
//
//	            @Override
//	            public ClientHttpResponse fallbackResponse() {
//	                return new ClientHttpResponse() {
//	                    @Override
//	                    public HttpStatus getStatusCode() throws IOException {
//	                        return HttpStatus.INTERNAL_SERVER_ERROR;
//	                    }
//
//	                    @Override
//	                    public int getRawStatusCode() throws IOException {
//	                        return 500;
//	                    }
//
//	                    @Override
//	                    public String getStatusText() throws IOException {
//	                        return "Internal Server Error";
//	                    }
//
//	                    @Override
//	                    public void close() {
//
//	                    }
//
//	                    @Override
//	                    public InputStream getBody() throws IOException {
//	                        return new ByteArrayInputStream("fallback".getBytes());
//	                    }
////	                    public InputStream getBody() throws IOException { 
////	                    	
//////	                    	URI uri = URI.create("http://localhost:10090/recommended");
////	                    	
////	                        return new URL("http://localhost:10090/recommended").openStream();
////	                  }
//	                    
//
//	                    @Override
//	                    public HttpHeaders getHeaders() {
//	                        HttpHeaders headers = new HttpHeaders();
//	                        headers.setContentType(MediaType.APPLICATION_JSON);
//	                        return headers;
//	                    }
//	                };
//	            }
//	        };
//	    }
}
