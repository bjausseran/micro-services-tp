package com.fight.club.arena;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fight.club.arena.Arena;

public interface ArenaRepository extends CrudRepository<Arena, Integer> {

	List<Arena> findByArenaId(Integer petId);


}
