package com.sai.lilliputLink.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sai.lilliputLink.ui.dto.ShortenServiceResponseDTO;

@SpringBootApplication
public class LilliputLinkUiApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(LilliputLinkUiApplication.class, args);
		new Thread(LilliputLinkUiApplication::pingAllServices).start();
	}
	
	private static void pingAllServices()
	{
		System.out.println(new RestTemplate().postForObject("https://ll-api-gateway.herokuapp.com/url/ping",null,ShortenServiceResponseDTO.class).getMessage());
		System.out.println(new RestTemplate().postForObject("https://ll-api-gateway.herokuapp.com/ping",null,ShortenServiceResponseDTO.class).getMessage());
	}

	@Bean
	public RestTemplate getRestTemplate()
	{
	    return new RestTemplate();
	}
}
