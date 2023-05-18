package sopt.org.Pinterest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.Pinterest.common.dto.ApiResponse;
import sopt.org.Pinterest.controller.dto.request.UserRequestDto;
import sopt.org.Pinterest.controller.dto.response.UserInfoResponseDto;
import sopt.org.Pinterest.exception.Success;
import sopt.org.Pinterest.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserInfoResponseDto> getUserInfo(@RequestBody @Valid final UserRequestDto request) {

        return ApiResponse.success(Success.FIND_USER_INFO_SUCCESS, userService.getUserInfo(request.getUserId()));
    }
}
