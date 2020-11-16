package org.springframework.samples.fightclub.fighter;

import java.util.Collection;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.samples.fightclub.fighter.FighterRepository;

@RestController
class FighterController {
	private final FighterRepository fighters;

	public FighterController(FighterRepository fightclubService) {
		this.fighters = fightclubService;
	}

	@GetMapping("/fighters.html")
	public String showFighterList(Map<String, Object> model) {
		// Here we are returning an object of type 'Fighters' rather than a collection of Fighter
		// objects so it is simpler for Object-Xml mapping
		Fighters fighters = new Fighters();
		fighters.getFighterList().addAll(this.fighters.findAll());
		model.put("fighters", fighters);
		return "fighters/fighterList";
	}

	@GetMapping({ "/fighters" })
	public @ResponseBody Fighters showResourcesFighterList() {
		// Here we are returning an object of type 'Fighters' rather than a collection of Fighter
		// objects so it is simpler for JSon/Object mapping
		Fighters fighters = new Fighters();
		fighters.getFighterList().addAll(this.fighters.findAll());
		return fighters;
	}

}
