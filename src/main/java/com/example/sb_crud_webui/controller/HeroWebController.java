package com.example.sb_crud_webui.controller;

import com.example.sb_crud_webui.domain.Hero;
import com.example.sb_crud_webui.dto.HeroRequest;
import com.example.sb_crud_webui.dto.HeroResponse;
import com.example.sb_crud_webui.service.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/heroes")
public class HeroWebController {
    private final HeroService heroService;

    public HeroWebController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("heroes", heroService.findAll());
        return "heroes/list";
    }

    @GetMapping("/new")
    public String form() {
        return "heroes/form";
    }

    @PostMapping
    public String create(@ModelAttribute HeroRequest request) {
        heroService.create(request);

        return "redirect:/heroes";
    }
}
