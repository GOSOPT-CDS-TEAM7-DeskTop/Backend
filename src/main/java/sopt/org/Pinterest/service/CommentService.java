package sopt.org.Pinterest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.Pinterest.controller.dto.request.CommentRequestDto;
import sopt.org.Pinterest.controller.dto.response.CommentCreatedDto;
import sopt.org.Pinterest.domain.Comment;
import sopt.org.Pinterest.domain.Pin;
import sopt.org.Pinterest.domain.User;
import sopt.org.Pinterest.exception.Error;
import sopt.org.Pinterest.exception.model.NotFoundException;
import sopt.org.Pinterest.infrastructure.CommentRepository;
import sopt.org.Pinterest.infrastructure.PinRepository;
import sopt.org.Pinterest.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PinRepository pinRepository;

    @Transactional
    public CommentCreatedDto createComment(CommentRequestDto request, Long pinId) {

        Pin pin = pinRepository.findById(pinId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_PIN_EXCEPTION, Error.NOT_FOUND_PIN_EXCEPTION.getMessage()));

        User writer = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Comment newComment = Comment.newInstance(writer, pin, request.getContent());
        commentRepository.save(newComment);

        //Pin의 commentList에도 생성된 Comment를 추가
        pin.addComment(newComment);

        return CommentCreatedDto.of(newComment.getId(), newComment.getCreatedTime());
    }

}
