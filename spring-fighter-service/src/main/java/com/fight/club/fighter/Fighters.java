package com.fight.club.fighter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Fighters {
	private List<Fighter> fighters;

	@XmlElement
	public List<Fighter> getFighterList() {
		if (fighters == null) {
			fighters = new ArrayList<>();
		}
		return fighters;
	}
}
