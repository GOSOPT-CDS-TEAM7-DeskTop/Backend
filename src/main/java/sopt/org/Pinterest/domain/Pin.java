package sopt.org.Pinterest.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pin extends CreatedTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; //게시글을 작성한 사용자 정보

    @Column
    private String renderUrl;

    @Column
    private String altTxt;

    @OneToMany(mappedBy = "pin")
    private List<Comment> commentList = new ArrayList<>();

    private Pin(String title, String content, String image, User user, String renderUrl, String altTxt) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.user = user;
        this.renderUrl = renderUrl;
        this.altTxt = altTxt;
    }

    public static Pin newInstance(String title, String content, String image, User user, String renderUrl, String altTxt) {
        return new Pin(title, content, image, user, renderUrl, altTxt);
    }
}
