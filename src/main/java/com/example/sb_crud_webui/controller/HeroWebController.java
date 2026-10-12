package com.example.sb_crud_webui.controller;

import com.example.sb_crud_webui.dto.HeroRequest;
import com.example.sb_crud_webui.dto.HeroResponse;
import com.example.sb_crud_webui.service.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroWebController {
    private final HeroService heroService;

    public HeroWebController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping
    public ResponseEntity<HeroResponse> create(@RequestBody HeroRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(heroService.create(request));
    }

    @GetMapping
    public List<HeroResponse> findAll() {
        return heroService.findAll();
    }

    @GetMapping("/search")
    public List<HeroResponse> findByName(@RequestParam String name) {
        return heroService.findByName(name);
    }

    @GetMapping("/{id}")
    public HeroResponse findById(@PathVariable Long id) {
        return heroService.findById(id);
    }

    @PutMapping("/{id}")
    public HeroResponse update(@PathVariable Long id, @RequestBody HeroRequest request) {
        return heroService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        heroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
