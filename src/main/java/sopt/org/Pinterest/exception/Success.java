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
    GET_PIN_DETAILS_SUCCESS(HttpStatus.OK, "게시글 상세정보 조회 성공"),
    GET_ALL_PIN_SUCCESS(HttpStatus.OK, "핀 전체 조회 성공"),
    GET_PIN_BY_TITLE_SUCCESS(HttpStatus.OK, "제목 기반 핀 검색 성공"),
    GET_USER_INFO_SUCCESS(HttpStatus.OK, "유저 정보 조회 성공"),
    GET_SAVED_PIN_SUCCESS(HttpStatus.OK, "정리되지 않은 아이디어 조회 성공"),
    /**
     * 201 CREATED
     */
    CREATE_COMMENT_SUCCESS(HttpStatus.CREATED, "댓글 작성 완료"),
    FOLLOW_USER_SUCCESS(HttpStatus.CREATED, "팔로우 완료"),
    POST_PIN_SAVE_SUCCESS(HttpStatus.CREATED, "핀 저장 성공"),
    CREATE_PIN_SUCCESS(HttpStatus.CREATED, "핀 생성 성공")
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
