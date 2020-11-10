package com.fight.club.fighter;
import java.util.Collection;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	@Transactional(readOnly = true)
	@Cacheable("fighters")
	Collection<Category> findAll() throws DataAccessException;
}
