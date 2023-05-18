package sopt.org.Pinterest.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String account;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer follower;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer following;

    @Column
    private String image;

    @ManyToMany
    @JoinTable(name = "scrap",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "pin_id")
    )
    private List<Pin> savedPinList = new ArrayList<>();

    public void addFollower() {
        this.follower += 1;
    }

    public void addFollowing() {
        this.following += 1;
    }

    private User(String account, String nickname, String image) {
        this.account = account;
        this.nickname = nickname;
        this.image = image;

        this.follower = 0;
        this.following = 0;
    }

    public static User newInstance(String account, String nickname, String image) {
        return new User(account, nickname, image);
    }
}