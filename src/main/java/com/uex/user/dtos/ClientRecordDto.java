package com.uex.user.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ClientRecordDto(@NotBlank String name, @NotBlank String email, @NotBlank String phone, @NotBlank String address,
                              String addOnAddr, @NotBlank String cep, @NotNull Double lat,
                              @NotNull Double lon, @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}") String Cpf) {
}
