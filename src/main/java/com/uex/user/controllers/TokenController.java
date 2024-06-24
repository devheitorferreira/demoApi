package com.uex.user.controllers;

import com.uex.user.dtos.LoginRecordRequestDto;
import com.uex.user.dtos.LoginRecordResponseDto;
import com.uex.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;

@RestController
public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //Quando a aplicacao sera setado o valor vindo da app proprieties na variavel
    @Value("${jwt.durationToken}")
    private Long tokenExpiration;


    public TokenController(JwtEncoder jwtEncoder,
                           UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //Mapeando a rota do Login
    @PostMapping("/login")

    public ResponseEntity<LoginRecordResponseDto> login (@RequestBody LoginRecordRequestDto loginRecordRequestDto) {
        var user = userRepository.findByUsername(loginRecordRequestDto.username());

        //Verificando se usuario existe no banco e a senha na requisicao bate com a salva no banco

        if (user.isEmpty() || !user.get().checkPassword(loginRecordRequestDto, bCryptPasswordEncoder) ) {
            throw new BadCredentialsException("Usuário ou senha inválidos");
        }

        //Fornece a hora corrent
        var now = Instant.now();

        //Criando os Claims do Jwt
        var claims = JwtClaimsSet.builder()
                .issuer("uex.io.user")
                .issuedAt(Instant.now())
                .subject("Api de Usuários")
                .expiresAt(now.plusSeconds(tokenExpiration))
                .build();

        var jwtToken = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginRecordResponseDto(jwtToken, tokenExpiration));
    }
}
