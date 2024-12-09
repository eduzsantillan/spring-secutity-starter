package isi.pe.security_service.repository;

import isi.pe.security_service.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
