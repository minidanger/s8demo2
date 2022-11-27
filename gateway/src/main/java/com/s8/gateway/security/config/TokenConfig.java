package com.s8.gateway.security.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@Configuration
public class TokenConfig {

    /**
     * 秘钥串
     */
    private static final String SIGNING_KEY = "brooketest";


    @Bean
    @Qualifier("tokenStore")
    public TokenStore tokenStore() throws IOException{
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() throws IOException {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        //converter.setVerifier(new MacSigner(SIGNING_KEY));
        //converter.setVerifier(new RsaVerifier(SIGNING_KEY));

//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        Resource resource = new ClassPathResource(SIGNING_KEY);
//        String publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
//        converter.setVerifier(new RsaVerifier(publicKey));
        return converter;
    }


}