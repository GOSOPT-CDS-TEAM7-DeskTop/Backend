package sopt.org.Pinterest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.Pinterest.common.dto.ApiResponse;
import sopt.org.Pinterest.controller.dto.response.SavedPinResponseDto;
import sopt.org.Pinterest.controller.dto.request.UserRequestDto;
import sopt.org.Pinterest.controller.dto.response.UserInfoResponseDto;
import sopt.org.Pinterest.exception.Success;
import sopt.org.Pinterest.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserInfoResponseDto> getUserInfo() {

        return ApiResponse.success(Success.FIND_USER_INFO_SUCCESS, userService.getUserInfo(1L));
    }

    @GetMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<SavedPinResponseDto>> getSavedPinList() {

        return ApiResponse.success(Success.FIND_SAVED_PIN_SUCCESS, userService.getSavedPinList(1L));
    }
}
