package com.fight.club.fighter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fight.club.base.Person;

@Entity
@Table(name = "fighters")
public class Fighter extends Person {
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "fighter_category", joinColumns = @JoinColumn(name = "fighter_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories;

	protected Set<Category> getCategoriesInternal() {
		if (this.categories == null) {
			this.categories = new HashSet<>();
		}
		return this.categories;
	}

	protected void setCategoriesInternal(Set<Category> categories) {
		this.categories = categories;
	}

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
}
