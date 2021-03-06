package com.fight.club.fight;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fight.club.base.BaseEntity;

@Entity
@Table(name = "fights")
public class Fight extends BaseEntity {

	@Column(name = "fight_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@NotEmpty
	@Column(name = "arena_id")
	private Integer arenaId;

	@NotEmpty
	@Column(name = "fighterA_id")
	private Integer fighterAId;

	@NotEmpty
	@Column(name = "fighterB_id")
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

	public Integer getFightAId() {
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
