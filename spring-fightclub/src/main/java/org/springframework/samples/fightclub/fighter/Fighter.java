package org.springframework.samples.fightclub.fighter;

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
import org.springframework.samples.fightclub.model.Person;

import com.sun.xml.txw2.annotation.XmlElement;

public class Fighter extends Person {
	private Set<Category> categories;
	private Set<Fight> fights;

	protected Set<Category> getCategoriesInternal() {
		if (this.categories == null) {
			this.categories = new HashSet<>();
		}
		return this.categories;
	}

	protected void setCategoriesInternal(Set<Category> categories) {
		this.categories = categories;
	}

	@XmlElement
	public List<Category> getCategories() {
		List<Category> sortedSpecs = new ArrayList<>(getCategoriesInternal());
		PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedSpecs);
	}

	public int getNrOfCategories() {
		return getCategoriesInternal().size();
	}

	public void addCategory(Category category) {
		getCategoriesInternal().add(category);
	}
	
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

	public void addFight(Fight fight, boolean isA) {
		getFightsInternal().add(fight);
		if(isA) fight.setFighterAId(this.getId());
		else fight.setFighterBId(this.getId());
	}

}
