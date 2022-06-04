package com.example.fisherbooker.service.impl;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import com.example.fisherbooker.repository.SecureTokenRepository;
import com.example.fisherbooker.security.auth.SecureToken;
import com.example.fisherbooker.service.SecureTokenService;

@Service
public class DefaultSecureTokenService implements SecureTokenService {

    private static final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom(15);
    private static final Charset US_ASCII = Charset.forName("US-ASCII");

    @Value("${jdj.secure.token.validity}")
    private int tokenValidityInSeconds;

    @Autowired
    SecureTokenRepository secureTokenRepository;

    @Override
    public SecureToken createSecureToken(){
        String tokenValue = new String(Base64.encodeBase64URLSafe(DEFAULT_TOKEN_GENERATOR.generateKey()), US_ASCII);
        SecureToken secureToken = new SecureToken();
        secureToken.setToken(tokenValue);
        secureToken.setExpireAt(LocalDateTime.now().plusSeconds(getTokenValidityInSeconds()));
        this.saveSecureToken(secureToken);
        return secureToken;
    }

    @Override
    public void saveSecureToken(SecureToken token) {
        secureTokenRepository.save(token);
    }

    @Override
    public SecureToken findByToken(String token) {
    	List<SecureToken> secureTokens = secureTokenRepository.findAll();
    	for(SecureToken t : secureTokens) {
    		System.out.println(t.getToken() + " " + token);
    		System.out.println(token);
    		System.out.println(t.getToken() instanceof String);
    		System.out.println(token instanceof String);
    		System.out.println(t.getToken().equals(token));
    	}
    	//System.out.println(secureTokens[0].token.equals(token));
    	return secureTokenRepository.findByToken(token);
    
    }

    @Override
    public void removeToken(SecureToken token) {
        secureTokenRepository.delete(token);
    }

    @Override
    public void removeTokenByToken(String token) {
        secureTokenRepository.removeByToken(token);
    }

    public int getTokenValidityInSeconds() {
        return tokenValidityInSeconds;
    }
}
