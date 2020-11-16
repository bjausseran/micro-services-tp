package org.springframework.samples.fightclub.fight;


import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.samples.fightclub.arena.Arena;
import org.springframework.samples.fightclub.arena.ArenaRepository;
import org.springframework.samples.fightclub.fighter.Fighter;
import org.springframework.samples.fightclub.fighter.FighterRepository;
import org.springframework.samples.fightclub.fighter.Fighters;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;

public class FightController {
	private final FightRepository fights;
	private final ArenaRepository arenas;
	private final FighterRepository fighters;

	public FightController(FightRepository fights, ArenaRepository arenas, FighterRepository fighters) {
		this.fights = fights;
		this.arenas = arenas;
		this.fighters = fighters;
	}


	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	/**
	 * Called before each and every @RequestMapping annotated method. 2 goals: - Make sure
	 * we always have fresh data - Since we do not use the session scope, make sure that
	 * Fighter object always has an id (Even though id is not part of the form fields)
	 * @param fighterId
	 * @return Fighter
	 */

	@ModelAttribute("fight")
	public Fight loadFighterWithFight(@PathVariable("fighterId") int fighterId, boolean isA, Map<String, Object> model) {
		Fighter fighter = this.fighters.findById(fighterId);
		fighter.setFightsInternal(this.fights.findByFighterId(fighterId));
		model.put("fighter", fighter);
		Fight fight = new Fight();
		fighter.addFight(fight, isA);
		return fight;
	}


	@ModelAttribute("fight")
	public Fight loadArenaWithFight(@PathVariable("arenaId") int arenaId, Map<String, Object> model) {
		Arena arena = this.arenas.findById(arenaId);
		arena.setFightsInternal(this.fights.findByArenaId(arenaId));
		model.put("arena", arena);
		Fight fight = new Fight();
		arena.addFight(fight);
		return fight;
	}
	/*
	@GetMapping("/fights.html")
	public String showFightList(Map<String, Object> model) {
		// Here we are returning an object of type 'Fighters' rather than a collection of Fighter
		// objects so it is simpler for Object-Xml mapping
		Fight fight = new Fight();
		fighters.getFightList().addAll(this.fighters.findAll());
		model.put("fighters", fighters);
		return "fighters/fighterList";
	}

	@GetMapping({ "/fights" })
	public @ResponseBody Fighters showResourcesFighterList() {
		// Here we are returning an object of type 'Fighters' rather than a collection of Fighter
		// objects so it is simpler for JSon/Object mapping
		Fighters fighters = new Fighters();
		fighters.getFighterList().addAll(this.fighters.findAll());
		return fighters;
	}
*/
	// Spring MVC calls method loadFighterWithVisit(...) before initNewVisitForm is called
	@GetMapping("/fights/new")
	public String initNewFightForm(@PathVariable("fighterId") int fighterId, 
			@PathVariable("arenaId") int arenaId, Map<String, Object> model) {
		return "fights/createOrUpdateFightForm";
	}

	// Spring MVC calls method loadFighterWithVisit(...) before processNewVisitForm is called
	@PostMapping("/fights/new")
	public String processNewFightForm(@Valid Fight fight, BindingResult result) {
		if (result.hasErrors()) {
			return "fights/createOrUpdateFightForm";
		}
		else {
			this.fights.save(fight.getDate(), fight.getArenaId(), fight.getFighterAId(), fight.getFighterBId());
			return "redirect:/fights/";
		}
	}

}
