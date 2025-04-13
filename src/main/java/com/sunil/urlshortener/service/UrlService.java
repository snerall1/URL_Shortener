package com.sunil.urlshortener.service;

import com.sunil.urlshortener.model.UrlMapping;
import com.sunil.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String shortenUrl(String longUrl) {
        String shortCode = UUID.randomUUID().toString().substring(0, 6);

        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setLongUrl(longUrl);
        urlMapping.setShortCode(shortCode);

        urlRepository.save(urlMapping);

        return "http://localhost:8080/api/" + shortCode;
    }

    public String getOriginalUrl(String shortCode) {
        UrlMapping urlMapping = urlRepository.findByShortCode(shortCode);
        if (urlMapping != null) {
            return urlMapping.getLongUrl();
        } else {
            return "URL not found!";
        }
    }
}
