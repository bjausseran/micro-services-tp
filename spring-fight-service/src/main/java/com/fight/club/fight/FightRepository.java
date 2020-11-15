package com.fight.club.fight;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FightRepository extends CrudRepository<Fight, Integer> {

	List<Fight> findByFighterId(Integer fighterId);


}
