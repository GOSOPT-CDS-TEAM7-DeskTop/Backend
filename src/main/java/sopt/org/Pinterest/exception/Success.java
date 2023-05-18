package sopt.org.Pinterest.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Success {

    /**
     * 200 OK
     */
    GET_PIN_DETAILS_SUCCESS(HttpStatus.OK, "게시글 상세정보 조회가 완료됐습니다"),
    GET_USER_INFO_SUCCESS(HttpStatus.OK, "마이페이지 유저정보 조회가 완료되었습니다"),
    GET_SAVED_PIN_SUCCESS(HttpStatus.OK, "마이페이지 정리되지 않은 아이디어 조회가 완료되었습니다"),

    /**
     * 201 CREATED
     */
    CREATE_COMMENT_SUCCESS(HttpStatus.CREATED, "댓글 작성이 완료되었습니다"),
    FOLLOW_USER_SUCCESS(HttpStatus.CREATED, "팔로우가 완료되었습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
    }
