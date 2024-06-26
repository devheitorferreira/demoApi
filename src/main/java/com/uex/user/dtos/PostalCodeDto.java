package com.uex.user.dtos;

import java.util.Objects;

//cep: "01001-000",
//logradouro: "Praça da Sé",
//complemento: "lado ímpar",
//bairro: "Sé",
//localidade: "São Paulo",
//uf: "SP",
//ibge: "3550308",
//gia: "1004",
//ddd: "11",
//siafi: "7107"
//        }


public final class PostalCodeDto {
    private final String cep;
    private final String logradouro;
    private final String complemento;
    private final String bairro;
    private final String localidade;
    private final String uf;
    private final String ibge;
    private final String gia;
    private final String ddd;
    private final String siafi;

    public PostalCodeDto(String cep, String logradouro, String numero, String complemento, String bairro, String localidade, String uf, String ibge, String gia, String ddd, String siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public String getDdd() {
        return ddd;
    }

    public String getSiafi() {
        return siafi;
    }

}



