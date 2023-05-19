package sopt.org.Pinterest.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import sopt.org.Pinterest.exception.Error;
import sopt.org.Pinterest.exception.model.ConflictException;

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

    public void savePin(Pin pin) {
        if(this.savedPinList.contains(pin))  {
            throw new ConflictException(Error.ALREAD_SAVED_PIN, Error.ALREAD_SAVED_PIN.getMessage());
        }
        this.savedPinList.add(pin);
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