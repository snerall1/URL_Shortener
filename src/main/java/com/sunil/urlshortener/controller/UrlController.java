package com.sunil.urlshortener.controller;

import com.sunil.urlshortener.controller.dto.ShortenRequest;
import com.sunil.urlshortener.model.UrlMapping;
import com.sunil.urlshortener.repository.UrlRepository;
import com.sunil.urlshortener.service.UrlService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @Autowired
    private UrlRepository urlRepository;



    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody ShortenRequest request) {
        return urlService.shortenUrl(request.getLongUrl());
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> getOriginalUrl(@PathVariable String shortCode) {
        UrlMapping urlMapping = urlRepository.findByShortCode(shortCode);
        if (urlMapping != null) {
            String longUrl = urlMapping.getLongUrl();
            System.out.println("Redirecting to: " + longUrl); // Add this line

            try {
                URI originalUrl = URI.create(longUrl);
                return ResponseEntity.status(HttpStatus.FOUND)
                        .location(originalUrl)
                        .build();
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid URL: " + longUrl);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
