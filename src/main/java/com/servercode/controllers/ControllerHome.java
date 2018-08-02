package com.servercode.controllers;

import com.servercode.model.Questions;
import com.servercode.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerHome {
    @Autowired
    QuestionRepository QuestionRepository;

    @RequestMapping("/")
    public String home(Model model) {
        System.out.println("hit home controller");

        Date date = new Date();
        model.addAttribute("currenttime", date.toString());

        List<Questions> question = QuestionRepository.findAll();
        Collections.sort(question);
        model.addAttribute("question", question);

        return "index";
    }
}