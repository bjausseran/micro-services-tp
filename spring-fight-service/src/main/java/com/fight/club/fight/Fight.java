package com.fight.club.fight;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fight.club.base.BaseEntity;

@Entity
@Table(name = "fights")
public class Fight {

}
