package com.sai.lilliputLink.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LilliputLinkUiApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(LilliputLinkUiApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	    requestFactory.setConnectTimeout(180000);
	    requestFactory.setReadTimeout(180000);

	    return new RestTemplate(requestFactory);
	}
}
