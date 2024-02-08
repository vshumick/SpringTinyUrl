package ua.example.springboot.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.example.springboot.model.UrlShortener;
import ua.example.springboot.repository.UrlShortenerRepository;
import ua.example.springboot.service.UrlShortenerService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
/*@Primary*/
public class UrlShortenerServiceImpl implements UrlShortenerService {
    private final UrlShortenerRepository repository;

    @Override
    public List<UrlShortener> findAllUrlShortener() {
        return repository.findAll();
    }

    @Override
    public UrlShortener saveUrlShortener(UrlShortener tinyurl) {
        UrlShortener existingTinyurl = repository.findUrlshortenerByLongUrl(tinyurl.getLongUrl());
        if (existingTinyurl != null) {
            return existingTinyurl;
        }
        String str = Arrays.stream(repository.getCounter().split("\\."))
                .map(Integer::parseInt)
                //.map(x -> String.valueOf((char) (x >= 27 ? x + 70 : x + 64)))
                .map(x -> String.valueOf((char) (x >= 27 ? x + 38 : x + 96)))//в начале используем маленькие, потом большие буквы
                .collect(Collectors.joining());
        tinyurl.setTinyUrl(str);
        return repository.save(tinyurl);
    }

    @Override
    public String findByUrlShortener(String tinyUrl) {
        UrlShortener tinyurl = repository.findUrlShortenerByTinyUrl(tinyUrl);
        return tinyurl == null ? "" : tinyurl.getLongUrl();
    }

    @Override
    @Transactional
    public void deleteUrlShortener(String url) {
        repository.deleteByLongUrl(url);
    }

}
