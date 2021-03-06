package com.fight.club.arena;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fight.club.arena.Arena;
import com.fight.club.arena.ArenaRepository;

public class ArenaController {
	private final ArenaRepository arenas;

	public ArenaController(ArenaRepository arenas) {
		this.arenas = arenas;
	}

	@GetMapping("/arenas")
	public Iterable<Arena> getArenas() {
		return arenas.findAll();
	}

	@GetMapping("/arenas/{id}")
	public Optional<Arena> getFightById(@PathVariable("id") Integer id) {
		return arenas.findById(id);
	}

	@PostMapping("/arenas")
	public Arena addFight(
			@RequestParam("name") String name)
	{
		Arena arena = new Arena();
		arena.setName(name);
		return arenas.save(arena);
	}

	@DeleteMapping("/arenas/{id}")
	public void deleteFight(@PathVariable("id") Integer id) {
		arenas.deleteById(id);
	}
	
	@GetMapping("/arenas/findByArenaId/{petId}")
	public Iterable<Arena> findByArenaId(@PathVariable("arenaId") Integer arenaId) {
		return arenas.findByArenaId(arenaId);
	}

}
