/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.fightclub.fight;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.samples.fightclub.model.BaseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Repository class for <code>Fight</code> domain objects All method names are compliant
 * with Spring Data naming conventions so this interface can easily be extended for Spring
 * Data. See:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 */
@FeignClient(value = "fight-service")
public interface FightRepository {

	/**
	 * Save a <code>Fight</code> to the data store, either inserting or updating it.
	 * @param visit the <code>Fight</code> to save
	 * @see BaseEntity#isNew
	 */

	@PostMapping("/fights")
	void save(@RequestParam("date") LocalDate date, 
			@RequestParam("arenaId") Integer arenaId,
			@RequestParam("fighterAId") Integer fighterAId,
			@RequestParam("fighterBId") Integer fighterBId);

	
	@GetMapping("/fights/findByFighterId/{fighterId}")
	public Collection<Fight> findByFighterId(@PathVariable("fighterId") Integer fighterId);
	
	@GetMapping("/fights/findByArenaId/{arenaId}")
	public Collection<Fight> findByArenaId(@PathVariable("arenaId") Integer arenaId);


}
