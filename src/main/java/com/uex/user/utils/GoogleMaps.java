package com.uex.user.utils;

import com.uex.user.dtos.GoogleMapsDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("consulta-mapa")
public class GoogleMaps {

    private final RestTemplateBuilder restTemplateBuilder;

    public GoogleMaps(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @GetMapping("{cep}")
    public GoogleMapsDto gmaps(@PathVariable String cep) {
        RestTemplate rt = new RestTemplate();
        String json = rt
                .getForObject("https://maps.googleapis.com/maps/api/geocode/json?address=80050510&key=....Pkdo", String.class);

       System.out.println(json);

        // HttpEntity<GoogleMapsDto> response = rt
        //         .getForEntity("https://maps.googleapis.com/maps/api/geocode/json?address=80050510&key=", GoogleMapsDto.class);

        //return response.getBody();

        return null;
    }
}
