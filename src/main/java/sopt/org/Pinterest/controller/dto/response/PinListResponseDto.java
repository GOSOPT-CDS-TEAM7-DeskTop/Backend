package sopt.org.Pinterest.controller.dto.response;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.Pinterest.controller.dto.PinDto;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PinListResponseDto {

    private List<PinDto> pins;

    public static PinListResponseDto of(List<PinDto> pins) {
        return new PinListResponseDto(pins);
    }

}
