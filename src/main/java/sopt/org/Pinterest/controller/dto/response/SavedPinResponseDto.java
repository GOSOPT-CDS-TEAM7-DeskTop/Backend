package sopt.org.Pinterest.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.Pinterest.domain.Pin;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SavedPinResponseDto {

    private Long pinId;
    private String pinImage;

    public static SavedPinResponseDto of(Pin pin) {

        return new SavedPinResponseDto(pin.getId(), pin.getImage());
    }
}
