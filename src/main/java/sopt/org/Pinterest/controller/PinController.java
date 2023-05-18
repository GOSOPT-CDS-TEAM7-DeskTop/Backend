package sopt.org.Pinterest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.Pinterest.common.dto.ApiResponse;
import sopt.org.Pinterest.controller.dto.response.PinDetailResponseDto;
import sopt.org.Pinterest.controller.dto.response.PinListResponseDto;
import sopt.org.Pinterest.exception.Success;
import sopt.org.Pinterest.service.PinService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pin")
public class PinController {

    private final PinService pinService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PinListResponseDto> getAllPins() {
        return ApiResponse.success((Success.GET_ALL_PIN_SUCCESS), pinService.getAllPins());
    }

    @GetMapping("/{pinId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PinDetailResponseDto> getOnePinDetails(@PathVariable final Long pinId) {

        return ApiResponse.success(Success.GET_PIN_DETAILS_SUCCESS, pinService.getOnePinDetails(pinId));
    }
}
