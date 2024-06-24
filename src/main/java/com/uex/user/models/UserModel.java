package com.uex.user.models;


import com.uex.user.dtos.LoginRecordRequestDto;
import jakarta.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

//instrucao para criacao do nome tabela
@Entity
@Table(name = "users")

public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    //Informa ao entity que nome da coluna sera o definido abaixo
    @Column(name = "user_id")
    private UUID userId;
    private String username;
    private String password;

    //Criando o relacionamento entre as tabela de users e clients
    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "client_id")
    private ClientModel clientModel;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public ClientModel getClient() {
        return clientModel;
    }

    public void setClient(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(LoginRecordRequestDto loginRecordRequestDto, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRecordRequestDto.password(), this.password);
    }


}
