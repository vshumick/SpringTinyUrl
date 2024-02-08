package ua.example.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.example.springboot.model.UrlShortener;
import ua.example.springboot.service.UrlShortenerService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/urlshortener")
@AllArgsConstructor
public class UrlshortenerController {
    private final UrlShortenerService service;

    @GetMapping
    public List<UrlShortener> findAllUrlShortener() {
        return service.findAllUrlShortener();
    }

   @PostMapping
    public UrlShortener generateTiny(@RequestBody UrlShortener urlShortener) {
       UrlShortener u = service.saveUrlShortener(urlShortener);
       return u;
    }

    @GetMapping("/{tinyUrl}")
    public String findLongUrlByTinyUrl(@PathVariable String tinyUrl) {
        return service.findByUrlShortener(tinyUrl);
    }


    @DeleteMapping("/{longUrl}")
    public void deleteUrlShortener(@PathVariable String longUrl) {
        service.deleteUrlShortener(longUrl);
    }
}
