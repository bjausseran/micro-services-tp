package org.springframework.samples.fightclub.arena;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.samples.fightclub.arena.Arena;
import org.springframework.samples.fightclub.arena.ArenaRepository;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ArenaController {
	private final ArenaRepository arenas;
	private static final String VIEWS_ARENAS_CREATE_OR_UPDATE_FORM = "arenas/createOrUpdateArenaForm";

	public ArenaController(ArenaRepository arenas) {
		this.arenas = arenas;
	}


	@GetMapping("/arenas/new")
	public String initCreationForm(ModelMap model) {
		Arena arena = new Arena();
		return VIEWS_ARENAS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/arenas/new")
	public String processCreationForm(@Valid Arena arena, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.put("arena", arena);
			return VIEWS_ARENAS_CREATE_OR_UPDATE_FORM;
		}
		else {
			Arena newArena = this.arenas.save(arena);
			return "redirect:/arenas";
		}
	}

	@GetMapping("/arenas/{arenaId}/edit")
	public String initUpdateForm(@PathVariable("arenaId") int arenaId, ModelMap model) {
		Arena arena = this.arenas.findById(arenaId);
		model.put("arena", arena);
		return VIEWS_ARENAS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/arenas/{arenaId}/edit")
	public String processUpdateForm(@Valid Arena arena, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.put("arena", arena);
			return VIEWS_ARENAS_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.arenas.save(arena);
			return "redirect:/owners/{ownerId}";
		}
	}


}
