package sopt.org.Pinterest.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.Pinterest.domain.Pin;

import java.util.Optional;

public interface PinRepository extends Repository<Pin, Long> {

    //READ
    Optional<Pin> findById(Long id);
}
