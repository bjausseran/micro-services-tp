package org.springframework.samples.fightclub.fighter;

import java.util.Collection;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Repository class for <code>Fighter</code> domain objects All method names are compliant
 * with Spring Data naming conventions so this interface can easily be extended for Spring
 * Data. See:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 */

@FeignClient(value = "fighter-service")
public interface FighterRepository {

	@GetMapping(path = { "/fighters" }, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	Collection<Fighter> findAll();

	@GetMapping("/fighter-categories")
	List<Category> findFighterCategory();

	@GetMapping("/fighters/{id}")
	public Fighter findById(@PathVariable("id") Integer id);
	
	@PostMapping("/fighters")
	Fighter save(Fighter fighter);

}