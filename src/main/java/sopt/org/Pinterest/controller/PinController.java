package sopt.org.Pinterest.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.Pinterest.common.dto.ApiResponse;
import sopt.org.Pinterest.controller.dto.request.PinCreateRequestDto;
import sopt.org.Pinterest.controller.dto.request.PinSaveRequestDto;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse createPin(@RequestBody @Valid final PinCreateRequestDto request) {
        pinService.createPin(request);

        return ApiResponse.success((Success.CREATE_PIN_SUCCESS));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PinListResponseDto> getOnePinDetails(@RequestParam final String title) {

        return ApiResponse.success(Success.GET_PIN_BY_TITLE_SUCCESS, pinService.getPinByTitle(title));
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse savePin(@RequestBody @Valid final PinSaveRequestDto request) {

        pinService.savePin(request.getPinId(), 1L);
        return ApiResponse.success(Success.POST_PIN_SAVE_SUCCESS);
    }

    @GetMapping("/{pinId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PinDetailResponseDto> getOnePinDetails(@PathVariable final Long pinId) {

        return ApiResponse.success(Success.GET_PIN_DETAILS_SUCCESS, pinService.getOnePinDetails(pinId));
    }
}
