package sopt.org.Pinterest.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.Pinterest.domain.Pin;
import sopt.org.Pinterest.domain.User;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PinDto {

    private Long id;
    private String title;
    private String content;
    private String image;

    //작성자 관련 정보
    private String writerNickname;
    private Integer writerFollower;
    private String writerImage;

    private LocalDateTime createdTime;
    private String renderUrl;
    private String altTxt;

    public static PinDto of(Pin pin) {

        User pinWriter = pin.getUser();
        return new PinDto(pin.getId(), pin.getTitle(), pin.getContent(), pin.getImage(),
            pinWriter.getNickname(), pinWriter.getFollower(), pinWriter.getImage(),
            pin.getCreatedTime(), pin.getRenderUrl(), pin.getAltTxt());
    }
}
