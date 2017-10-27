package com.karson.webmagic.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
	@Autowired
	private TokenStore tokenStore;
	@RequestMapping(method = RequestMethod.GET, value = "/tokens")
	public List<String> getTokens() {
	    List<String> tokenValues = new ArrayList<String>();
	    Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId("client_1"); 
	    if (tokens!=null){
	        for (OAuth2AccessToken token:tokens){
	            tokenValues.add(token.getValue());
	        }
	    }
	    return tokenValues;
}
}