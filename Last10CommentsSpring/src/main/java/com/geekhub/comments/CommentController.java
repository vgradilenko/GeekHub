package com.geekhub.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private static final int TOP_COMMENTS_NUMBER = 10;

    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping
    public void save(Comment comment) {
        comment.setDate(LocalDateTime.now());
        commentRepository.save(comment);
    }

    @GetMapping
    public List<Comment> getTopComments() {
        return commentRepository.find(TOP_COMMENTS_NUMBER);
    }
}
