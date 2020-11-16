package org.springframework.samples.fightclub.fight;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.fightclub.model.BaseEntity;

public class Fight extends BaseEntity {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@NotEmpty
	private Integer arenaId;

	@NotEmpty
	private Integer fighterAId;

	@NotEmpty
	private Integer fighterBId;
	/**
	 * Creates a new instance of Fight for the current date
	 */
	public Fight() {
		this.date = LocalDate.now();
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getArenaId() {
		return this.arenaId;
	}

	public void setArenaId(Integer arenaId) {
		this.arenaId = arenaId;
	}

	public Integer getFighterAId() {
		return this.fighterAId;
	}

	public void setFighterAId(Integer petId) {
		this.fighterAId = petId;
	}
	public Integer getFighterBId() {
		return this.fighterBId;
	}

	public void setFighterBId(Integer petId) {
		this.fighterBId = petId;
	}

}
