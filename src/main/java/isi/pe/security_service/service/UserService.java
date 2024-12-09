package isi.pe.security_service.service;

import isi.pe.security_service.entity.UserEntity;
import isi.pe.security_service.model.User;
import isi.pe.security_service.repository.UserEntityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userEntityRepository.findByUsername(username);
        if(userEntity == null){
            throw new UsernameNotFoundException(String.format("Usuario con username %s no encontrado", username));
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getRole());
    }

    public UserEntity save(UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRole("ROLE_"+userEntity.getRole().toUpperCase());
        return userEntityRepository.save(userEntity);
    }
}
