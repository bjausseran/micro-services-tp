package com.fight.club.fighter;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
class FighterController {
	private final FighterRepository fighters;
	private final CategoryRepository categories;

	public FighterController(FighterRepository figherService, CategoryRepository categories) {
		this.fighters = figherService;
		this.categories = categories;
	}

	@GetMapping(path = { "/fighters" }, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Fighter> showResourcesFighterList() {
		return fighters.findAll();
	}

	@PostMapping(path = "/fighters")
	public Fighter addFighter(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("firstCategory") String firstCategory) {
		Fighter fighter = new Fighter();
		fighter.setFirstName(firstName);
		fighter.setLastName(lastName);

		Category category = new Category();
		category.setName(firstCategory);
		categories.save(category);
		fighter.addCategory(category);
		return fighters.save(fighter);
	}

}
