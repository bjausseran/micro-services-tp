package com.fight.club.fighter;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.fight.club.base.NamedEntity;
@Entity
@Table(name = "categories")
public class Category extends NamedEntity implements Serializable{

}
