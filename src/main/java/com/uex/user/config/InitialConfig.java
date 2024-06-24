package com.uex.user.config;

import com.uex.user.models.UserModel;
import com.uex.user.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.awt.*;

@Configuration
public class InitialConfig implements CommandLineRunner{

    public UserRepository userRepository;
    private BCryptPasswordEncoder bCrypt;

    public InitialConfig(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCrypt = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Vamos criar o usuario a primeira vez que o app rodar

        var demoUser = userRepository.findByUsername("demo");

        demoUser.ifPresentOrElse(
                user -> {
                        System.err.println("Usuario demo ja existe!, Utilize \n" + "username: demo \n" + "password: uex@2024");
                    },
                () -> {
                    var demo = new UserModel();
                        demo.setUsername("demo");
                        demo.setPassword(bCrypt.encode("uex@2024"));
                        userRepository.save(demo);
                }


        );
    }
}
