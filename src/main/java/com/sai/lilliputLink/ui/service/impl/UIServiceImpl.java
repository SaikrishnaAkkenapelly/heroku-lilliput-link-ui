package com.sai.lilliputLink.ui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sai.lilliputLink.ui.dto.ShortenServiceRequestDTO;
import com.sai.lilliputLink.ui.dto.ShortenServiceResponseDTO;
import com.sai.lilliputLink.ui.service.UIService;

@Component
public class UIServiceImpl implements UIService
{
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public String getShortURL(String LongURL)
	{
		ShortenServiceRequestDTO requestDTO = new ShortenServiceRequestDTO(LongURL);
		
		return restTemplate.postForObject("https://ll-shortening-service.herokuapp.com/url/shorten",requestDTO,ShortenServiceResponseDTO.class).getShortURL();
	}
}