package sopt.org.Pinterest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.Pinterest.common.dto.ApiResponse;
import sopt.org.Pinterest.controller.dto.PinDetailsDto;
import sopt.org.Pinterest.exception.Success;
import sopt.org.Pinterest.service.PinService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pin")
public class PinController {

    private final PinService pinService;

    @GetMapping("/{pinId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PinDetailsDto> getOnePinDetails(@PathVariable final Long pinId) {

        return ApiResponse.success(Success.FIND_PIN_DETAILS_SUCCESS, pinService.getOnePinDetails(pinId));
    }
}
