package com.servercode.controllers;

import com.servercode.model.Questions;
import com.servercode.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/submit")
public class NewQuestionController {
    @Autowired
    QuestionRepository QuestionRepository;

    @RequestMapping("/")
    @ResponseBody
    public List<Questions> getAll() {
        List<Questions> question = QuestionRepository.findAll();
        Collections.sort(question);
        return question;
    }

    @PostMapping("/")
//    @ResponseBody
//    public Questions create(
    public String create(
         @RequestParam String question
    ) {
        Questions wut = new Questions(question);
        wut = QuestionRepository.save(wut);
//        return wut;
        return "redirect:/";
    }

    @GetMapping("/{id}/upvote")
    public String upvote(
            @PathVariable("id") long id
    ) {
        Optional optional = QuestionRepository.findById(id);
        Questions wut = (Questions) optional.get();
        if (wut != null) {
            wut.votes++;
            QuestionRepository.save(wut);
        }
        return "redirect:/";
    }

    @GetMapping("/{id}/downvote")
    public String downvote(
            @PathVariable("id") long id
    ) {
        Optional optional = QuestionRepository.findById(id);
        Questions wut = (Questions) optional.get();
        if (wut != null) {
            wut.downvotes++;
            QuestionRepository.save(wut);
        }
        return "redirect:/";
    }
}
