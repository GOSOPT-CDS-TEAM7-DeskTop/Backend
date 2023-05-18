package sopt.org.Pinterest.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.Pinterest.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    //READ
    Optional<User> findById(Long id);
}
