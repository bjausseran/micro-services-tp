package com.fight.club.arena;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fight.club.base.NamedEntity;

public class Arena extends NamedEntity{
	
	@NotEmpty
	@Column(name = "available")
	private Boolean available;

}
