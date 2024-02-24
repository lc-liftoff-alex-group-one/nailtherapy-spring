package com.theone.nailtherapyspring.comments;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        Comment newComment = commentRepository.save(comment);
        return ResponseEntity.ok(newComment);
    }

    public ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok((List<Comment>) commentRepository.findAll());
    }

    public ResponseEntity<Optional<Comment>> getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteComment(Long id) {
        commentRepository.deleteById(id);
        return ResponseEntity.ok("Comment deleted");
    }
}
