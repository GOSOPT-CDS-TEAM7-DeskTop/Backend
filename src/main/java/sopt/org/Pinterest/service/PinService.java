package sopt.org.Pinterest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.Pinterest.controller.dto.PinDetailsDto;
import sopt.org.Pinterest.domain.Pin;
import sopt.org.Pinterest.exception.Error;
import sopt.org.Pinterest.exception.model.NotFoundException;
import sopt.org.Pinterest.infrastructure.PinRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PinService {

    private final PinRepository pinRepository;

    public PinDetailsDto getOnePinDetails(Long pinId) {
        Pin findPin = pinRepository.findById(pinId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_PIN_EXCEPTION, Error.NOT_FOUND_PIN_EXCEPTION.getMessage()));

        return PinDetailsDto.of(findPin);
    }

}
