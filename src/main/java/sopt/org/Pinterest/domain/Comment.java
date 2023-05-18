package sopt.org.Pinterest.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends CreatedTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "pin_id")
    private Pin pin;

    @Column(nullable = false, name = "`like`")
    @ColumnDefault("0")
    private Integer like;

    @Column(nullable = false)
    private String content;

    private Comment(User user, Pin pin, String content) {
        this.user = user;
        this.pin = pin;
        this.content = content;

        this.like = 0;
    }

    public static Comment newInstance(User user, Pin pin, String content) {
        return new Comment(user, pin, content);
    }
}