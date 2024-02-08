package ua.example.springboot.service;

import ua.example.springboot.model.UrlShortener;

import java.util.List;

public interface UrlShortenerService {
    List<UrlShortener> findAllUrlShortener();

    UrlShortener saveUrlShortener(UrlShortener urlShortener);

    String findByUrlShortener(String tiny);

    void deleteUrlShortener(String url);
}
