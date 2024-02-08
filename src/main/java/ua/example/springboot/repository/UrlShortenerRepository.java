package ua.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.example.springboot.model.UrlShortener;

public interface UrlShortenerRepository extends JpaRepository<UrlShortener, Long> {
    UrlShortener findUrlshortenerByLongUrl(String longUrl);

    UrlShortener findUrlShortenerByTinyUrl(String tinyUrl);

    @Query("select increment_counter()")
    String getCounter();

    void deleteByLongUrl(String url);
}
