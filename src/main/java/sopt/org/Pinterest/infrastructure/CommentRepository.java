package sopt.org.Pinterest.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.Pinterest.domain.Comment;

public interface CommentRepository extends Repository<Comment, Long> {

    //CREATE
    void save(Comment comment);
}
