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
    public ApiResponse<UserInfoResponseDto> getUserInfo() {

        return ApiResponse.success(Success.FIND_USER_INFO_SUCCESS, userService.getUserInfo(1L)); //무조건 userId가 1인 유저의 마이페이지를 리턴하도록
    }
}
