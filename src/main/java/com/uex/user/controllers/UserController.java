package com.uex.user.controllers;


import com.uex.user.config.SecurityConfig;
import com.uex.user.dtos.UserRecordDto;
import com.uex.user.models.UserModel;
import com.uex.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCrypt;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCrypt) {
        this.userRepository = userRepository;
        this.bCrypt = bCrypt;
    }

    //End-point para criacao de usuario
    @Transactional
    @PostMapping("/user")
    public ResponseEntity<UserModel> addUser(@RequestBody @Valid UserRecordDto userRecordDto) {

        var user = userRepository.findByUsername(userRecordDto.username());
        if(user.isPresent()){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
            var newUser = new UserModel();
                newUser.setUsername(userRecordDto.username());
                newUser.setPassword(bCrypt.encode(userRecordDto.password()));
            //Salvando no banco de dados o novo usuario
                userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(newUser));
    }

   //Listagem dos usuarios
//    @GetMapping("/users")
//    public ResponseEntity<UserRecordDto[]> getUsers() {
//        var users = userRepository.findAll();
//
//        return null;
//    }


   //End-Point para excluir a propria conta
//   @Transactional
//   @DeleteMapping("/user/delete")
//   public ResponseEntity<UserModel>selfDeleteAccount(@RequestHeader("Authorization") String jwt){
//        var loggedToken = jwt;
//
//       return null;
//   }
}
