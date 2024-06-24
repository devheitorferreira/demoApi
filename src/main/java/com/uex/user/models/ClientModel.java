package com.uex.user.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "clients")

public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    //Informa ao entity que nome da coluna sera o definido abaixo
    @Column(name = "client_id")
    private UUID clientId;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String address;
    private String addOnAddr;
    private String cep;
    private Double lat;
    private Double lon;

    //Indica que o campo Cpf nao pode ser duplicado
    @Column(unique = true)
    private String Cpf;

    public ClientModel() {
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getAddOnAddr() {
        return addOnAddr;
    }

    public void setAddOnAddr(String addOnAddr) {
        this.addOnAddr = addOnAddr;
    }
}
