package sopt.org.Pinterest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.Pinterest.common.dto.ApiResponse;
import sopt.org.Pinterest.controller.dto.response.CommentCreatedDto;
import sopt.org.Pinterest.controller.dto.request.CommentRequestDto;
import sopt.org.Pinterest.exception.Success;
import sopt.org.Pinterest.service.CommentService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{pinId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CommentCreatedDto> createComment(@RequestBody @Valid final CommentRequestDto request,
                                                        @PathVariable final Long pinId) {
        
        return ApiResponse.success(Success.CREATE_COMMENT_SUCCESS, commentService.createComment(request, pinId));
    }
}
