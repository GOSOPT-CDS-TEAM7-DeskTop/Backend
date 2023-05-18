package sopt.org.Pinterest.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.Pinterest.domain.Comment;
import sopt.org.Pinterest.domain.User;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentDto {

    private Long id;
    private String content;
    private Integer like;
    private LocalDateTime createdTime;

    //작성자 관련 정보
    private String writerNickname;
    private String writerImage;
    //

    public static CommentDto of(Comment comment) {

        User commentWriter = comment.getUser();
        return new CommentDto(comment.getId(), comment.getContent(), comment.getLike(),
                comment.getCreatedTime(), commentWriter.getNickname(), commentWriter.getImage());
    }
}
