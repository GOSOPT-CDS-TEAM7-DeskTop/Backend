package sopt.org.Pinterest.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.Pinterest.domain.Comment;
import sopt.org.Pinterest.domain.Pin;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PinDetailResponseDto {

    private PinDto pin;
    private List<CommentDto> comment;

    public static PinDetailResponseDto of(Pin pin) {

        List<Comment> comment = pin.getCommentList();
        return new PinDetailResponseDto(
            PinDto.of(pin), comment.stream().map(CommentDto::of).collect(Collectors.toList()));
    }

}
