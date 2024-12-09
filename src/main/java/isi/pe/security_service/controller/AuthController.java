package isi.pe.security_service.controller;

import isi.pe.security_service.entity.UserEntity;
import isi.pe.security_service.model.AuthRequest;
import isi.pe.security_service.model.SignUpRequest;
import isi.pe.security_service.service.JwtService;
import isi.pe.security_service.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthController (JwtService jwtService, AuthenticationManager authenticationManager, UserService userService){
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }


    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtService.generateTokenFromUser(userDetails);
    }

    @PostMapping("/signup")
    public Map<String, Object> signUp(@RequestBody SignUpRequest request){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userEntity.setRole(request.getRole());
        userEntity.setName(request.getName());
        userService.save(userEntity);
        return Map.of("message", "User registered successfully");
    }
}
