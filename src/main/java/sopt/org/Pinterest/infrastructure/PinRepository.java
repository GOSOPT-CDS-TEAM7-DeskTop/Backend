package sopt.org.Pinterest.infrastructure;

import java.util.List;
import org.springframework.data.repository.Repository;
import sopt.org.Pinterest.domain.Pin;

import java.util.Optional;

public interface PinRepository extends Repository<Pin, Long> {

    //READ
    Optional<Pin> findById(Long id);

    List<Pin> findAll();

    List<Pin> findPinsByTitleContaining(String title);
}
