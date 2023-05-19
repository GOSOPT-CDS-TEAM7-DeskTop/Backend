package sopt.org.Pinterest.controller.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PinCreateRequestDto {
    @NotNull
    private String title;

    @NotBlank
    private String content;

    private String renderUrl;

    private String altTxt;
}
