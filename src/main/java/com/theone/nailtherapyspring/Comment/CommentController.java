package com.theone.nailtherapyspring.Comment;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/Comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;


    @GetMapping
    public ResponseEntity<List<Comment>> displayAllComments() {
        return ResponseEntity.ok((List<Comment>) commentRepository.findAll());
    }

    @PostMapping()
    public ResponseEntity<String> processAddCommentForm(@Valid @RequestBody Comment comment,
                                                        Errors errors, Model model) {

        if (errors.hasErrors()) {
            return new ResponseEntity<String>("Form Invalid", HttpStatus.BAD_REQUEST);
        }

        commentRepository.save(comment);
        return ResponseEntity.ok("");
    }





}