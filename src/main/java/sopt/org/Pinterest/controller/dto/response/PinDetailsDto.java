package sopt.org.Pinterest.controller.dto.response;

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
public class PinDetailsDto {

    private PinResponseDto pin;
    private List<CommentResponseDto> comment;

    public static PinDetailsDto of(Pin pin) {

        List<Comment> comment = pin.getCommentList();
        return new PinDetailsDto(PinResponseDto.of(pin), comment.stream().map(CommentResponseDto::of).collect(Collectors.toList()));
    }

}
