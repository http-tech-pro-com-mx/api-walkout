package com.tech.pro.walker.api.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.tech.pro.walker.api.models.entity.Walker;
import com.tech.pro.walker.api.services.IWalkerServiceImp;

@Component
public class infoAdicinalToken  implements TokenEnhancer{
	
	@Autowired
	private IWalkerServiceImp iWalkerServiceImp;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Optional<Walker> usuario = iWalkerServiceImp.findById(1L);
		
		Map<String, Object> additionalInfo = new HashMap<>();
		
		//additionalInfo.put("email", datos_personales.getCorreo_electronico());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		return accessToken;
	}

}
