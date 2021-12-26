package com.sai.lilliputLink.ui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sai.lilliputLink.ui.dto.ShortenServiceRequestDTO;
import com.sai.lilliputLink.ui.dto.ShortenServiceResponseDTO;
import com.sai.lilliputLink.ui.service.UIService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class UIServiceImpl implements UIService
{
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	@CircuitBreaker(name = "shorteningService", fallbackMethod = "handleDownTime")
	public String getShortURL(String LongURL)
	{
		ShortenServiceRequestDTO requestDTO = new ShortenServiceRequestDTO(LongURL);
		
		return restTemplate.postForObject("https://ll-api-gateway.herokuapp.com/url/shorten",requestDTO,ShortenServiceResponseDTO.class).getShortURL();
	}
	
	public String handleDownTime(String LongURL,Exception e)
	{
		System.out.println("Handling downtime..");
		return "Services.. starting up please try again..";
	}
}