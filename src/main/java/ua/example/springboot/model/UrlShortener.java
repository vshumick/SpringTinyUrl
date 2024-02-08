package ua.example.springboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "url_shortener")
public class UrlShortener {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String longUrl;
    @Column(unique = true)
    private String tinyUrl;
}
