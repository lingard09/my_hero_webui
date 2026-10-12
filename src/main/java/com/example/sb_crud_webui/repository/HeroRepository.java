package com.example.sb_crud_webui.repository;

import com.example.sb_crud_webui.domain.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroRepository {
    Hero save(Hero hero);
    List<Hero> findAll();
    List<Hero> findByName(String name);
    Optional<Hero> findById(Long id);
    Hero update(Hero hero);
    void deleteById(Long id);
}
