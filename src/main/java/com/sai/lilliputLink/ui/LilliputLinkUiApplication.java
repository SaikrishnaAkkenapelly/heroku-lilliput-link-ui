package com.sai.lilliputLink.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sai.lilliputLink.ui.dto.ShortenServiceRequestDTO;
import com.sai.lilliputLink.ui.dto.ShortenServiceResponseDTO;

@SpringBootApplication
public class LilliputLinkUiApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(LilliputLinkUiApplication.class, args);
		wakeUpShorteningService();
		wakeUpRedirectService();
	}
	
	//code to wake shortening service on heroku
	private static void wakeUpShorteningService()
	{
		try
		{
			new RestTemplate().postForObject("https://ll-api-gateway.herokuapp.com/url/ping",new ShortenServiceRequestDTO(),ShortenServiceResponseDTO.class);
		}
		catch(Throwable throwable)
		{
			System.out.println("ERROR while pinging shortening service.."+throwable.getMessage());
		}
	}
	
	//code to wake shortening service on heroku
	private static void wakeUpRedirectService()
	{
		try
		{
			new RestTemplate().postForObject("https://ll-api-gateway.herokuapp.com/ping",new ShortenServiceRequestDTO(),ShortenServiceResponseDTO.class);
		}
		catch(Throwable throwable)
		{
			System.out.println("ERROR while pinging redirect service.."+throwable.getMessage());
		}
	}

	@Bean
	public RestTemplate getRestTemplate()
	{
	    return new RestTemplate();
	}
}
