package com.fight.club.fight;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class FightController {
	private final FightRepository fights;

	public FightController(FightRepository fights) {
		this.fights = fights;
	}

	@GetMapping("/fights")
	public Iterable<Fight> getFights() {
		return fights.findAll();
	}

	@GetMapping("/fights/{id}")
	public Optional<Fight> getFightById(@PathVariable("id") Integer id) {
		return fights.findById(id);
	}

	@PostMapping("/fights")
	public Fight addFight(
			@RequestParam("date") LocalDate date, 
			@RequestParam("arenaId") Integer arenaId,
			@RequestParam("fighterAId") Integer fighterAId, 
			@RequestParam("fighterBId") Integer fighterBId) 
	{
		Fight fight = new Fight();
		fight.setDate(date);
		fight.setArenaId(arenaId);
		fight.setFighterAId(fighterAId);
		fight.setFighterBId(fighterBId);
		return fights.save(fight);
	}

	@DeleteMapping("/fights/{id}")
	public void deleteFight(@PathVariable("id") Integer id) {
		fights.deleteById(id);
	}
	
	@GetMapping("/fights/findByFighterId/{fighterId}")
	public Iterable<Fight> findByFighterId(@PathVariable("fighterId") Integer fighterId) {
		return fights.findByFighterId(fighterId);
	}

}
