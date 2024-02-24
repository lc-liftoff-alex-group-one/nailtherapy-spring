package com.theone.nailtherapyspring.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/Comments")
public class CommentsController {

    @Autowired
    private CommentsRepository commentsRepository;




}