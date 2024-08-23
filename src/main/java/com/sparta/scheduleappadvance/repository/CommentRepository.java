package com.sparta.scheduleappadvance.repository;

import com.sparta.scheduleappadvance.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
