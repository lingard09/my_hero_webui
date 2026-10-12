package com.example.sb_crud_webui.repository;

import com.example.sb_crud_webui.domain.Hero;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryHeroRepository implements HeroRepository{
    private final Map<Long, Hero> store = new LinkedHashMap<>();
    private long sequence = 0L;

    @Override
    public Hero save(Hero hero) {
        sequence++;
        hero.setId(sequence);
        store.put(hero.getId(), hero);
        return hero;
    }

    @Override
    public List<Hero> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Hero> findByName(String name) {
        return store.values().stream().filter(h -> h.getName().contains(name)).toList();
    }

    @Override
    public Optional<Hero> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Hero update(Hero hero) {
        store.put(hero.getId(), hero);
        return hero;
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

}
