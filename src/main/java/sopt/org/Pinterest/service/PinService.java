package sopt.org.Pinterest.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.Pinterest.controller.dto.PinDto;
import sopt.org.Pinterest.controller.dto.request.PinCreateRequestDto;
import sopt.org.Pinterest.controller.dto.request.PinSaveRequestDto;
import sopt.org.Pinterest.controller.dto.response.PinDetailResponseDto;
import sopt.org.Pinterest.controller.dto.response.PinListResponseDto;
import sopt.org.Pinterest.domain.Pin;
import sopt.org.Pinterest.domain.User;
import sopt.org.Pinterest.exception.Error;
import sopt.org.Pinterest.exception.model.NotFoundException;
import sopt.org.Pinterest.infrastructure.PinRepository;
import sopt.org.Pinterest.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class PinService {

    private final PinRepository pinRepository;
    private final UserRepository userRepository;

    public PinDetailResponseDto getOnePinDetails(Long pinId) {

        Pin pin = pinRepository.findById(pinId)
            .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_PIN_EXCEPTION, Error.NOT_FOUND_PIN_EXCEPTION.getMessage()));

        return PinDetailResponseDto.of(pin);
    }

    public void createPin(final PinCreateRequestDto request) {
        User user = userRepository.findById(1L).orElseThrow(() ->
            new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION,
                Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Pin pin = Pin.newInstance(request.getTitle(), request.getContent(), "~~~", user, request.getRenderUrl(), request.getAltTxt());
        pinRepository.save(pin);
    }

    public PinListResponseDto getPinByTitle(String title) {
        List<PinDto> pins = pinRepository.findPinsByTitleContaining(title).stream().map(PinDto::of)
            .collect(Collectors.toList());

        return PinListResponseDto.of(pins);
    }

    public PinListResponseDto getAllPins() {
        List<PinDto> pins = pinRepository.findAll().stream().map(PinDto::of)
            .collect(Collectors.toList());

        return PinListResponseDto.of(pins);
    }

    @Transactional
    public void savePin(final Long pinId, final Long userId) {

        Pin pin = pinRepository.findById(pinId)
            .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_PIN_EXCEPTION,
                Error.NOT_FOUND_PIN_EXCEPTION.getMessage()));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION,
                Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        user.savePin(pin);
    }

}
