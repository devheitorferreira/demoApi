package com.uex.user.utils;

import com.uex.user.dtos.LoginRecordResponseDto;
import com.uex.user.dtos.PostalCodeDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-cep")
public class PostalCode {

    private final RestTemplateBuilder restTemplateBuilder;

    public PostalCode(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @GetMapping("{cep}")
    public PostalCodeDto postalCode(@PathVariable String cep) {
        RestTemplate restTemplate = new RestTemplate();
        //Faz a requisicao para api e mapeia o retorno para o dto
        ResponseEntity<PostalCodeDto> result = restTemplate
                .getForEntity(String.format("https://viacep.com.br/ws/%s/json", cep) , PostalCodeDto.class);
        return result.getBody();
    }
}
