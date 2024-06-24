package com.uex.user.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

    //Usando a anotacao do "Validation" validacao dos campoos e o dto + records para transferencia de dados entre as camadas
    public record UserRecordDto(@NotBlank @NotNull String username, @NotBlank @NotNull String password ) {}
