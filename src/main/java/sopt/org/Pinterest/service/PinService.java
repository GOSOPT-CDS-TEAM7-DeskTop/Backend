package sopt.org.Pinterest.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.Pinterest.controller.dto.response.PinDetailResponseDto;
import sopt.org.Pinterest.controller.dto.PinDto;
import sopt.org.Pinterest.controller.dto.response.PinListResponseDto;
import sopt.org.Pinterest.domain.Pin;
import sopt.org.Pinterest.exception.Error;
import sopt.org.Pinterest.exception.model.NotFoundException;
import sopt.org.Pinterest.infrastructure.PinRepository;

@Service
@RequiredArgsConstructor
public class PinService {

    private final PinRepository pinRepository;

    public PinDetailResponseDto getOnePinDetails(Long pinId) {

        Pin pin = pinRepository.findById(pinId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_PIN_EXCEPTION, Error.NOT_FOUND_PIN_EXCEPTION.getMessage()));

        return PinDetailResponseDto.of(pin);
    }

    public PinListResponseDto getAllPins() {
        List<PinDto> pins = pinRepository.findAll().stream().map(PinDto::of).collect(Collectors.toList());

        return PinListResponseDto.of(pins);
    }

}
