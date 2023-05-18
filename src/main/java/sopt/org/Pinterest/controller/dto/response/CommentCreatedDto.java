package sopt.org.Pinterest.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentCreatedDto {

    private Long id;
    private LocalDateTime createdTime;

    public static CommentCreatedDto of(Long id, LocalDateTime createdTime) {
        return new CommentCreatedDto(id, createdTime);
    }
}
