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
    FIND_PIN_DETAILS_SUCCESS(HttpStatus.OK, "게시글 상세정보 조회가 완료됐습니다"),
    GET_ALL_PIN_SUCCESS(HttpStatus.OK, "핀 전체 조회 성공"),

    /**
     * 201 CREATED
     */
    CREATE_COMMENT_SUCCESS(HttpStatus.CREATED, "댓글 작성이 완료되었습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
    }
