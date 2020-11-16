package org.springframework.samples.fightclub.arena;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.fightclub.fight.Fight;

import org.springframework.samples.fightclub.model.NamedEntity;

public class Arena extends NamedEntity{
	private Set<Fight> fights;
	
	@NotEmpty
	private Boolean available;
	
	public Set<Fight> getFightsInternal() {
		if (this.fights == null) {
			this.fights = new HashSet<>();
		}
		return this.fights;
	}

	public void setFightsInternal(Collection<Fight> fights) {
		this.fights = new LinkedHashSet<>(fights);
	}

	public List<Fight> getFights() {
		List<Fight> sortedFights = new ArrayList<>(getFightsInternal());
		PropertyComparator.sort(sortedFights, new MutableSortDefinition("date", false, false));
		return Collections.unmodifiableList(sortedFights);
	}

	public void addFight(Fight fight) {
		getFightsInternal().add(fight);
		fight.setArenaId(this.getId());
	}

}
