package sopt.org.Pinterest.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.Pinterest.domain.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfoResponseDto {

    private Long userId;
    private String userImage;
    private String nickname;
    private String account;
    private Integer following;

    public static UserInfoResponseDto of(User user) {

        return new UserInfoResponseDto(user.getId(), user.getImage(), user.getNickname(), user.getAccount(), user.getFollowing());
    }
}