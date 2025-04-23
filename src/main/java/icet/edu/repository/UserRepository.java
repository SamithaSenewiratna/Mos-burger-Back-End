package icet.edu.repository;

import icet.edu.dto.User;
import icet.edu.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByEmail(String email);
    UserEntity findByEmailAndPassword(String email, String password);
}
