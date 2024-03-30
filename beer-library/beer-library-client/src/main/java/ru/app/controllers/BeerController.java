package ru.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class BeerController {

    @GetMapping("/library")
    public String listPage() {
        return "beer_list";
    }

    @GetMapping("library/edit/{id}")
    public String editPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("id", id);
        return "beer_edit";
    }

    @GetMapping("/library/create")
    public String createPage() {
        return "beer_create";
    }

    @GetMapping("/access-denied")
    public String accessDeniedPage() {
        return "access-denied";
    }

}