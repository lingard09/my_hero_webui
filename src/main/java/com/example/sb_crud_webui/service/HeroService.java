package com.example.sb_crud_webui.service;

import com.example.sb_crud_webui.domain.Hero;
import com.example.sb_crud_webui.dto.HeroRequest;
import com.example.sb_crud_webui.dto.HeroResponse;
import com.example.sb_crud_webui.repository.HeroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HeroService {
    private final HeroRepository repository;

    public HeroService(HeroRepository repository) {
        this.repository = repository;
    }

    public HeroResponse create(HeroRequest r) {
        validate(r);
        return toResponse(repository.save(new Hero(null, r.name(), r.role(), r.health(), r.nationality(), r.gender())));
    }

    public List<HeroResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public List<HeroResponse> findByName(String name) {
        return repository.findByName(name).stream().map(this::toResponse).toList();
    }

    public HeroResponse findById(Long id) {
        return toResponse(findHero(id));
    }

    public HeroResponse update(Long id, HeroRequest r) {
        Hero h = findHero(id);
        validate(r);
        h.setName(r.name());
        h.setRole(r.role());
        h.setHealth(r.health());
        h.setNationality(r.nationality());
        h.setGender(r.gender());
        return toResponse(repository.update(h));
    }

    public void delete(Long id) {
        findHero(id);
        repository.deleteById(id);
    }

    private Hero findHero(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero not found: " + id));
    }

    private HeroResponse toResponse(Hero h) {
        return new HeroResponse(h.getId(), h.getName(), h.getRole(), h.getHealth(), h.getNationality(), h.getGender());
    }

    private void validate(HeroRequest r) {
        if (r.name() == null || r.name().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name은 필수입니다.");
        }
        if (r.health() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "health는 0 이상입니다.");
        }
    }
}
